package com.jo.redis.impl;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.jo.common.CacheKey;
import com.jo.redis.RedisStringService;
/**
 * 底层均通过HashMap处理
 * 
 * @author mango_jo
 *
 */
@Service("redisHashMapStringService")
public class RedisStringHashMapServiceImpl implements RedisStringService {

	
	
	@Resource
	private RedisTemplate<Serializable, Serializable> redisTemplate;
	
	
	@Override
	public String getString(final String key) {
		return redisTemplate.execute(new RedisCallback<String>()
		{
			@Override
			public String doInRedis(RedisConnection connection) throws DataAccessException
			{
				byte[] keyH = redisTemplate.getStringSerializer().serialize(CacheKey.REDIS_KEY_PREFIX + key);
				if (connection.exists(keyH))
				{
					List<byte[]> value = connection.hMGet(keyH, redisTemplate.getStringSerializer().serialize(CacheKey.BODY_FIELD));
					String body = redisTemplate.getStringSerializer().deserialize(value.get(0));
					return body;
				}
				return null;
			}
		});
	}

	@Override
	public void putString(String key, String val) {
		putString(key, val, 0);
	}

	@Override
	public void putString(String key, String val, long timeout) {
		redisTemplate.execute(new RedisCallback<Object>()
		{
			@Override
			public Object doInRedis(RedisConnection connection) throws DataAccessException
			{
				byte[] keyH = redisTemplate.getStringSerializer().serialize(CacheKey.REDIS_KEY_PREFIX + key);
				Map<byte[], byte[]> map = new HashMap<byte[], byte[]>();
				map.put(redisTemplate.getStringSerializer().serialize(CacheKey.BODY_FIELD), redisTemplate.getStringSerializer().serialize(val));
				connection.hMSet(keyH, map);
				connection.expire(keyH, timeout > 0 ? timeout : CacheKey.DEFAULT_CACHE_TIME_OUT);
				return null;
			}
		});
	}

}
