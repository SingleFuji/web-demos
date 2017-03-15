package com.jo.common;

/**
 * 缓存相关键值
 * 
 * @author zhouhang
 *
 */
public class CacheKey {
	
	/**默认缓存的过期时间：一天*/
	public final static long DEFAULT_CACHE_TIME_OUT = 86400/*一天*/;
	
	/**交易缓存的过期时间*/
	public final static long TRADE_CACHE_TIME_OUT = 300;
	
	/** 缓存时间2小时 **/
	public final static long TWO_HOUR = 7200;
	
	/**
	 * 按HashMap存储key时val中field
	 */
	public static final String BODY_FIELD = "body";
	
	/**
	 * key前缀
	 */
	public static final String REDIS_KEY_PREFIX = "com:jo:";
	
	/**
	 * app 评分排行榜key
	 */
	public static final String APP_SCORE_SORT_KEY = "app-score-rank-list";
	
	/**
	 * app 下载量排行榜key
	 */
	public static final String APP_DOWNLOAD_SORT_KEY = "app-download-rank-list";
	
}
