package com.koo.test.service;

import com.koo.test.vo.ExchangeRateVo;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ExchangeRateRepository {

    @GET("api/live")
    Call<ExchangeRateVo> getExchageRateInfo(@Query("access_key") String access_key, @Query("currencies") String currencies);
}
