package com.gwtjs.common.util;

import com.gwtjs.common.util.spring.StringUtils;
public class StringUtil {
	
	static public String join(Object[] arrray,String separator){
		return StringUtils.arrayToDelimitedString(arrray,separator);
	}
	
}
