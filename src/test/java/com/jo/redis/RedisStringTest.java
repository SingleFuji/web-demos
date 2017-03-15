package com.jo.redis;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class RedisStringTest {
	
	private ApplicationContext context = null;
	private RedisStringService redisHashMapStringService = null;
	private RedisStringService redisOpsValStringService = null;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:redisContext.xml");
		redisHashMapStringService = (RedisStringService) context.getBean("redisHashMapStringService");
		redisOpsValStringService = (RedisStringService) context.getBean("redisStringOpsValService");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("finish");
	}

	@Test
	public void testHashMapSet() {
		String key = "kimimaro";
		String val = "40";
		redisHashMapStringService.putString(key, val);
		String result = redisHashMapStringService.getString(key);
		System.out.println(result);
		Assert.assertNotNull(result);
		
		System.out.println("===========");
	}

	@Test
	public void testOpsForValSet() {
		String key = "a";
		String val = "43";
		redisOpsValStringService.putString(key, val);
		String result = redisOpsValStringService.getString(key);
		System.out.println(result);
		Assert.assertNotNull(result);
		System.out.println("+++++++++");
	}
	
}
