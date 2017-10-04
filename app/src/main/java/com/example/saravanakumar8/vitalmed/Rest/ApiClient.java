package com.example.saravanakumar8.vitalmed.Rest;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by saravanakumar8 on 9/12/2017.
 */

public class ApiClient {


    private static final String BASE_URL = "http://1.22.171.147:6060/Vitalmed/rest/MobileAppService/";
    private static Retrofit retrofit;

    public static Retrofit getClient() {


        if (retrofit == null) {

         /*   HttpLoggingInterceptor localHttpLoggingInterceptor = new HttpLoggingInterceptor();
            localHttpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);*/
            OkHttpClient.Builder localBuilder = new OkHttpClient.Builder();
            localBuilder.readTimeout(60L, TimeUnit.SECONDS);
            localBuilder.connectTimeout(60L, TimeUnit.SECONDS);
           // localBuilder.addInterceptor(localHttpLoggingInterceptor);
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).client(localBuilder.build()).addConverterFactory(GsonConverterFactory.create()).build();

        }
        return retrofit;

    }

}
