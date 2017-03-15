package com.jo.po;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 应用程序
 * 
 * @author mango_jo
 *
 */
public class App implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3417365153028438963L;

	/**
	 * App ID 唯一标识
	 */
	private String id;
	
	/**
	 * 软件名称
	 */
	private String name;
	
	/**
	 * 下载次数
	 */
	private int downloadTimes;
	
	/**
	 * 评分
	 */
	private double score;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getDownloadTimes() {
		return downloadTimes;
	}

	public void setDownloadTimes(int downloadTimes) {
		this.downloadTimes = downloadTimes;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
}
