package com.koo.test.service;

import com.koo.test.vo.ExchangeRateVo;
import org.springframework.stereotype.Service;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;

@Service
public class ExchangeRateService {

    private ExchangeRateRepository exchangeRateRepository;

    private String ACCESS_KEY = "32de070372c303f29328f8ba6d8ebae9";
    private String CURRENCIES = "AUD,KRW,JPY,PHP";

    public ExchangeRateService() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://apilayer.net/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        exchangeRateRepository = retrofit.create(ExchangeRateRepository.class);
    }

    public ExchangeRateVo getExchangeRateInfo() throws IOException {

        Call<ExchangeRateVo> retrofitCall = exchangeRateRepository.getExchageRateInfo(ACCESS_KEY,CURRENCIES);

        Response<ExchangeRateVo> response = retrofitCall.execute();

        if (!response.isSuccessful()) {
            throw new IOException(response.errorBody() != null ? response.errorBody().string() : "Unkown error");
        }

        return response.body();
    }

}
