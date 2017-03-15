package com.jo.redis.impl;

import java.io.Serializable;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

import com.jo.redis.RedisZSetService;

@Service("redisZSetService")
public class RedisZSetServiceImpl implements RedisZSetService{

	private static final Logger logger = LoggerFactory.getLogger(RedisZSetServiceImpl.class);
	
	@Resource
	private RedisTemplate<Serializable, Serializable> redisTemplate;
	
	
	@Override
	public void zAdd(String key, String val, double score) {
		redisTemplate.opsForZSet().add(key, val, score);
	}
	
	@Override
	public void zIncrBy(String key, String val, double score) {
		redisTemplate.opsForZSet().incrementScore(key, val, score);
	}

	@Override
	public long zCard(String key) {
		return redisTemplate.opsForZSet().zCard(key);
	}

	@Override
	public Set<TypedTuple<Serializable>> getAllWithScore(String key) {
		return zRangeWithScore(key, 0, -1);
	}

	@Override
	public Set<Serializable> zRange(String key, int start, int end) {
		Set<Serializable> result = redisTemplate.opsForZSet().range(key, start, end);
		return result;
	}

	@Override
	public Set<TypedTuple<Serializable>> zRangeWithScore(String key, int start, int end) {
		Set<TypedTuple<Serializable>> result = redisTemplate.opsForZSet().rangeWithScores(key, start, end);
		return result;
	}

	@Override
	public void zAddOne(String key, String val) {
		zAdd(key, val, 1);
	}

	@Override
	public Set<Serializable> zRevRange(String key, int start, int end) {
		return redisTemplate.opsForZSet().reverseRangeByScore(key, start, end);
	}

	@Override
	public Set<TypedTuple<Serializable>> zRevRangeWithScore(String key, int start, int end) {
		Set<TypedTuple<Serializable>> result = redisTemplate.opsForZSet().reverseRangeByScoreWithScores(key, start, end);
		return result;
	}



}
