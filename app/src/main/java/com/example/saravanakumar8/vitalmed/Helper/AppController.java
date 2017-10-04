package com.example.saravanakumar8.vitalmed.Helper;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.example.saravanakumar8.vitalmed.Rest.ApiClient;
import com.example.saravanakumar8.vitalmed.Rest.ApiInterface;

/**
 * Created by saravanakumar8 on 9/12/2017.
 */

public class AppController extends Application {

    private static AppController instance;
    public static SharedPreferences sharedpreferences;
  //  public static ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    public static boolean profileUpdated = false;


    public static AppController getInstance() {
        return instance;
    }

//    public static ApiInterface getClient() {
//        return apiInterface;
//    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        sharedpreferences = getSharedPreferences(getPackageName(), Context.MODE_PRIVATE);


    }
}
