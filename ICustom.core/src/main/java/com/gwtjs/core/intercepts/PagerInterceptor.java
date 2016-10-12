package com.gwtjs.core.intercepts;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.*;
import org.apache.ibatis.logging.jdbc.ConnectionLogger;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;

/**
 * 拦截分页处理类
 * <p>
 * 把分页统计和分页记录数合并； 使用mybatis机制拦截需要分页的sql,主要是查询记录的sql ID检测是否有{sqlId}Count
 * 如果有，包装结果并返回
 * </p>
 * 
 * @author aGuang
 *
 */
@Intercepts({ @Signature(type = Executor.class, method = "query", args = {
		MappedStatement.class, Object.class, RowBounds.class,
		ResultHandler.class }) })
public class PagerInterceptor implements Interceptor {

	private static final Logger log = LoggerFactory.getLogger(PagerInterceptor.class);
	
	private static final org.apache.ibatis.logging.Log statementLog = (org.apache.ibatis.logging.Log) org.slf4j.LoggerFactory.getLogger(PagerInterceptor.class);
	
	private static final int INDEX_MAPPED_STATEMENT = 0;
	private static final int INDEX_PARAMETER = 1;
	private static final int INDEX_ROW_BOUNDS = 0;
	private static final int INDEX_RESULT_HANDLER = 3;

	private static final int RESULT_MODE_ALL = 0;
	private static final int RESULT_MODE_TOTALROWS = 1;
	private static final int RESULT_MODE_DATASET = 2;

	private static final String COUNT_SQL_FIX = "Count";

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] queryArgs = invocation.getArgs();
		MappedStatement mappedStatement = (MappedStatement) queryArgs[INDEX_MAPPED_STATEMENT];
		String sqlId = mappedStatement.getId();
		Object parameter = queryArgs[INDEX_PARAMETER];
		PagerVO page = null;
		// 检查是否需要拦截，如果需要，那么返回page对象
		page = checkInvocation(sqlId, parameter);
		if (null == page) {
			return invocation.proceed();
		}
		// 如果有pagevo的参数，则拦截处理
		Executor executor = (Executor) invocation.getTarget();
		// 查count处理,总记录数存在则不再获取
		if (((page.getResultMode() == RESULT_MODE_ALL) && (page.getTotalRows() == 0))
				|| (page.getResultMode() == RESULT_MODE_TOTALROWS)) {
			queryCount(queryArgs, mappedStatement, sqlId, page, executor);
		}
		// 查询结果集处理
		List resultList = null;
		// 如果总数count>0才去执行列表sql语句
		if (((page.getResultMode() == RESULT_MODE_ALL) && (page.getTotalRows() > 0))
				|| (page.getResultMode() == RESULT_MODE_DATASET)) {
			// 查询结果集
			resultList = queryResultList(queryArgs, mappedStatement, executor);
			if (resultList.size() > page.getTotalRows()) {
				page.setTotalRows(resultList.size());
			}
		} else {
			resultList = new ArrayList<Object>();
		}
		PagedResult<?> result = new PagedResult<Object>();
		result.setPageVO(page);
		result.setResult(resultList);

		List<PagedResult> returnResult = new ArrayList<PagedResult>();
		returnResult.add(result);
		return returnResult;
	}

	private PagerVO checkInvocation(String sqlId, Object parameter) {
		// 如果参数为空，则不进行拦截
		if (null == parameter) {
			return null;
		}
		if (null != sqlId && !sqlId.endsWith(COUNT_SQL_FIX)) {
			return findPageVO(parameter);
		}
		return null;
	}

	/**
	 * 查询Count
	 */
	private void queryCount(Object[] queryArgs,
			MappedStatement mappedStatement, String sqlId, PagerVO page,
			Executor executor) throws SQLException {
		// 按命名规则查count的sql为原sqlId+Count
		String countSqlId = sqlId + COUNT_SQL_FIX;
		Configuration configuration = mappedStatement.getConfiguration();

		// 重新构建查询Count需要的变量
		MappedStatement queryCountSta = configuration
				.getMappedStatement(countSqlId);

		ProgramInterceptor pi = new ProgramInterceptor();
		MappedStatement newStatement = pi.buildMappedStatement(queryCountSta);
		// 查询count并设置到page中
		List<?> queryCountList = queryResultList(queryArgs, newStatement,
				executor);
		int totalRows = Integer.parseInt(queryCountList.get(0).toString());
		page.setTotalRows(totalRows);
	}

	/**
	 * 检查是否有page参数，并返回对象
	 * 
	 * @param parameter
	 * @return
	 */
	private PagerVO findPageVO(Object parameter) {
		if (null == parameter) {
			return null;
		}
		if (parameter instanceof Map) {
			Map<Object, Object> parameterMap = (Map) parameter;
			for (Map.Entry<Object, Object> entry : parameterMap.entrySet()) {
				if (entry.getValue() instanceof PagerVO) {
					return (PagerVO) entry.getValue();
				}
			}
		}
		if (parameter instanceof PagerVO) {
			return (PagerVO) parameter;
		}
		return null;
	}

	/**
	 * 查询结果集处理
	 */
	private List<?> queryResultList(final Object[] queryArgs,
			MappedStatement mappedStatement, Executor executor)
			throws SQLException {
		final Object parameter = queryArgs[INDEX_PARAMETER];
		final RowBounds rowBounds = (RowBounds) queryArgs[INDEX_ROW_BOUNDS];
		ResultHandler resultHandler = (ResultHandler) queryArgs[INDEX_RESULT_HANDLER];
		Configuration configuration = mappedStatement.getConfiguration();
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);

		// 查询结果集设置到page中
		StatementHandler handler = configuration.newStatementHandler(executor,
				mappedStatement, parameter, rowBounds, resultHandler, boundSql);
		Statement sm = null;
		List<?> resultList = new ArrayList<>();
		try {
			sm = prepareStatement(executor, handler);
			resultList = handler.query(sm, resultHandler);
			return resultList;
		} catch (SQLException e) {
			log.error(e.toString());
			throw e;
		} finally {
			tryCloseStatement(sm);
		}

	}

	/**
	 * 预处理Statement,并返回
	 */
	private Statement prepareStatement(Executor executor,
			StatementHandler handler) throws SQLException {
		Statement sm = null;
		// 从Excecutory中获取事务的连接,数值参数如何传
		Connection connection = ConnectionLogger.newInstance(executor
				.getTransaction().getConnection(), statementLog,0);
		try {
			sm = handler.prepare(connection);
			handler.parameterize(sm);
			;
			return sm;
		} catch (SQLException e) {
			tryCloseStatement(sm);
			throw e;
		} finally {
			tryCloseStatement(sm);
		}
	}

	/**
	 * 关闭statement
	 */
	private void tryCloseStatement(Statement sm) {
		if (sm != null) {
			try {
				sm.close();
			} catch (Exception e) {
				log.error(e.toString());
			}
		}
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
		// TODO Auto-generated method stub
	}

}
