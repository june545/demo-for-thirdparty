package com.example.com.example.rr;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by June on 2016/6/8.
 */
public interface IApiService {
	@GET("index.php")
	Call<RespInfo> getData(@Query("ip") String ip);
}
