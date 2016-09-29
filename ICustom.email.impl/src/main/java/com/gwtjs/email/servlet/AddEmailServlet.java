package com.gwtjs.email.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwtjs.email.dao.IEmailDao;

public class AddEmailServlet extends HttpServlet {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7987390731571529941L;
	private IEmailDao emailDao = new IEmailDao();

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String hostName = request.getParameter("hostName");
		String sender = request.getParameter("sender");
		String password = request.getParameter("password");
		String receiver = request.getParameter("receiver");
		String toName = request.getParameter("toName");
		String fromName = request.getParameter("fromName");
		String sendDate = request.getParameter("sendDate");
		
		boolean flag = emailDao.addEmail(hostName, sender, password, receiver, toName, fromName, sendDate);
		if(flag){
			System.out.println("添加Email成功");
			response.sendRedirect("./jsp/addEmailSuccess.jsp");
		}
	}
}
