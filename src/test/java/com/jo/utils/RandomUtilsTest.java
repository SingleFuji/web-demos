package com.jo.utils;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class RandomUtilsTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testRandomInt() {

		for(int i=0;i<30;i++){
			System.out.println(RandomUtils.randomInt(30));
//			System.out.println(new Random().nextInt(30));
		}
	}
	
	@Test
	public void testRandomIntWithBound() {

		for(int i=0;i<30;i++){
			System.out.println(RandomUtils.randomIntWithBound(30));
//			System.out.println(new Random().nextInt(30));
		}
	}
	
	@Test
	public void testRandomDouble() {

		for(int i=0;i<30;i++){
			System.out.println(RandomUtils.randomDouble(1));
		}
	}
	
	@Test
	public void testDemo(){
		String classPath = Thread.currentThread().getContextClassLoader().getResource("").toString();
		System.out.println(classPath);
	}

}
