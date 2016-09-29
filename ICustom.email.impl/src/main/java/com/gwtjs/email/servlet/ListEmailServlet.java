package com.gwtjs.email.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gwtjs.email.dao.IEmailDao;
import com.gwtjs.email.vo.Email;

public class ListEmailServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4533764256089003693L;
	private IEmailDao emailDao = new IEmailDao();

	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Email> emails = emailDao.getAllEmail();

		// 存储到request中
		request.setAttribute("emails", emails);

		// 转发到jsp
		request.getRequestDispatcher("./jsp/listEmailTask.jsp").forward(request,
				response);
	}
}
