package com.jo.utils;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Type;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.jo.po.Result;
import com.jo.po.User;

public class FastjsonUtilsTest {

	private User user = new User();

	private Result<User> result = new Result<User>();

	private String srcUserStr = "{\"id\":\"6a46c490-90fa-4012-bbfe-41477432f440\",\"age\":0,\"address\":\"PRC\",\"passportNo\":\"00001\"}";

	private String srcUserStrAlter = "{\"id\":\"6a46c490-90fa-4012-bbfe-41477432f440\",\"age\":0,\"address\":\"PRC\",\"passport_no\":\"00001\"}";

	private String srcUserStrAlterMulti = "{\"id\":\"6a46c490-90fa-4012-bbfe-41477432f440\",\"age\":0,\"address\":\"PRC\",\"passport_no\":\"00001\",\"passportNo\":\"00002\"}";

	@Before
	public void setUp() throws Exception {
		user.setAddress("PRC1");
		user.setId(UUID.randomUUID().toString());
		user.setPassportNo("00002");

		result.setCode(0);
		result.setMessage("test msg");
		result.setData(user);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		String str = JSON.toJSONString(user);
		System.out.println(str);
		
		JSONObject jo = JSON.parseObject(srcUserStr);
		System.out.println(jo.toString());
		System.out.println(jo.toJSONString());
		
		System.out.println("==Fastjson parse POJO==");
		User u = JSON.parseObject(srcUserStr, User.class);
		System.out.println(u.toString());
		
		System.out.println("==Fastjson parse POJO Generic==");
		Type type = new TypeReference<User>(){}.getType();
		User u1 = JSON.parseObject(srcUserStr, type);
		System.out.println(u1.toString());
		
		System.out.println("==Fastjson convert POJO to json bytes==");
		byte[] uBytes = JSON.toJSONBytes(user);
		for(byte b:uBytes){
			System.out.print(b+" ");
		}
		System.out.println();
		System.out.println("==Fastjson write POJO as json string to OutputStream==");
		
		OutputStream os = System.out;
		JSON.writeJSONString(os, user);
		
		System.out.println();
		System.out.println("==Fastjson write POJO as json string to Writer==");
		Writer w = new OutputStreamWriter(System.err);
		JSON.writeJSONString(w, user);
		w.flush();
		
		System.out.println();
		System.out.println("==writer feature==");
		SerializerFeature[] sfArr = {
				SerializerFeature.PrettyFormat,
				SerializerFeature.SortField,
				SerializerFeature.WriteNullStringAsEmpty
				};
		JSON.writeJSONString(w, user, sfArr);
		w.flush();
	}

}
