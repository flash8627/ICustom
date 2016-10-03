package com.gwtjs.common.intercepts;

public class Test {
	
	public Test() {
		// TODO Auto-generated constructor stub
	}
	
	public static void main(String[] args) {
		String id = "com.gwtjs.security.dao.IUserDAO.findUserPage";
		String sqlId = ".*ByPage$";
		boolean flag = id.matches(sqlId);
		System.out.println(flag);
	}
}
