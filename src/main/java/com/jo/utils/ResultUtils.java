package com.jo.utils;

import com.jo.po.ResultInfo;

public class ResultUtils {

	public static ResultInfo success(Object data){
		ResultInfo result = new ResultInfo();
		result.setCode("00");
		result.setMsg("成功");
		result.setData(data);
		return result;
	}
}
