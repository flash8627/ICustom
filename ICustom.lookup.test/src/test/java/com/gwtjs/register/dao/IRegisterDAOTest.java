package com.gwtjs.register.dao;

import javax.inject.Inject;

import org.junit.Test;

import com.gwtjs.common.test.SpringTestBase;

//@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring*.xml","classpath:config/*-spring-cxf-service.xml"})
public class IRegisterDAOTest extends SpringTestBase {
	
	@Inject
	private IRegisterDAO registerDAO;
	
	@Test
	public void findListTest(){
		System.out.println(registerDAO);//registerDAO.selectList(record, page);
	}
	
}
