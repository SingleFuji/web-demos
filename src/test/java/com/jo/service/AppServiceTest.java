package com.jo.service;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jo.exception.JoException;
import com.jo.utils.CommonUtils;

public class AppServiceTest {

	private ApplicationContext context = null;
	private AppService appService = null;
	
	@Before
	public void setUp() throws Exception {
		
		System.out.println(CommonUtils.getClassPath());
		context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
		appService = (AppService) context.getBean("appService");
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInitRankList() {
		try {
			appService.initRankList();
		} catch (JoException e) {
			e.printStackTrace();
		}
	}

}
