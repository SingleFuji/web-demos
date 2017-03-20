package com.jo.utils;

import static org.junit.Assert.*;

import java.lang.reflect.Type;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.jo.po.Result;
import com.jo.po.User;

public class GsonUtilsTest {

//	public static final Gson gson = new Gson();
//	
//	public static final Gson gsonNull = new GsonBuilder().serializeNulls().create();
//	
	private User user = new User();
	
	private String srcUserStr = "{\"id\":\"6a46c490-90fa-4012-bbfe-41477432f440\",\"age\":0,\"address\":\"PRC\",\"passportNo\":\"00001\"}";
	
	private String srcUserStrAlter = "{\"id\":\"6a46c490-90fa-4012-bbfe-41477432f440\",\"age\":0,\"address\":\"PRC\",\"passport_no\":\"00001\"}";
	
	private String srcUserStrAlterMulti = "{\"id\":\"6a46c490-90fa-4012-bbfe-41477432f440\",\"age\":0,\"address\":\"PRC\",\"passport_no\":\"00001\",\"passportNo\":\"00002\"}";

	
	@Before
	public void setUp() throws Exception {
		user.setAddress("PRC");
		user.setId(UUID.randomUUID().toString());
		user.setPassportNo("00001");
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		int i = GsonUtils.fromJson("100", int.class);
		System.out.println(i);
		
		String iStr = GsonUtils.toJson(100);
		System.out.println(iStr);
		
		String userStr = GsonUtils.toJson(user);
		System.out.println(userStr);
		
		String userStrNull = GsonUtils.toJsonNull(user);
		System.out.println(userStrNull);
		
		
		User userTar = GsonUtils.fromJson(srcUserStr, User.class);
		System.out.println(userTar.toString());
		
		User userTarAlter = GsonUtils.fromJson(srcUserStrAlter, User.class);
		System.out.println(userTarAlter.toString());
		
		User userTarAlterMutil = GsonUtils.fromJson(srcUserStrAlterMulti, User.class);
		System.out.println(userTarAlterMutil.toString());
		
		
//		User userTarNull = GsonUtils.fromJsonNull(srcUserStr, User.class);
//		System.out.println(userTarNull.toString());
		String json = "";
		Type userType = new TypeToken<Result<User>>(){}.getType();
		Result<User> userResult = GsonUtils.fromJson(json, userType);
	}

}
