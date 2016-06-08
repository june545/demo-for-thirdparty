package com.example.com.example.rr;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by June on 2016/6/8.
 */
public interface IApiService {
	@GET("ips1388.asp")
	Call<RespInfo> getData(@Query("ip") String ip, @Query("action") String action);
}
