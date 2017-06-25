package com.jo.utils;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.jo.po.App;
import com.jo.po.Result;
import com.jo.po.User;

public class GsonUtilsTest {

	// public static final Gson gson = new Gson();
	//
	// public static final Gson gsonNull = new
	// GsonBuilder().serializeNulls().create();
	//
	private User user = new User();

	private App app = new App();
	
	private List<App> appList = new ArrayList<App>();
	
	private Result<User> result = new Result<User>();

	private String srcUserStr = "{\"id\":\"6a46c490-90fa-4012-bbfe-41477432f440\",\"age\":0,\"address\":\"PRC\",\"passportNo\":\"00001\"}";

	private String srcUserStrAlter = "{\"id\":\"6a46c490-90fa-4012-bbfe-41477432f440\",\"age\":0,\"address\":\"PRC\",\"passport_no\":\"00001\"}";

	private String srcUserStrAlterMulti = "{\"id\":\"6a46c490-90fa-4012-bbfe-41477432f440\",\"age\":0,\"address\":\"PRC\",\"passport_no\":\"00001\",\"passportNo\":\"00002\"}";

	@Before
	public void setUp() throws Exception {
		app.setDownloadTimes(5);
		app.setName("ZoneApp");
		appList.add(app);
		
		
		user.setAddress("PRC1");
		user.setId(UUID.randomUUID().toString());
		user.setPassportNo("00002");
		user.setAppList(appList);

		result.setCode(0);
		result.setMessage("test msg");
		result.setData(user);
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

		String resultStr = GsonUtils.toJson(result);
		System.out.println(resultStr);

		String json = "{\"code\":0,\"message\":\"test msg\",\"data\":{\"id\":\"a56ce1cd-cffe-4aec-bf5c-aa8119a0de20\",\"age\":0,\"address\":\"PRC\",\"passportNo\":\"00001\"}}";
		Type userType = new TypeToken<Result<User>>() {
		}.getType();
		Result<User> userResult = GsonUtils.fromJson(json, userType);
		System.out.println(userResult.toString());
	}

	@Test
	public void testGsonReader() throws IOException {
		JsonReader reader = new JsonReader(new StringReader(srcUserStr));
		reader.beginObject();
		while (reader.hasNext()) {
			String s = reader.nextName();
			switch (s) {
			case "id":
				user.setId(reader.nextString());
				break;
			case "age":
				user.setAge(reader.nextInt());
				break;
			case "address":
				user.setAddress(reader.nextString());
				break;
			case "passportNo":
				user.setPassportNo(reader.nextString());
				break;
			default:
				break;
			}
		}
		reader.endObject();
		System.out.println(user.toString());
	}
	
	@Test
	public void testGsonWriter() throws IOException{
		Gson gson = new Gson();
		gson.toJson(user, System.out);
		System.out.println();
		JsonWriter writer = new JsonWriter(new OutputStreamWriter(System.out));
		writer.beginObject()
		.name("id").value(UUID.randomUUID().toString())
		.name("address").value("Boston")
		.name("passportNo").nullValue()
		.endObject();
		writer.flush();
	}
}
