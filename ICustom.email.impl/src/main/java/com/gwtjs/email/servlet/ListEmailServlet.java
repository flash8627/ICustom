package timerEmail;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ListEmailServlet extends HttpServlet {

	private EmailDao emailDao = new EmailDao();

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
