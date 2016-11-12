package com.gwtjs.core.intercepts;

import java.util.*;

import org.apache.ibatis.executor.*;
import org.apache.ibatis.mapping.*;
import org.apache.ibatis.mapping.MappedStatement.Builder;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.session.*;

import static com.gwtjs.common.util.StringUtil.*;

@Intercepts({
	@Signature(type = Executor.class,method="query",args={MappedStatement.class,Object.class,RowBounds.class,ResultHandler.class}),
	@Signature(type = Executor.class,method="update",args={MappedStatement.class,Object.class})
})
public class ProgramInterceptor implements Interceptor{
	
	/**
	 * 重新构建MappedStatement对象，用delegate的方式，接入ExtendedSqlSource
	 * Created：2016-3-30
	 * @author aGuang
	 */
	public MappedStatement buildMappedStatement(MappedStatement mappedStatement){
		String id=mappedStatement.getId();
		Configuration configuration=mappedStatement.getConfiguration();
		SqlSource sqlSource = mappedStatement.getSqlSource();
		SqlCommandType sqlCommandType = mappedStatement.getSqlCommandType();
		Builder builder = new Builder(configuration,id,new ExtendedSqlSource(configuration,sqlSource),sqlCommandType);
		
		builder.resource(mappedStatement.getResource());
		builder.parameterMap(mappedStatement.getParameterMap());
		builder.resultMaps(mappedStatement.getResultMaps());
		builder.fetchSize(mappedStatement.getFetchSize());
		builder.timeout(mappedStatement.getTimeout());
		builder.statementType(mappedStatement.getStatementType());
		builder.resultSetType(mappedStatement.getResultSetType());
		builder.cache(mappedStatement.getCache());
		builder.flushCacheRequired(mappedStatement.isFlushCacheRequired());
		builder.useCache(mappedStatement.isUseCache());
		builder.keyGenerator(mappedStatement.getKeyGenerator());
		builder.keyProperty(join(mappedStatement.getKeyProperties(), ","));
		return builder.build();
	}
	
	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		Object[] args = invocation.getArgs();
		MappedStatement stmt = (MappedStatement)args[0];
		args[0] = buildMappedStatement(stmt);
		return invocation.proceed();
	}

	@Override
	public Object plugin(Object target) {
		return Plugin.wrap(target, this);
	}

	@Override
	public void setProperties(Properties properties) {
	}

}
