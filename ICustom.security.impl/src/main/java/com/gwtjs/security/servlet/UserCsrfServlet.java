package com.gwtjs.security.servlet;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.web.csrf.DefaultCsrfToken;

/**
 * 获取spring security csrf的工具类
 * @author aGuang
 *
 */@WebServlet("/userCsrfServlet")
public class UserCsrfServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 923698660658704860L;

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
	
	//org.springframework.security.web.csrf.DefaultCsrfToken
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		Map<String,String> result = new HashMap<String,String>();
		DefaultCsrfToken csrf = null;
		Object parameter = req.getAttribute("_csrf");
		String parameterName = "";
		String token = "";
		System.out.println(parameter);
		if(parameter!=null){
			csrf = getTokenVO(parameter);
			parameterName = csrf.getParameterName();
			token = csrf.getToken();
			System.out.println(csrf);
		}
		
		result.put("parameterName", parameterName);
		result.put("token", token);
		
		System.out.println(result);
		//super.service(req, resp);
	}
	
	/**
	 * 检查是否有page参数，并返回对象
	 * 
	 * @param parameter
	 * @return
	 */
	private DefaultCsrfToken getTokenVO(Object parameter) {
		
		if (parameter instanceof Map) {
			Map<Object, Object> parameterMap = (Map) parameter;
			for (Map.Entry<Object, Object> entry : parameterMap.entrySet()) {
				if (entry.getValue() instanceof DefaultCsrfToken) {
					return (DefaultCsrfToken) entry.getValue();
				}
			}
		}
		if (parameter instanceof DefaultCsrfToken) {
			return (DefaultCsrfToken) parameter;
		}
		return null;
	}
	
}
