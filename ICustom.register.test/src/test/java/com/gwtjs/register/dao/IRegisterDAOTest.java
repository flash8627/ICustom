package com.gwtjs.register.dao;

import javax.inject.Inject;

import org.junit.Test;

import com.gwtjs.core.test.SpringTestBase;

public class IRegisterDAOTest extends SpringTestBase {
	
	@Inject
	private IRegisterDAO registerDAO;
	
	@Test
	public void findListTest(){
		System.out.println(registerDAO);//registerDAO.selectList(record, page);
	}
	
}
