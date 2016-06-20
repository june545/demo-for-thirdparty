package com.june.eg.retrofit;

import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * Created by June on 2016/6/8.
 */
public class RetrofitAndRxjava {
	static OkHttpClient okHttpClient = new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)).build();

	static String url = "http://www.ip.cn";

	static String domain = "www.baidu.com";

	public static void main(String[] args) {
		RetrofitAndRxjava retrofitAndRxjava = new RetrofitAndRxjava();
//		retrofitAndRxjava.test1();
//		retrofitAndRxjava.test2();
//		retrofitAndRxjava.test3();
		retrofitAndRxjava.getBySuffixPath();
	}
//	<div class="searchform">
//	<form name="fs" action="index.php" method="GET" class="form-search">
//	<input name="ip" type="text" placeholder="请输入要查询的域名或 IP 地址" class="span3">
//	<input id="s" type="submit" class="btn btn-primary" value="查询">
//	</form>
//	</div>
//	<div id="result"><div class="well"><p>查询的 IP：<code>14.215.177.38</code>&nbsp;来自：广东省广州市 电信</p><p>GeoIP: Guangzhou, Guangdong, China</p><p>China Telecom Guangdong</p></div></div>
	public void test1(){
		Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(url).addConverterFactory(new IPInfoConverterFactory()).build();
		IApiService apiService = retrofit.create(IApiService.class);
		Call<IPInfo> call = apiService.getData(domain);
		call.enqueue(new Callback<IPInfo>() {
			@Override
			public void onResponse(Call<IPInfo> call, Response<IPInfo> response) {
				IPInfo respInfo = response.body();
				if (respInfo == null) {
					System.out.println("respinfo is null");
				} else {
					System.out.println(domain + " ===> " + respInfo.domain);
				}

			}

			@Override
			public void onFailure(Call<IPInfo> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}

	private void test2() {
		Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(url).addConverterFactory(new IPInfoConverterFactory()).build();
		IApiService apiService = retrofit.create(IApiService.class);

		Map<String, String> params = new LinkedHashMap<>();
		params.put("ip", domain);
		params.put("a", "a");
		params.put("c", "a");
		params.put("d", "a");
		params.put("e", "a");
		params.put("b", "a");

		Call<IPInfo> call = apiService.getData(params);
		call.enqueue(new Callback<IPInfo>() {
			@Override
			public void onResponse(Call<IPInfo> call, Response<IPInfo> response) {
				IPInfo respInfo = response.body();
				if (respInfo == null) {
					System.out.println("respinfo is null");
				} else {
					System.out.println(domain + " ===> " + respInfo.domain);
				}

			}

			@Override
			public void onFailure(Call<IPInfo> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}

	void test3(){
		String url = "http://www.ip.cn";
		Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(url).addConverterFactory(new IPInfoConverterFactory()).build();
		IApiService apiService = retrofit.create(IApiService.class);
		Call<IPInfo> call = apiService.getData();
		call.enqueue(new Callback<IPInfo>() {
			@Override
			public void onResponse(Call<IPInfo> call, Response<IPInfo> response) {
				IPInfo respInfo = response.body();
				if (respInfo == null) {
					System.out.println("respinfo is null");
				} else {
					System.out.println(domain + " ===> " + respInfo.domain);
				}

			}

			@Override
			public void onFailure(Call<IPInfo> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}

	void getBySuffixPath(){
		Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).baseUrl(url).addConverterFactory(new IPInfoConverterFactory()).build();
		IApiService apiService = retrofit.create(IApiService.class);
		Call<IPInfo> call = apiService.getDataBySuffix("index.php", "www.baidu.com");
		call.enqueue(new Callback<IPInfo>() {
			@Override
			public void onResponse(Call<IPInfo> call, Response<IPInfo> response) {
				IPInfo respInfo = response.body();
				if (respInfo == null) {
					System.out.println("respinfo is null");
				} else {
					System.out.println(domain + " ===> " + respInfo.domain);
				}

			}

			@Override
			public void onFailure(Call<IPInfo> call, Throwable t) {
				t.printStackTrace();
			}
		});
	}

}
