package com.jo.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.jo.po.JoUser;
@Repository(value="joUserDao")
public interface JoUserDao {

	public int insertUser(JoUser user);
	
	public JoUser selectByID(@Param("id")String id);
	
	public JoUser select(JoUser user);
}
