package com.gwtjs.lookup.dao;

import javax.inject.Inject;

import org.junit.Test;

import com.gwtjs.core.test.SpringTestBase;

//@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring*.xml","classpath:config/*-spring-cxf-service.xml"})
public class ILookupDAOTest extends SpringTestBase {
	
	@Inject
	private ILookupDAO lookupDAO;
	
	@Test
	public void findListTest(){
		System.out.println(lookupDAO);//registerDAO.selectList(record, page);
	}
	
}
