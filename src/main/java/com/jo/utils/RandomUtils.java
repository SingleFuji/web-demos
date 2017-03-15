package com.jo.utils;

import java.util.Random;
/**
 * 随机数工具类
 * 
 * @author mango_jo
 *
 */
public class RandomUtils {

	/**
	 * 获取随机整数
	 * 
	 * @param max
	 * @return
	 */
	public static int randomInt(int max){
		Random random = new Random();
		int ranNum = random.nextInt();
		if(max > 0){
			return ranNum % max;
		}
		return ranNum;
	}
	
	/**
	 * 获取随机浮点数
	 * 
	 * @return
	 */
	public static double randomDouble(int times){
		Random random = new Random();
		double ranNum = random.nextDouble();
		if(times > 0){
			return DoubleUtils.multi(ranNum, times);
		}
		return ranNum;
	}
	
	/**
	 * 获取固定随机整数
	 * 
	 * @return
	 */
	public static int randomIntWithBound(int bound){
		Random random = new Random();
		int ranNum = random.nextInt(bound);
		return ranNum;
	}
}
