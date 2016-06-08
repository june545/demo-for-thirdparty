package com.example.com.example.rr;

import com.example.com.example.rr.convert.MyConverterFactory;

import java.util.LinkedHashMap;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by June on 2016/6/8.
 */
public class RetrofitAndRxjava {
	static String url = "http://www.ip.cn";

	static String domain = "www.baidu.com";

	public static void main(String[] args) {
		RetrofitAndRxjava retrofitAndRxjava = new RetrofitAndRxjava();
//		retrofitAndRxjava.test1();
//		retrofitAndRxjava.test2();
		retrofitAndRxjava.test3();
	}

	public void test1(){
		Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(new MyConverterFactory()).build();
		IApiService apiService = retrofit.create(IApiService.class);
		Call<RespInfo> call = apiService.getData(domain);
		call.enqueue(new Callback<RespInfo>() {
			@Override
			public void onResponse(Call<RespInfo> call, Response<RespInfo> response) {
				RespInfo respInfo = response.body();
				if (respInfo == null) {
					System.out.println("respinfo is null");
				} else {
					System.out.println(domain + " ===> " + respInfo.domain);
				}

			}

			@Override
			public void onFailure(Call<RespInfo> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}

	private void test2() {
		Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(new MyConverterFactory()).build();
		IApiService apiService = retrofit.create(IApiService.class);

		Map<String, String> params = new LinkedHashMap<>();
		params.put("ip", domain);

		Call<RespInfo> call = apiService.getData(params);
		call.enqueue(new Callback<RespInfo>() {
			@Override
			public void onResponse(Call<RespInfo> call, Response<RespInfo> response) {
				RespInfo respInfo = response.body();
				if (respInfo == null) {
					System.out.println("respinfo is null");
				} else {
					System.out.println(domain + " ===> " + respInfo.domain);
				}

			}

			@Override
			public void onFailure(Call<RespInfo> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}

	void test3(){
		String url = "http://www.ip.cn/index.php?ip=www.baidu.com";
		Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(new MyConverterFactory()).build();
		IApiService apiService = retrofit.create(IApiService.class);
		Call<RespInfo> call = apiService.getData();
		call.enqueue(new Callback<RespInfo>() {
			@Override
			public void onResponse(Call<RespInfo> call, Response<RespInfo> response) {
				RespInfo respInfo = response.body();
				if (respInfo == null) {
					System.out.println("respinfo is null");
				} else {
					System.out.println(domain + " ===> " + respInfo.domain);
				}

			}

			@Override
			public void onFailure(Call<RespInfo> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}
}
