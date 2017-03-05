package com.gwtjs.security.dao;

import java.util.List;

import javax.inject.Inject;

import org.junit.Ignore;
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
	
	@Test @Ignore
	public void findUserListTest(){
		SysUsersVO user = new SysUsersVO();
		PagerVO page=new PagerVO();
		page.setCurPage(1);
		page.setPageSize(20);
		List<SysUsersVO> list = userDAO.selectList(user, page);
		
		assertTrue(list.size()>0);
	}
	
	/**测试基础分页*/
	@Test 
	public void findFindUserPageTest(){
		SysUsersVO user = new SysUsersVO();
		PagerVO page=new PagerVO();
		page.setCurPage(1);
		page.setPageSize(20);
		PagedResult<SysUsersVO> result = userDAO.findUserByPage(user, page);
		System.out.println(result);
	}
	
	/**测试增加用户过滤条件分页-有数据正常返回*/
	@Test 
	public void findFindUserPageTest2(){
		SysUsersVO user = new SysUsersVO();
		user.setUsername("a");
		user.setUserDesc("用户");
		PagerVO page=new PagerVO();
		page.setCurPage(1);
		page.setPageSize(20);
		PagedResult<SysUsersVO> result = userDAO.findUserByPage(user, page);
		System.out.println(result);
		assertTrue(result.getResult().size()>0);
		assertNotNull(result.getResult());
	}
	
	/**测试增加用户过滤条件分页-无数据正常返回*/
	@Test 
	public void findFindUserPageTest3(){
		SysUsersVO user = new SysUsersVO();
		user.setUsername("b");//无此用户名称
		user.setUserDesc("doge");//无此用户说明
		PagerVO page=new PagerVO();
		page.setCurPage(1);
		page.setPageSize(20);
		PagedResult<SysUsersVO> result = userDAO.findUserByPage(user, page);
		System.out.println(result);
		assertTrue(result.getResult().size()==0);
	}
	
	
	
}
