package com.gwtjs.core.util;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamUtils {
	
	public static InputStream getInputStream(Class<?> basePathClazz,
			String resourceName){
		InputStream stream = null;
		try {
			stream = basePathClazz.getResource(resourceName).openStream();
		} catch (IOException e) {
			e.printStackTrace();
		}/*finally{
			try {
				stream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
		return stream;
	}
	
	/**
	 * 这种写法可以压缩字符，没有换行
	 * 
	 * @param is
	 * @return
	 */
	public static String convertStreamToString(InputStream is) {
		if (is == null) {
			return "";
		}
		BufferedReader reader = new BufferedReader(new InputStreamReader(is));
		StringBuilder sb = new StringBuilder();
		String line = null;
		try {
			while ((line = reader.readLine()) != null) {
				sb.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				is.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return sb.toString();

	}
	
	/**
	 * 获取html的内容,截取body中的html
	 * 
	 * @param in
	 * @return
	 * @throws IOException
	 */
	public static String inputBodyStreamString(InputStream in) throws IOException {
		StringBuffer out = new StringBuffer();
		byte[] b = new byte[4096];
		for (int n; (n = in.read(b)) != -1;) {
			out.append(new String(b, 0, n));
		}
		String result = out.toString();
		// 内容部分从body内获取．去头去尾．自己的脚本参考index.html
		int bodyStart = result.lastIndexOf("<body>");
		int bodyEnd = result.lastIndexOf("</body>");
		if (bodyStart == -1) {
			bodyStart = 0;
		}
		if (bodyEnd == -1) {
			bodyEnd = result.length();
		}
		result = result.substring(bodyStart, bodyEnd);
		return result;
	}
	
	/**
	 * 构建拼装html,css和js头部和尾部传空即可
	 * @param headIn
	 * @param footerIn
	 * @param contentIn
	 * @return
	 * @throws IOException
	 */
	public static InputStream buildOutStream(InputStream headIn, InputStream footerIn,InputStream contentIn) throws IOException
	{
		InputStream inWithCode = null;
		String html = "";
		if(headIn != null){
			html += InputStreamUtils.convertStreamToString(headIn);
		}
		if (contentIn != null) {
			html += InputStreamUtils.inputBodyStreamString(contentIn);
		}
		if (footerIn != null) {
			html += InputStreamUtils.convertStreamToString(footerIn);
		}
		if (html.length()>0) {
			inWithCode = new ByteArrayInputStream(html.getBytes("UTF-8"));
		}
		return inWithCode;
	}
	
}
