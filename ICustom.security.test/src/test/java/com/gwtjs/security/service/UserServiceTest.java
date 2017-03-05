package com.gwtjs.security.service;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import javax.inject.Inject;

import org.junit.Test;

import com.gwtjs.common.entity.PagedResult;
import com.gwtjs.common.entity.PagerVO;
import com.gwtjs.common.entity.ResultWrapper;
import com.gwtjs.core.test.SpringTestBase;
import com.gwtjs.security.entity.SysUsersVO;
import com.gwtjs.security.services.IUserServices;

/**
 * 用户服务测试
 * @author aGuang
 *
 */
public class UserServiceTest extends SpringTestBase {
	
	@Inject
	private IUserServices userServices;
	
	@Test
	public void testBatchInsert(){
		
	}
	
	/**
	 * 基本分页测试,只有分页参数
	 */
	@Test
	public void testFindUserList1(){
		SysUsersVO user = new SysUsersVO();
		PagerVO page=new PagerVO();
		page.setCurPage(1);
		page.setPageSize(20);
		PagedResult<SysUsersVO> result = userServices.findUserList(user, page);
		System.out.println(result);
		assertTrue(result.getResult().size()>0);
		assertNotNull(result.getResult());
	}
	
	/**
	 * 基本分页测试,含 分页参数和用户参考过滤
	 */
	@Test
	public void testFindUserList2(){
		SysUsersVO user = new SysUsersVO();
		user.setUsername("a");
		user.setUserDesc("用户");
		PagerVO page=new PagerVO();
		page.setCurPage(1);
		page.setPageSize(20);
		PagedResult<SysUsersVO> result = userServices.findUserList(user, page);
		System.out.println(result);
		assertTrue(result.getResult().size()>0);
		assertNotNull(result.getResult());
	}
	
	/**
	 * 基本分页测试,含 分页参数和用户参考过滤
	 */
	@Test
	public void testFindUserList3(){
		SysUsersVO user = new SysUsersVO();
		user.setUsername("b");//无此用户名称
		user.setUserDesc("doge");//无此用户说明
		PagerVO page=new PagerVO();
		page.setCurPage(1);
		page.setPageSize(20);
		PagedResult<SysUsersVO> result = userServices.findUserList(user, page);
		System.out.println(result);
		assertTrue(result.getResult().size()==0);
	}
	
	/**空的用户ID,返回空*/
	@Test
	public void testFindItem1(){
		Long userId = new Long("0");
		ResultWrapper result = userServices.findItem(userId);
		assertNull(result.getObj());
	}
	
	/**空的用户ID,返回空*/
	@Test
	public void testFindItem2(){
		Long userId = new Long("42");
		ResultWrapper result = userServices.findItem(userId);
		assertNotNull(result.getObj());
	}
	
	
	@Test
	public void test()
	{
		assertNotNull(userServices);
	}
	
}
