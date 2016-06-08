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
	static String url = "http://www.ip138.com";

	public static void main(String[]args){
//		OkHttpClient client = new OkHttpClient();
//
//		// set time out interval
//		client.setReadTimeout(10, TimeUnit.MINUTES);
//		client.setConnectTimeout(10, TimeUnit.MINUTES);
//		client.setWriteTimeout(10, TimeUnit.MINUTES);
//
//		// print Log
//		client.interceptors().add(new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
//			@Override
//			public void log(String message) {
//				if (message.startsWith("{")) {
//					Logger.json(message);
//				} else {
//					Logger.i("Api", message);
//				}
//			}
//		}));
//
//		// add custom headers
//		client.interceptors().add(new Interceptor() {
//			@Override
//			public Response intercept(Chain chain) throws IOException {
//				Request newRequest = chain.request().newBuilder()
//						.addHeader("platform", "android")
//						.addHeader("appVersion", BuildConfig.VERSION_NAME)
//						.build();
//				return chain.proceed(newRequest);
//			}
//		});


		Retrofit retrofit = new Retrofit.Builder().baseUrl(url).addConverterFactory(new JsonConverterFactory()).build();
		IApiService apiService = retrofit.create(IApiService.class);
		Call<RespInfo> call = apiService.getData("63.223.108.42", "2");
		call.enqueue(new Callback<RespInfo>() {
			@Override
			public void onResponse(Call<RespInfo> call, Response<RespInfo> response) {
				RespInfo respInfo = response.body();
				System.out.println("resp " + respInfo.domain);
			}

			@Override
			public void onFailure(Call<RespInfo> call, Throwable t) {
				System.out.println(t.getMessage());
			}
		});
	}

}
