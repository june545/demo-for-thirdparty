package com.example.com.example.rr;

import java.util.Map;

import javax.xml.ws.RequestWrapper;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;

/**
 * Created by June on 2016/6/8.
 */
public interface IApiService {
	Call<RespInfo> getData();

	@GET("index.php")
	Call<RespInfo> getData(@Query("ip") String ip);

	@GET("index.php")
	Call<RespInfo> getData(@QueryMap Map<String, String> map);
}
