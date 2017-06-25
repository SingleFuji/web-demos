package com.jo.service.impl;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import com.jo.dao.JoUserDao;
import com.jo.po.JoUser;
import com.jo.redis.RedisStringService;
import com.jo.service.JoUserService;
import com.jo.utils.GsonUtils;

/**
 * 
 * @author mango_jo
 * @date 2017年6月25日
 *
 */
@Service(value="joUserService")
public class JoUserServiceImpl implements JoUserService {

	@Resource
	private JoUserDao joUserDao;
	
	@Resource
	private RedisStringService redisStringOpsValService;
	
	@Override
	public JoUser getUserByUsername(String username) {
		String userStr = redisStringOpsValService.getString(username);
		if(!StringUtils.isEmpty(userStr)){
			return GsonUtils.fromJson(userStr, JoUser.class);
		}
		JoUser tmp = new JoUser();
		tmp.setUsername(username);
		JoUser user = joUserDao.select(tmp);
		if(null != user){
			userStr = GsonUtils.toJson(user);
			redisStringOpsValService.putString(user.getUsername(), userStr);
		}
		return user;
	}

	@Override
	public void setUser(JoUser user) {
		// TODO Auto-generated method stub
		int success = joUserDao.insertUser(user);
		if(success == 1){
			String userStr = GsonUtils.toJson(user);
			redisStringOpsValService.putString(user.getUsername(), userStr);
		}
	}

}
