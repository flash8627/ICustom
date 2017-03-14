package com.gwtjs.core.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.gwtjs.core.util.InputStreamUtils;


/**
 * Servlet implementation class PkgHtmlServlet
 */
//@WebServlet("*.html")
public class PkgHtmlServlet extends HttpServlet {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass().getName());
	
	private static final long serialVersionUID = 1L;

	/**
	 * 获取输入流，读出来。 然后,写一个servlet，重载service方法
	 */
	@Override
	public void service(ServletRequest arg0, ServletResponse arg1)
			throws ServletException, IOException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		String servletPath = request.getServletPath();//- /a.jsp 
		String contextPath = request.getContextPath();// /工程名 
		String reqUri = request.getRequestURI();// /工程名/a.jsp 
		String reqUrl = request.getRequestURL().toString();// http://127.0.0.1:8080/工程名/a.jsp 
		
		int staNum = reqUri.lastIndexOf("/web/JarPageTest.html");
		
		if(staNum>-1){
			
			logger.info("servletPath", servletPath);
			logger.info("contextPath", contextPath);
			logger.info("reqUri", reqUri);
			logger.info("reqUrl", reqUrl);
			
			InputStream inputStream = InputStreamUtils.getInputStream(getClass(), reqUri);

			StringBuilder result = new StringBuilder();
			/*while (count > 0) {
				String string = new String(buff, 0, count);
				result.append(string);
			}*/
			BufferedReader in=new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
			String s="";    
	        while((s=in.readLine())!=null){
	        	//String string = new String(s, 0, count);
				result.append(s);
	        }
			//写资源文件
			/*OutputStream outputStream=urlConnection.getOutputStream();
			PrintStream printStream=new PrintStream(outputStream);*/
			

			logger.info("reqUrl", result);
			arg1.getWriter().write(result.toString());
		}
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.service(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.service(req, resp);
	}
	
	

}
