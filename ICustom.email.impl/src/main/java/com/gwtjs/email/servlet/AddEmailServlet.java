package timerEmail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddEmailServlet extends HttpServlet {
	
	private EmailDao emailDao = new EmailDao();

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
