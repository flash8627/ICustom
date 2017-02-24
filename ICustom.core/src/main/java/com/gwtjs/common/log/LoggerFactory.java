package com.gwtjs.common.log;

/**
 * 继承LoggerFactory
 * 
 * @author aGuang
 * @since 2013-8-26
 */
public final class LoggerFactory {
	private LoggerFactory() {
	}

	/**
	 * 通过名字获取Logger
	 * 
	 * @param name
	 * @return
	 */
	public static ILogger getLogger(String name) {
		return Log4jLogger.getLog(name);
	}

	/**
	 * 通过Class获取日志记录器
	 * 
	 * @param clazz
	 * @return
	 */
	public static ILogger getLogger(Class<?> clazz) {
		return getLogger(clazz.getName());
	}
}
