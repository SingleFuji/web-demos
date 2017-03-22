package com.jo.utils;

import com.alibaba.fastjson.JSON;

public class FastjsonUtils {

	public static String toJson(Object obj){
		return JSON.toJSONString(obj);
	}
}
