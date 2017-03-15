package com.jo.redis;
/**
 * 处理通用类型命令
 * 
 * @author mango_jo
 *
 */
public interface RedisCommonService {

	/**
	 * 删除键
	 * 
	 * @param key
	 */
	public void delKey(String key);
}
