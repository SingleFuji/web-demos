package com.jo.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jo.common.CacheKey;

public class RedisZSetServiceTest {

	private ApplicationContext context = null;
	private RedisZSetService redisZSetService = null;
	
	@Before
	public void setUp() throws Exception {
		context = new ClassPathXmlApplicationContext("classpath:redisContext.xml");
		redisZSetService = (RedisZSetService) context.getBean("redisZSetService");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testZAdd() {
		redisZSetService.zAdd(CacheKey.APP_SCORE_SORT_KEY, "wechat", 14);
		redisZSetService.zAdd(CacheKey.APP_SCORE_SORT_KEY, "alipay", 16);
		redisZSetService.zAdd(CacheKey.APP_SCORE_SORT_KEY, "chillout", 18);
		redisZSetService.zAdd(CacheKey.APP_SCORE_SORT_KEY, "trance", 13);
	}
	
	@Test
	public void testZIncrBy() {
		redisZSetService.zIncrBy(CacheKey.APP_SCORE_SORT_KEY, "wechat", 8);
	}
	
	@Test
	public void testZCard() {
		long count = redisZSetService.zCard(CacheKey.APP_SCORE_SORT_KEY);
		System.out.println(count);
	}

	@Test
	public void testZRangeWithScore(){
		redisZSetService.zRange(CacheKey.APP_SCORE_SORT_KEY, 0, -1);
	}
	
	@Test
	public void testZRangeWithoutScore(){
		redisZSetService.zRange(CacheKey.APP_SCORE_SORT_KEY, 0, -1);
	}
	
}
