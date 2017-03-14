package com.gwtjs.core.log;

/**
 * 日志记录接口
 * 
 * @author aGuang
 *
 */
public interface ILogger {

	/**
	 * 记录调试日志信息
	 * 
	 * @param message
	 */
	void trace(String message);

	/**
	 * 记录调试日志信息
	 * 
	 * @param message
	 */
	void trace(String message, Object... params);

	/**
	 * 记录调试日志信息
	 * 
	 * @param message
	 */
	void debug(String message);

	/**
	 * 记录调试日志信息
	 * 
	 * @param message
	 * @param params
	 */
	void debug(String message, Object... params);

	/**
	 * 记录调试日志信息
	 * 
	 * @param t
	 */
	void debug(Throwable t);

	/**
	 * 记录调试日志信息
	 * 
	 * @param message
	 * @param t
	 */
	void debug(String message, Throwable t);

	/**
	 * 记录调试日志信息
	 * 
	 * @param message
	 * @param params
	 * @param t
	 */
	void debug(String message, Object[] params, Throwable t);

	/**
	 * 记录Info日志
	 * 
	 * @param message
	 */
	void info(String message);

	/**
	 * 记录Info日志
	 * 
	 * @param message
	 * @param params
	 */
	void info(String message, Object... params);

	/**
	 * 记录Info日志
	 * 
	 * @param t
	 */
	void info(Throwable t);

	/**
	 * 记录Info日志
	 * 
	 * @param message
	 * @param t
	 */
	void info(String message, Throwable t);

	/**
	 * 记录Info日志
	 * 
	 * @param message
	 * @param params
	 * @param t
	 */
	void info(String message, Object[] params, Throwable t);

	/**
	 * 记录警告日志
	 * 
	 * @param message
	 */
	void warn(String message);

	/**
	 * 记录警告日志
	 * 
	 * @param message
	 * @param params
	 */
	void warn(String message, Object... params);

	/**
	 * 记录警告日志
	 * 
	 * @param t
	 */
	void warn(Throwable t);

	/**
	 * 记录警告日志
	 * 
	 * @param message
	 * @param t
	 */
	void warn(String message, Throwable t);

	/**
	 * 记录警告日志
	 * 
	 * @param message
	 * @param params
	 * @param t
	 */
	void warn(String message, Object[] params, Throwable t);

	/**
	 * 记录错误日志
	 * 
	 * @param message
	 */
	void error(String message);

	/**
	 * 记录错误日志
	 * 
	 * @param message
	 * @param params
	 */
	void error(String message, Object... params);

	/**
	 * 记录错误日志
	 * 
	 * @param t
	 */
	void error(Throwable t);

	/**
	 * 记录错误日志
	 * 
	 * @param message
	 * @param t
	 */
	void error(String message, Throwable t);

	/**
	 * 记录错误日志
	 * 
	 * @param message
	 * @param params
	 * @param t
	 */
	void error(String message, Object[] params, Throwable t);

	/**
	 * 记录致命错误日志
	 * 
	 * @param message
	 */
	void fatal(String message);

	/**
	 * 记录致命错误日志
	 * 
	 * @param message
	 * @param params
	 */
	void fatal(String message, Object... params);

	/**
	 * 记录致命错误日志
	 * 
	 * @param t
	 */
	void fatal(Throwable t);

	/**
	 * 记录致命错误日志
	 * 
	 * @param message
	 * @param t
	 */
	void fatal(String message, Throwable t);

	/**
	 * 记录致命错误日志
	 * 
	 * @param message
	 * @param params
	 * @param t
	 */
	void fatal(String message, Object[] params, Throwable t);

	/**
	 * 调试功能是否启用
	 * 
	 * @author aGuang
	 * @since
	 * @return
	 */
	boolean isDebugEnabled();
}
