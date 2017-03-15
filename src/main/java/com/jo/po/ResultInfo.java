package com.jo.po;

import java.io.Serializable;

public class ResultInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1870322997948015798L;

	private String code;
	
	private String msg;
	
	private Object data;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}
