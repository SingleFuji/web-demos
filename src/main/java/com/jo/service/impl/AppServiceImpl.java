package com.jo.service.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.ZSetOperations.TypedTuple;
import org.springframework.stereotype.Service;

import com.jo.common.CacheKey;
import com.jo.common.JoConstants;
import com.jo.exception.JoException;
import com.jo.po.App;
import com.jo.redis.RedisZSetService;
import com.jo.service.AppService;
import com.jo.utils.RandomUtils;

@Service("appService")
public class AppServiceImpl implements AppService{
	
	private static final Logger logger = LoggerFactory.getLogger(AppServiceImpl.class);

	@Resource
	private RedisZSetService redisZSetService;
	
	private App initApp(String id, String name, int downloadTimes, double score){
		App app = new App();
		app.setId(id);
		app.setName(name);
		app.setDownloadTimes(downloadTimes);
		app.setScore(score);
		return app;
	}
	
	private App initApp(String name){
		App app = new App();
//		SimpleIdGenerator g = new SimpleIdGenerator();
		app.setId(RandomUtils.randomIntWithBound(30)+"");
//		app.setId(g.generateId().toString());
		app.setName(name);
		app.setDownloadTimes(RandomUtils.randomIntWithBound(50));
		app.setScore(RandomUtils.randomDouble(100));
		return app;
	}
	
	@Override
	public List<App> initRankList() throws JoException {
		List<App> rankList = new ArrayList<App>();
		rankList.add(initApp("jike"));
		rankList.add(initApp("wechat"));
		rankList.add(initApp("alipay"));
		rankList.add(initApp("taobao"));
		rankList.add(initApp("yun_music"));
		rankList.add(initApp("jiemian"));
		rankList.add(initApp("facebook"));
		rankList.add(initApp("whatsapp"));
		rankList.add(initApp("sanpchat"));
		rankList.add(initApp("twitter"));
		rankList.add(initApp("google"));
		rankList.add(initApp("youtube"));
		for(App app : rankList){
			logger.info(app.toString());
			redisZSetService.zAdd(CacheKey.APP_SCORE_SORT_KEY, app.getName(), app.getScore());
			redisZSetService.zAdd(CacheKey.APP_DOWNLOAD_SORT_KEY, app.getName(), app.getDownloadTimes());
		}
		
		logger.info(JoConstants.LOGGER_SPLIT_LINE);
		List<App> scoreRankList = getAppRankList(CacheKey.APP_SCORE_SORT_KEY);
		List<App> downloadRankList = getAppRankList(CacheKey.APP_DOWNLOAD_SORT_KEY);
		
		for(App app: scoreRankList){
			logger.info(app.toString());
		}
		logger.info(JoConstants.LOGGER_SPLIT_LINE);
		for(App app: downloadRankList){
			logger.info(app.toString());
		}
		return rankList;
	}
	
	
	@Override
	public void downloadApp(String appID) throws JoException {
		redisZSetService.zAddOne(CacheKey.APP_DOWNLOAD_SORT_KEY, appID);
	}
	
	/**
	 * 设置App id 与 分数信息
	 * 
	 * @param id
	 * @param score
	 * @return
	 */
	private App setAppInfo(String id, double score, String key){
		App app = new App();
//		app.setId(id);
		app.setName(id);
		if(CacheKey.APP_SCORE_SORT_KEY.equals(key)){
			app.setScore(score);
		}else if(CacheKey.APP_DOWNLOAD_SORT_KEY.equals(key)){
			app.setDownloadTimes(new Double(score).intValue());
		}
		return app;
	}
	
	/**
	 * 根据从redis获取的结构组装App排行榜信息
	 * 
	 * @param zSet
	 * @return
	 */
	private List<App> setAppList(Set<TypedTuple<Serializable>> zSet, String key){
		List<App> rankList = new ArrayList<App>();
		Iterator<TypedTuple<Serializable>> it = zSet.iterator();
		while (it.hasNext()) {
			TypedTuple<Serializable> typedTuple = (TypedTuple<Serializable>) it.next();
			Double score = typedTuple.getScore();
			Serializable val = typedTuple.getValue();
			logger.info("val:"+val+" score:"+score);
			App app = setAppInfo((String)val, score, key);
			rankList.add(app);
		}
		return rankList;
	}

	@Override
	public List<App> getAppRankList(String key) throws JoException {
		Set<TypedTuple<Serializable>> zSet = redisZSetService.getAllWithScore(key);
		List<App> rankList = setAppList(zSet, key);
		return rankList;
	}

	@Override
	public void scoreApp(String appID, double score) throws JoException {
		redisZSetService.zIncrBy(CacheKey.APP_SCORE_SORT_KEY, appID, score);
	}

	@Override
	public List<App> getTop10App(String key) throws JoException {
		Set<TypedTuple<Serializable>> zSet = redisZSetService.zRangeWithScore(key, 0, 10);
		List<App> rankList = setAppList(zSet, key);
		return rankList;
	}

}
