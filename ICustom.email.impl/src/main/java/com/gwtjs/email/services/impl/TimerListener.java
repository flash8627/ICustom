package com.gwtjs.email.services.impl;

import java.util.Date;
import java.util.Timer;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;

public class TimerListener extends HttpServlet implements
		ServletContextListener {

	// 这是一个重复执行的方法，间隔可以设定
	public void execute() {
		Timer timer = new Timer();
		CircleDo myTimeTask = new CircleDo();// 这个是循环执行的任务
		Date date = new Date();
		long timestamp = 10000;// 时间间隔是10秒

		timer.schedule(myTimeTask, date, timestamp);// 每个10秒执行该任务
	}

	// private Test t = new Test();

	// web容器启动时，会调用该方法
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("web is running ");
		execute();
	}

	// web容器关闭时调用
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("web is closing ");
	}
}