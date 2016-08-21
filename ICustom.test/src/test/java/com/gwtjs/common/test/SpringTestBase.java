/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gwtjs.common.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试基类 
 * @author ZhengGuang Dong
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring.xml","classpath:spring-*.xml","classpath:config/*-spring-cxf-service.xml"})
@Transactional
@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = false)
public class SpringTestBase extends AbstractJUnit4SpringContextTests {
	
	@Test
	public void testBaseConfig() {
	}
	
}
