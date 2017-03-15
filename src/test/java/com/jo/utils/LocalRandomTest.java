package com.jo.utils;

import org.junit.Test;
/**
 * 并发随机数测试   需jdk1.7以上
 * 
 * @author mango_jo
 *
 */
public class LocalRandomTest {

	@Test
	public void test() {
		Thread [] threads = new Thread [30];
        for(int  i =0;i< threads.length;i++){
            TaskLocalRandom  random = new TaskLocalRandom();
            threads[i] = new Thread(random);
            threads[i].start();
        }
	}

}
