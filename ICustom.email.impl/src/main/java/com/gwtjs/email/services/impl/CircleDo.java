package timerEmail;

import java.util.TimerTask;

//循环执行
public class CircleDo extends TimerTask{
	
	@Override
	public void run() {
		
		SendEmail.send();
	}

}
