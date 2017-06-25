package com.jo.utils;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpUtilsTest {

	private static final String BAIDU_URL = "https://www.baidu.com";
	private static final String GITHUB_URL = "https://api.github.help";
	
	public static String setHttpUrl(){
		HttpUrl.Builder urlBuilder = HttpUrl.parse(GITHUB_URL).newBuilder();
		urlBuilder.addQueryParameter("v", "1.0");
		urlBuilder.addQueryParameter("user", "jo");
		
		return urlBuilder.build().toString();
	}
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws IOException {
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(BAIDU_URL).build();
		System.out.println(request.toString());
		
		String gitParamUrl = setHttpUrl();
		Request gitReq = new Request.Builder()
				.header("Authorization", "my token uuuu")
				.url(gitParamUrl).build();
		System.out.println(gitReq.toString());
//		Response resp = client.newCall(gitReq).execute();
		Response resp = client.newCall(request).execute();
		System.out.println(resp);
//		client.newCall(gitReq).enqueue(new Callback() {
		client.newCall(request).enqueue(new Callback() {
			
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				if(!response.isSuccessful()){
					throw new IOException("Unexpected code " + response);
				}else{
					System.out.println("success"+response);
				}
			}
			
			@Override
			public void onFailure(Call call, IOException e) {
				e.printStackTrace();
			}
		});
	}

}
