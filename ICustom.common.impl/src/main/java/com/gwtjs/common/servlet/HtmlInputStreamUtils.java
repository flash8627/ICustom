package com.gwtjs.common.servlet;

import java.io.IOException;
import java.io.InputStream;

public class HtmlInputStreamUtils {
	
	public static InputStream getInputStream(Class<?> basePathClazz,
			String resourceName) throws IOException {
		return basePathClazz.getResource(resourceName).openStream();
	}
}
