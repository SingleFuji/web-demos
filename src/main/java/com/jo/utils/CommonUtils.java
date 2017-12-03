package com.jo.utils;

import java.io.File;

public class CommonUtils {

	String avtarPath = "static"+ File.separator+"img";
	
	public static String getClassPath(){
		String classpath = Thread.currentThread().getContextClassLoader().getResource("").getPath().toString();
		return classpath;
	}
}
