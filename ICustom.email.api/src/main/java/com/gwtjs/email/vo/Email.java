package timerEmail;

import java.util.Date;

public class Email {
	int id;
	private String hostName;
	private String sender;
	private String password;
	private String receiver;
	private String toName;
	private String fromName;
	private Date sendDate;// 类型是用String还是Date？
	private int isSend;// 状态，false表示还没发送

	public Email(int id ,String hostName, String sender, String password,
			String receiver, String toName, String fromName, Date sendDate,
			int isSend) {
		this.id = id ;
		this.hostName = hostName;
		this.sender = sender;
		this.password = password;
		this.receiver = receiver;
		this.toName = toName;
		this.fromName = fromName;
		this.sendDate = sendDate;
		this.isSend = isSend;
	}

	public Email(Date sendDate, int isSend) {
		this.hostName = "smtpcom.263xmail.com";
		this.sender = "test@gacinfo.com.cn";
		this.password = "gacinfo.com";
		this.receiver = "liangtu33@163.com";
		this.toName = "to_liangtu33";
		this.fromName = "from_liangtu33";
		this.sendDate = sendDate;
		this.isSend = isSend;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getSender() {
		return sender;
	}

	public void setSender(String sender) {
		this.sender = sender;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getReceiver() {
		return receiver;
	}

	public void setReceiver(String receiver) {
		this.receiver = receiver;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public int getIsSend() {
		return isSend;
	}

	public void setIsSend(int isSend) {
		this.isSend = isSend;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
}
