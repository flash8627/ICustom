package timerEmail;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.MultiPartEmail;
import org.apache.commons.mail.EmailAttachment;
import org.apache.commons.mail.SimpleEmail;
import org.apache.commons.net.MalformedServerReplyException;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.*;

public class SendEmail {

	private static EmailDao emailDao = new EmailDao();
	private static List<Email> emails = new ArrayList<Email>();

	// 简单邮件发送
	private static boolean send(String hostName, String sender,
			String password, String receiver, String toName, String fromName) {
		boolean flag = false;
		SimpleEmail email = new SimpleEmail();
		email.setHostName(hostName);
		email.setAuthentication(sender, password);

		try {
			email.addTo(receiver, toName);// 报错
			email.setFrom(sender, fromName);

			email.setSubject("title");
			email.setMsg("ccccccccccccc");
			email.send();
			flag = true;
		} catch (EmailException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return flag;
	}

	public static void send() {
		
		System.out.println("--监测程序正在运行--");
		init();
		
		if (emails == null || (emails.size() == 0)) {
			System.out.println("今天没有要发送的邮件");
			return;
		}
		
		Date now = new Date();
		DateFormat d1 = DateFormat.getDateInstance();
		String str1 = d1.format(now);// 输出：str1 = 2011-6-16
		// System.out.println("当前时间是：" + str1);

		for (Email e : emails) {
			// System.out.println("任务的时间是：" + d1.format(e.getSendDate()));
			if (d1.format(e.getSendDate()).equals(str1) && (e.getIsSend() == 0)) {// 如果待发送时间是今天，则发送
				if (send(e.getHostName(), e.getSender(), e.getPassword(), e
						.getReceiver(), e.getToName(), e.getFromName())) {
					System.out.println("send email ...");
					emailDao.update(e.getId(), 1);// 改成已发送
				}
			}
		}
	}

	private static void init() {
		emails = emailDao.getTodayTaskEmail();
	}

	public static void main(String[] args) {

		// send();
	}

}
