package com.example.saravanakumar8.vitalmed.Rest;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by saravanakumar8 on 9/12/2017.
 */

public interface ApiInterface {

//    @FormUrlEncoded
//    @POST("login.php")
//    Call<BasicResponse> login(@Field("account_username") String account_username, @Field("account_mobile_no") String account_mobile_no);
//
//
//    @GET("setting.php")
//    Call<SettingResponse> getsetting();

    // Passing MODEL as Parameter

    @FormUrlEncoded
    @POST("initialSync")
    Call<ResponseBody> initSync(@Field("userid") String userid, @Field("groupid") String groupid);

    @FormUrlEncoded
    @POST("userLogin")
    Call<ResponseBody> doLogin(@Field("username") String username, @Field("password") String password);


}
