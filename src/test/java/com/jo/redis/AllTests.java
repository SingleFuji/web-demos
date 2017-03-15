package com.jo.redis;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RedisCommonTest.class, RedisStringTest.class })
public class AllTests {

	
}
