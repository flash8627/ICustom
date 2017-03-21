package com.gwtjs.core.filter;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwtjs.core.intercepts.PageInterceptor;
import com.gwtjs.core.util.spring.StringUtils;

/**
 * js和css增加时间戳
 * @author aGuang
 *
 */
@WebFilter(urlPatterns = "*")
public class StampParameterDateFilter implements Filter {
	
	private String stampStatus = "1";
	
	private static final com.gwtjs.core.log.ILogger log = com.gwtjs.core.log.LoggerFactory
			.getLogger(PageInterceptor.class);
	
	private static final Logger logger = LoggerFactory
			.getLogger(StampParameterDateFilter.class);

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		log.info("stamp Status",stampStatus);
		logger.error(stampStatus);
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse resp = (HttpServletResponse) response;
		
		String uri = req.getRequestURI();
		
		String requestURL = req.getRequestURL().toString();
		String queryStr = req.getQueryString();
		System.out.println("----------- queryStr --"+queryStr);
		System.out.println("----------requestURL --"+requestURL);
		System.out.println("----------requestURI --"+uri);
		
		System.out.println("-----------     URI:"+getRequestTime(uri));
		
		// add timestamp to static resource, to avoid cache
		if (requestURL != null
				&& (requestURL.endsWith(".js") || requestURL.endsWith(".css"))) { // static resource
			String newURL = null;
			if (StringUtils.isNotBlank(queryStr)
					&& queryStr.trim().indexOf(ParameterConfig.STATIC_TAIL) == -1) {
				newURL = requestURL + "?" + queryStr + "&"
						+ ParameterConfig.STATIC_TAIL + new Date().getTime();
				System.out.println("----------------------"+newURL);
				logger.error(newURL.toString());
				resp.sendRedirect(newURL);
				//chain.doFilter(request, response);
			}
			if (StringUtils.isBlank(queryStr)) {
				newURL = requestURL + "?" + ParameterConfig.STATIC_TAIL
						+ new Date().getTime();
				System.out.println("----------------------"+newURL);
				resp.sendRedirect(newURL);
				//chain.doFilter(request, response);
			}
			chain.doFilter(request, response);
		}
		chain.doFilter(request, response);
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}
	
	/**
	 * 以文件最后修改时间为时间戳
	 * @param file
	 * @return
	 */
	private String getRequestTime(String url)
	{
		String sample = "?";
		int len = url.indexOf("?");
		if(len>-1){
			sample = "&";
		}
		
		return url + sample + ParameterConfig.STATIC_TAIL
				+ new Date().getTime();
	}
	
	/**
	 * 以文件最后修改时间为时间戳
	 * @param file
	 * @return
	 */
	private String getLastFileUpdateTime(String file)
	{
		File f=new File(file);
		long timestamp=f.lastModified();
		Date when=new Date(timestamp);
		SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMddhhmmssS");
		return sdf.format(when);
	}

}
