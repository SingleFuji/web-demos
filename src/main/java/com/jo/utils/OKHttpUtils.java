package com.jo.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpUtils {

	private static final OkHttpClient mOkHttpClient = new OkHttpClient();
	
	private static final String DEFAULT_CHARSET = "UTF-8";
	
	static {
//		mOkHttpClient.;
	}

	/**
	 * 不会开启异步线程
	 * 
	 * @param request
	 * @return
	 * @throws IOException
	 */
	public static Response execute(Request request) throws IOException {
		return mOkHttpClient.newCall(request).execute();
	}
	
	/**
	 * 开启异步线程访问网络
	 * 
	 * @param request
	 * @param responseCallback
	 */
	public static void enqueue(Request request, Callback responseCallback){
		mOkHttpClient.newCall(request).enqueue(responseCallback);
	}
	
	/**
	 * 开启异步线程访问网络  且不关注返回结果（实现空callback）
	 * 
	 * @param request
	 */
	public static void enqueue(Request request){
		mOkHttpClient.newCall(request).enqueue(new Callback() {
			
			@Override
			public void onResponse(Call call, Response response) throws IOException {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void onFailure(Call call, IOException e) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	/**
	 * 同步获取请求响应结果
	 * 
	 * @param url
	 * @return
	 * @throws IOException
	 */
	public static String getStringFromServer(String url) throws IOException{
		Request request = new Request.Builder().url(url).build();
		Response response = execute(request);
		if(response.isSuccessful()){
			String responseUrl = response.body().string();
			return responseUrl;
		}else{
			throw new IOException("Unexcepted code "+response);
		}
	}
}
