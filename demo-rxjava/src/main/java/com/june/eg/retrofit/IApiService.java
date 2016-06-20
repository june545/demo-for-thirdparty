package com.june.eg.retrofit;

import java.util.Map;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by June on 2016/6/8.
 */
public interface IApiService {
	@GET("index.php?ip=www.baidu.com")
	Call<IPInfo> getData();

	@GET("index.php")
	Call<IPInfo> getData(@Query("ip") String ip);

	@GET("index.php")
	Call<IPInfo> getData(@QueryMap Map<String, String> map);

	@GET("{path}")
	Call<IPInfo> getDataBySuffix(@Path("path") String path, @Query("ip") String ip);
}
