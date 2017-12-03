package com.jo;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jo.dao.JoUserDao;
import com.jo.po.JoUser;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:applicationContext-aop.xml","classpath:applicationContext-myBatis.xml"})
public class AopTest extends AbstractJUnit4SpringContextTests {

	@Resource
	private JoUserDao joUserDao;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSelectByID() {
		JoUser user = joUserDao.selectByID("1");
		System.out.println(user.toString());
	}

}
