package com.jo.redis;

public interface RedisStringService {

	/**
	 * 获取字符串值
	 * 
	 * @param key
	 * @return
	 */
	public String getString(final String key);
	
	/**
	 * 为键设值
	 * 
	 * @param key
	 * @param val
	 */
	public void putString(String key, String val);
	
	/**
	 * 为键设值 带超时时间的
	 * 
	 * @param key
	 * @param val
	 * @param timeout
	 */
	public void putString(String key, String val, long timeout);
}
