package timerEmail;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

public class TimerListener extends HttpServlet implements ServletContextListener {
	
	private Test t = new Test();
	
	//web容器启动时，会调用该方法
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("web is running ");
		t.execute();
	}

	// web容器关闭时调用
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("web is closing ");
	}
}