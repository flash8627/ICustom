package com.gwtjs.core.intercepts;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
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

/**
 * 拦截处理类
 * 
 * 此类使用MyBatis的插件扩展机制， 拦截需要返回ResultSet 包装结果并将其返回
	 * Created：2016-3-30
	 * @author aGuang
 * 
 */

@Intercepts({ @Signature(type = Executor.class, method = "query", args = {
		MappedStatement.class, Object.class, RowBounds.class,
		ResultHandler.class }) })
public class ResultSetInterceptor implements Interceptor {
	private static final Logger log = LoggerFactory
			.getLogger(ResultSetInterceptor.class);
	private static final Log statementLog = LogFactory
			.getLog(ResultSetInterceptor.class);

	private static final int INDEX_MAPPED_STATEMENT = 0;

	private static final int INDEX_PARAMETER = 1;

	private static final int INDEX_ROW_BOUNDS = 2;

	private static final int INDEX_RESULT_HANDLER = 3;

	/**
	 * 拦截方法
	 * 
	 * @param invocation
	 *            拦截目标对象
	 * @return 拦截后的结果
	 * @throws Throwable
	 * Created：2016-3-30
	 * @author aGuang
	 */
	public Object intercept(Invocation invocation) throws Throwable {

		Object[] queryArgs = invocation.getArgs();
		MappedStatement mappedStatement = (MappedStatement) queryArgs[INDEX_MAPPED_STATEMENT];
		// 检查是否 是返回resultset
		if (checkResultSet(mappedStatement)) {
			Object sqlString = getResultSetSql(invocation, queryArgs);
			return sqlString;
		}
		return invocation.proceed();
	}

	/**
	 * 获取我们要查询的结果集sql
	 * 
	 * @param invocation
	 * @param queryArgs
	 * @return
	 * @throws SQLException
	 * Created：2016-3-30
	 * @author aGuang
	 */
	private Object getResultSetSql(Invocation invocation, Object[] queryArgs)
			throws SQLException {
		// 定义需要的变量
		final Object parameter = queryArgs[INDEX_PARAMETER];
		final RowBounds rowBounds = (RowBounds) queryArgs[INDEX_ROW_BOUNDS];
		ResultHandler resultHandler = (ResultHandler) queryArgs[INDEX_RESULT_HANDLER];
		MappedStatement mappedStatement = (MappedStatement) queryArgs[INDEX_MAPPED_STATEMENT];
		Configuration configuration = mappedStatement.getConfiguration();
		BoundSql boundSql = mappedStatement.getBoundSql(parameter);
		Executor executor = (Executor) invocation.getTarget();
		Statement stmt = null;
		Connection connection = null;
		StatementHandler handler = configuration.newStatementHandler(executor,
				mappedStatement, parameter, rowBounds, resultHandler, boundSql);
		/*List<JalorResultSet> returnList = new ArrayList<JalorResultSet>();*/
		try {
			// 从Executor中获取事务的连接
			/*connection = ConnectionLogger.newInstance(executor.getTransaction()
					.getConnection(), statementLog);*/
			stmt = handler.prepare(connection);
			handler.parameterize(stmt);
			/*JalorResultSet resultSet = new JalorResultSet();
			Object ohj = ReflectUtil.getFieldValue(stmt, "h");
			// 获取预编译中的 sql 和 参数value
			// resultSet.setResultSetSql((String) ReflectUtil.getFieldValue(ohj,
			// "sql"));
			resultSet.setResultSetSql(handler.getBoundSql().getSql());
			resultSet.setParameter((List<Object>) ReflectUtil.getFieldValue(
					ohj, "columnValues"));
			returnList.add(resultSet);*/
			return null;//returnList;
		} catch (SQLException ex) {
			log.error("ERROR","ERROR",ex);
			throw ex;
		} catch (RuntimeException e) {
			log.error("ERROR","ERROR",e);
			throw e;
		} finally {
			tryCloseStatement(stmt);
			tryCloseConnection(connection);
		}

	}

	/**
	 * dao xml文件配置返回了类型是否是 JalorResultSet
	 * 
	 * @param mappedStatement
	 * Created：2016-3-30
	 * @author aGuang
	 */
	private boolean checkResultSet(MappedStatement mappedStatement) {
		// 如果不存在返回类型 那么直接返回false
		/*if (CollectionUtil.isNullOrEmpty(mappedStatement.getResultMaps())
				|| mappedStatement.getResultMaps().get(0) == null) {
			return false;
		}
		Class resultType = mappedStatement.getResultMaps().get(0).getType();
		// 如果类型的JalorResultSet相同 那么返回true
		if (JalorResultSet.class.getName().equals(resultType.getName())) {
			return true;
		}*/
		return false;
	}

	/**
	 * 尝试关闭
	 * 
	 * @param stmt
	 * Created：2016-3-30
	 * @author aGuang
	 */
	private void tryCloseConnection(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				connection = null;
				log.error("ERROR",e);
			}
		}
	}

	/**
	 * 尝试关闭
	 * 
	 * @param stmt
	 */
	private void tryCloseStatement(Statement stmt) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				stmt = null;
				log.error("ERROR",e);
			}
		}
	}

	/**
	 * 插件方法
	 * 
	 * @param target
	 * Created：2016-3-30
	 * @author aGuang
	 */
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.ibatis.plugin.Interceptor#setProperties(java.util.Properties)
	 */
	public void setProperties(Properties arg0) {
	}

}
