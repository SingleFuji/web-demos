package com.jo.redis;

import java.io.Serializable;
import java.util.Set;

import org.springframework.data.redis.core.ZSetOperations.TypedTuple;

/**
 * 有序集合 接口
 * 
 * @author mango_jo
 *
 */
public interface RedisZSetService {

	public void zAdd(String key, String val, double score);
	
	public void zIncrBy(String key, String val, double score);
	
	public long zCard(String key);
	
	/**
	 * 按分数从小到大
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public Set<Serializable> zRange(String key, int start, int end);
	
	public Set<TypedTuple<Serializable>> zRangeWithScore(String key, int start, int end);
	
	public Set<TypedTuple<Serializable>> getAllWithScore(String key);
	
	public void zAddOne(String key, String val);

	/**
	 * 按分数从大到小
	 * 
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public Set<Serializable> zRevRange(String key, int start, int end);
	
	public Set<TypedTuple<Serializable>> zRevRangeWithScore(String key, int start, int end);

}
