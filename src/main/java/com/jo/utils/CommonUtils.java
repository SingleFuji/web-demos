package com.jo.utils;

public class CommonUtils {

	public static String getClassPath(){
		String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath().toString();
		return classpath;
	}
}
