package com.jo.service;

import java.util.List;

import com.jo.exception.JoException;
import com.jo.po.App;

public interface AppService {

	/**
	 * 初始化App排行榜
	 * 
	 * @param key
	 * @return
	 */
	public List<App> initRankList() throws JoException;
	
	/**
	 * 下载App
	 * 
	 * @param appID
	 * @param score
	 * @throws JoException
	 */
	public void downloadApp(String appID) throws JoException;
	
	/**
	 * 获取App排行榜
	 * 
	 * @return
	 * @throws JoException
	 */
	public List<App> getAppRankList(String key) throws JoException;
	
	/**
	 * 给App打分
	 * 
	 * @param appID
	 * @param score
	 * @throws JoException
	 */
	public void scoreApp(String appID, double score) throws JoException;
	
	/**
	 * 获取Top10 App
	 * 
	 * @return
	 * @throws JoException
	 */
	public List<App> getTop10App(String key) throws JoException;
}
