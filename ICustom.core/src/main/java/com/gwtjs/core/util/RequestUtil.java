package com.gwtjs.core.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

/**
 * <h2>获取Request参数及对象</h2>
 * 
 * @author aGuang
 *         <p>
 *         TODO 说明 获取请求头\内置对象等参数.
 *         </p>
 *         <p>
 *         TODO 示例
 *         </p>
 * 
 *         <pre>
 * 示例代码:
 * </pre>
 */
public class RequestUtil {
	
	/**
	 * 获取请求前次页面信息
	 * 
	 * @param request
	 * @return
	 */
	static public String getReferer(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		Enumeration<String> sts = request.getHeaders("Referer");
		while (sts.hasMoreElements()) {
			sb.append(sts.nextElement());
		}
		return sb.toString();
	}

	/**
	 * 获取请求头信息
	 * 
	 * @param request
	 * @return
	 */
	static public String getUserAgent(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		Enumeration<String> sts = request.getHeaders("User-Agent");
		while (sts.hasMoreElements()) {
			sb.append(sts.nextElement());
		}
		return sb.toString();
	}

	/**
	 * 获取请求头语言信息
	 * 
	 * @param request
	 * @return
	 */
	static public String getAcceptLanguage(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		Enumeration<String> sts = request.getHeaders("Accept-Language");
		while (sts.hasMoreElements()) {
			sb.append(sts.nextElement());
		}
		return sb.toString();
	}

	/**
	 * 
	 * @param request
	 * @return
	 */
	static public String getCookie(HttpServletRequest request) {
		StringBuilder sb = new StringBuilder();
		Enumeration<String> sts = request.getHeaders("Cookie");
		while (sts.hasMoreElements()) {
			sb.append(sts.nextElement());
		}
		return sb.toString();
	}

	static public HashMap<String, Object> doPostParams(
			HttpServletRequest request) throws ServletException, IOException {

		HashMap<String, Object> result = new HashMap<String, Object>();
		// 取出客户提交的参数集
		Enumeration<String> paramNames = request.getParameterNames();
		// 遍历参数集取出每个参数的名称及值
		while (paramNames.hasMoreElements()) {
			String name = paramNames.nextElement(); // 取出参数名称
			String values[] = request.getParameterValues(name); // 根据参数名称取出其值
			// 如果参数值集不为空
			if (values != null) {
				// 如果参数值集中只有一个值
				if (values.length == 1) {
					try {
						// 调用 toUTF(values[0]) 函数 ,(values[0] 即第一个参数值 )
						// 方法转换参数值的字元编码
						String vlustr = toUTF(values[0]);
						// 并将该值以属性的形式藏在 request
						request.setAttribute(name, vlustr);
						result.put(name, vlustr);
					} catch (UnsupportedEncodingException e) {
						e.printStackTrace();
					}
				}

				// 如果参数值集中有多个值
				else {
					// 遍历参数值集
					for (int i = 0; i < values.length; i++) {
						try {
							// 回圈依次将每个值调用 toUTF(values[i]) 方法转换参数值的字元编码
							String vlustr = toUTF(values[i]);
							values[i] = vlustr;
						} catch (UnsupportedEncodingException e) {
							e.printStackTrace();
						}
					}
					// 将该值以属性的形式藏在 request
					request.setAttribute(name, values);
					result.put(name, values);
				}
			}
		}
		return result;
	}

	/**
	 * 将 inStr 转为 UTF - 8 的编码形式
	 * 
	 * @param inStr
	 *            输入字符串
	 * @return UTF - 8 的编码形式的字符串
	 * @throws UnsupportedEncodingException
	 */
	static public String toUTF(String inStr)
			throws UnsupportedEncodingException {
		String outStr = "";
		if (inStr != null) {
			// outStr=java.net.URLDecoder.decode(inStr);// 不用 decode 了 ,
			// 到这的时候就已经自动 decode 过了
			// 将字符串转为 UTF-8 编码形式
			outStr = new String(inStr.getBytes("iso-8859-1"), "UTF-8");
		}
		return outStr;
	}
	
}
