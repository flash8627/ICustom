package com.gwtjs.common.intercepts;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.Interceptor;
import org.apache.ibatis.plugin.Intercepts;
import org.apache.ibatis.plugin.Invocation;
import org.apache.ibatis.plugin.Plugin;
import org.apache.ibatis.plugin.Signature;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.SystemMetaObject;
import org.apache.ibatis.session.RowBounds;

import com.gwtjs.common.entity.PagerVO;

@Intercepts({ @Signature(type = StatementHandler.class, method = "prepare", args = { Connection.class }) })
public class PageInterceptor implements Interceptor {

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler = (StatementHandler) invocation.getTarget();
		MetaObject metaStatementHandler = MetaObject.forObject(statementHandler, SystemMetaObject.DEFAULT_OBJECT_FACTORY, SystemMetaObject.DEFAULT_OBJECT_WRAPPER_FACTORY);
		BoundSql boundSql = statementHandler.getBoundSql();
		MappedStatement mappedStatement = (MappedStatement) metaStatementHandler.getValue("delegate.mappedStatement");
		String sqlId = mappedStatement.getId();
		System.out.println("sql语句的id : " + sqlId);
		Object param = boundSql.getParameterObject();
		// 检查是否需要拦截，如果需要，那么返回page对象
		PagerVO page = checkInvocation(sqlId, param);
		System.out.println("PagerVO:"+page);
		if (null != param && Map.class.isAssignableFrom(param.getClass())) {
			Map paramMap = (Map) param;
			int pageSize = page.getPageSize();
			int curPage = page.getCurPage();
			setTotalResult(boundSql, (Connection) invocation.getArgs()[0], metaStatementHandler, paramMap);
			//String sql = getPageSql(pageSize, curPage, boundSql);
			//metaStatementHandler.setValue("delegate.boundSql.sql", sql);
			//metaStatementHandler.setValue("delegate.rowBounds.offset", RowBounds.NO_ROW_OFFSET);
			//metaStatementHandler.setValue("delegate.rowBounds.limit", RowBounds.NO_ROW_LIMIT);
		}
		return invocation.proceed();
	}

        // 这个分页方法是借助于网上的
	/*private String getPageSql(int pageSize, int pageNo, BoundSql boundSql) {
		StringBuffer sql = new StringBuffer(boundSql.getSql());
		sql.insert(0, "select u.*, rownum r from (").append(") u where rownum < ").append(pageSize * pageNo);
		sql.insert(0, "select * from (").append(") where r >= ").append((pageSize - 1) * pageNo);
		return sql.toString();
	}*/
	
	private void setTotalResult(BoundSql boundSql, Connection conn, MetaObject metaObject, Map param) throws SQLException {
		String countSql = "select count(*) from ( " + boundSql.getSql() + " ) total";
		PreparedStatement prepareStatement = conn.prepareStatement(countSql);
		ParameterHandler parameterHandler = (ParameterHandler) metaObject.getValue("delegate.parameterHandler");
		parameterHandler.setParameters(prepareStatement); // 给sql语句设置参数
		ResultSet resultSet = prepareStatement.executeQuery();
		if (resultSet.next()) {
			PagerVO vo = (PagerVO) param.get("1");
			Object total = resultSet.getObject(1);
			vo.setTotalRows(Integer.parseInt(total.toString()));
			param.put("1", vo);
			System.out.println(vo);
		}
		if (resultSet != null) {
			resultSet.close();
		}
		if (prepareStatement != null) {
			prepareStatement.close();
		}
	}
	
	private static final String COUNT_SQL_FIX = "Count";
	
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
	
	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}
	@Override
	public void setProperties(Properties properties) {

	}
}
