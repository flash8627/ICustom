package timerEmail;

import java.text.DateFormat;
import java.util.Date;
import java.util.Timer;

public class Test {

	// 这是一个重复执行的方法，间隔可以设定
	public void execute() {
		Timer timer = new Timer();
		CircleDo myTimeTask = new CircleDo();// 这个是循环执行的任务
		Date date = new Date();
		long timestamp = 10000;// 时间间隔是10秒

		timer.schedule(myTimeTask, date, timestamp);// 每个10秒执行该任务
	}

//	public static void main(String[] args) {
//		Test t = new Test();
//		t.execute();
//	}
}
