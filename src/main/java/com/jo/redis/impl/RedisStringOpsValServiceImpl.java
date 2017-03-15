package com.jo.redis.impl;

import java.io.Serializable;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.jo.common.CacheKey;
import com.jo.redis.RedisStringService;

@Service("redisStringOpsValService")
public class RedisStringOpsValServiceImpl implements RedisStringService {

	@Resource
	private RedisTemplate<Serializable, Serializable> redisTemplate;
	
	
	@Override
	public String getString(String key) {
		String result = (String) redisTemplate.opsForValue().get(CacheKey.REDIS_KEY_PREFIX + key);
		return result;
	}

	@Override
	public void putString(String key, String val) {
		redisTemplate.opsForValue().set(CacheKey.REDIS_KEY_PREFIX + key, val);
	}

	@Override
	public void putString(String key, String val, long timeout) {
		redisTemplate.opsForValue().set(CacheKey.REDIS_KEY_PREFIX + key, val, timeout > 0 ? timeout : CacheKey.DEFAULT_CACHE_TIME_OUT);
	}

}
