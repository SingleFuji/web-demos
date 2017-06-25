package com.jo.dao;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jo.po.JoUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext-myBatis.xml")
public class JoUserDaoTest extends AbstractJUnit4SpringContextTests{

	@Resource
	private JoUserDao joUserDao;
	
	JoUser user = new JoUser();
	
	@Before
	public void setUp() throws Exception {
		user.setId("1");
		user.setUsername("jo");
		user.setPassword("123");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testInsertUser() {
		joUserDao.insertUser(user);
	}
	
	@Test
	public void testSelectByID() {
		JoUser user = joUserDao.selectByID("1");
		System.out.println(user.toString());
	}

}
