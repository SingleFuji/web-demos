package com.jo.service;

import com.jo.po.JoUser;

public interface JoUserService {

	/**
	 * 获取用户对象
	 * 
	 * @param username
	 * @return
	 */
	public JoUser getUserByUsername(String username);
	
	/**
	 * 写入用户对象
	 * 
	 * @param user
	 */
	public void setUser(JoUser user);
}
