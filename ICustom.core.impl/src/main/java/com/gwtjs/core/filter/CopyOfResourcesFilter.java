package com.gwtjs.core.filter;

import java.io.IOException;
import java.io.InputStream;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.IOUtils;


/**
 * Servlet Filter implementation class ResourceFilter
 */
//@WebFilter(urlPatterns = "*")
public class CopyOfResourcesFilter implements Filter {

	/**
	 * 获取url地址，将*转化成web/*,并处理图片路径\空串等逻辑 如果web目录没有直接取，直接到不到就返回404;
	 * 
	 * @param url
	 */
	/**
	 * 请求以/开头的都以/web/返回
	 */
	private static final String FILTER_PATH = "/web/";

	@Override
	public void destroy() {
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1,
			FilterChain arg2) throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) arg0;
		String url = request.getRequestURI();
		System.out.println("request url:" + url);

		// 1.使用正则表达式方法
		Pattern p = Pattern.compile(FILTER_PATH);
		String s1 = url;
		Matcher m = p.matcher(s1);
		// 将所有匹配的","的位置都打印出来，并统计次数
		int cnt1 = 0;
		while (m.find()) {
			cnt1++;
			System.out.println(m.start());
		}
		System.out.println("使用第1次方法检测出的,出现次数： " + cnt1);

		// 2.使用String自带的indexOf方法
		String s2 = s1;
		int pos = 0;
		int cnt2 = 0;
		while (pos < s2.length()) {
			pos = s2.indexOf(',', pos);
			if (pos == -1) {
				break;
			} else {
				cnt2++;
				System.out.println(pos);
				pos++;
			}
		}
		System.out.println("使用第2次方法检测出的,出现次数： " + cnt2);

		// 3.取出字符串String的每个字符逐一比较
		String s3 = s1;
		int cnt3 = 0;
		for (int i = 0; i < s3.length(); i++) {
			if (s3.charAt(i) == ',') {
				cnt3++;
				System.out.println(i);
			}
		}
		System.out.println("使用第3次方法检测出的,出现次数： " + cnt3);

		// url = getResourcePath(url);
		int pathLength = url.indexOf("/web/");
		System.out.println("path length , " + pathLength);
		int leng = 0;
		if ("/web/".length() > 6) {
			leng = "/web/".length();
		}
		if (url.startsWith(FILTER_PATH)) {
			String name = "/web/";
			if (leng > 0) {
				name = url.substring("/web/".length());
			}
			System.out.println("资源路径：" + name);
			InputStream in = this.getClass().getClassLoader()
					.getResourceAsStream(name);
			try {
				IOUtils.copy(in, arg1.getOutputStream());
			} finally {
				IOUtils.closeQuietly(in);
			}
		} else {
			arg2.doFilter(arg0, arg1);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
	}

}
