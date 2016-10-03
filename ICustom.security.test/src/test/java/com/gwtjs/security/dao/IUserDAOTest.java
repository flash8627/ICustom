package com.gwtjs.security.dao;

import javax.inject.Inject;

import org.junit.Test;

import com.gwtjs.SpringTestBase;
import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.security.entity.SysUsersVO;

public class IUserDAOTest extends SpringTestBase {
	
	@Inject
	private IUserDAO userDAO;
	
	@Test
	public void findListTest(){
		System.out.println(userDAO);//registerDAO.selectList(record, page);
	}
	
	@Test
	public void findUserListTest(){
		SysUsersVO user = new SysUsersVO();
		PagerVO page=new PagerVO();
		page.setCurPage(1);
		page.setPageSize(20);
		userDAO.selectList(user, page);
		
	}
	
}
