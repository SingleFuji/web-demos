package com.jo.dao;

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
public class JoUserServiceTest extends AbstractJUnit4SpringContextTests{

	JoUser user = new JoUser();
	
	
//	@Resource
//	private JoUserService joUserService;
	
	
	@Before
	public void setUp() throws Exception {
		user.setId("2");
		user.setUsername("test");
		user.setPassword("888");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		System.out.println("0000");
//		joUserService.setUser(user);
//		JoUser u = joUserService.getUserByUsername(user.getUsername());
//		System.out.println(u.toString());
	}

}
