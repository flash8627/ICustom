package com.gwtjs.security.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import static org.junit.Assert.*;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.core.test.SpringTestBase;
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
		List<SysUsersVO> list = userDAO.selectList(user, page);
		
		assertTrue(list.size()>0);
	}
	
	@Test
	public void findFindUserPageTest(){
		SysUsersVO user = new SysUsersVO();
		PagerVO page=new PagerVO();
		page.setCurPage(1);
		page.setPageSize(20);
		PagedResult<SysUsersVO> result = userDAO.findUserPage(user, page);
		System.out.println(result);
	}
	
}
