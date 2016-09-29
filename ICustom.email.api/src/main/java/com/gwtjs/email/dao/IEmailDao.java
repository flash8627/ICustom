package com.gwtjs.email.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.gwtjs.email.vo.Email;

public class IEmailDao {
	static {
		String driverName = "com.mysql.jdbc.Driver";

		try {
			Class.forName(driverName);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean addEmail(String hostName, String sender, String password,
			String receiver, String toName, String fromName, String sendDate) {
		boolean flag = false;
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "gac1234");
			PreparedStatement ps = con
					.prepareStatement("insert into  email (hostName,sender,password,receiver,toName,fromName,sendDate,isSend) values (?,?,?,?,?,?,?,?)");
			ps.setString(1, hostName);
			ps.setString(2, sender);
			ps.setString(3, password);
			ps.setString(4, receiver);
			ps.setString(5, toName);
			ps.setString(6, fromName);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date date1 = new Date();
			date1 = sdf.parse(sendDate);
			ps.setDate(7, new java.sql.Date(date1.getTime()));

			ps.setInt(8, 0);// 0表示未发，1表示已发

			int count = ps.executeUpdate();
			// System.out.println("count = "+count);
			if (count > 0) {
				flag = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public List<Email> getAllEmail() {
		List<Email> emails = new ArrayList<Email>();
		Email email;
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "gac1234");
			PreparedStatement ps = con.prepareStatement("select * from email");
			ResultSet rs;

			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String hostName = rs.getString("hostName");
				String sender = rs.getString("sender");
				String password = rs.getString("password");
				String receiver = rs.getString("receiver");
				String toName = rs.getString("toName");
				String fromName = rs.getString("fromName");
				Date sendDate = rs.getDate("sendDate");
				int isSend = rs.getInt("isSend");
				// System.out.println("isSend = "+isSend);

				email = new Email(id,hostName, sender, password, receiver, toName,
						fromName, sendDate, isSend);
				emails.add(email);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return emails;
	}
	
	public List<Email> getTodayTaskEmail() {
		List<Email> emails = new ArrayList<Email>();
		Email email;
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "gac1234");
			PreparedStatement ps = con.prepareStatement("select * from email where sendDate = ? and isSend = ?");
			
			Date now = new Date();
			DateFormat d1 = DateFormat.getDateInstance(); 
			String str1 = d1.format(now);//输出2011-6-16
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			now = sdf.parse(str1);
			ps.setDate(1, new java.sql.Date(now.getTime()));
//			System.out.println("now.getTime = "+new java.sql.Date(now.getTime()));
			ps.setInt(2, 0);
			
			ResultSet rs;

			rs = ps.executeQuery();
			while (rs.next()) {
				int id = rs.getInt("id");
				String hostName = rs.getString("hostName");
				String sender = rs.getString("sender");
				String password = rs.getString("password");
				String receiver = rs.getString("receiver");
				String toName = rs.getString("toName");
				String fromName = rs.getString("fromName");
				Date sendDate = rs.getDate("sendDate");
				int isSend = rs.getInt("isSend");

				email = new Email(id,hostName, sender, password, receiver, toName,
						fromName, sendDate, isSend);
				emails.add(email);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return emails;
	}

	public boolean update(int id, int isSend) {
		
		System.out.println("id = "+id+",isSend = "+isSend);
		boolean flag = false;
		try {
			Connection con = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/test", "root", "gac1234");
			PreparedStatement ps = con
					.prepareStatement("update email set isSend = ? where id = ?");
			ps.setInt(1, isSend);
			ps.setInt(2, id);

			int count = ps.executeUpdate();
			
			if (count > 0) {
				flag = true;
				System.out.println("update success");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}

	public static void main(String[] args) {
	}
}
