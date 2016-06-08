package com.example.com.example.rr;

import com.example.com.example.rr.convert.JsonConverterFactory;

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

		Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(new JsonConverterFactory()).build();
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
				System.out.println("onfailure");
			}
		});
	}

}
