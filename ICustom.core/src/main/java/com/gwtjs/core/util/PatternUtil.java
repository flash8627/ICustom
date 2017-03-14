package com.gwtjs.core.util;

import java.util.regex.Pattern;

/**
 * 正则工具类
 * 
 * @author l54883
 * @since 2012-6-4
 */
public final class PatternUtil {

	/**
	 * SQL 语句中的Order by 正则，避免非法字符
	 */
	public static final Pattern SQL_ORDER_BY = Pattern
			.compile("^[a-zA-Z0-9\\.\\s,_]+$");

}
