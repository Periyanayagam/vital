package com.example.saravanakumar8.vitalmed.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.example.saravanakumar8.vitalmed.helper.Pref;
import com.example.saravanakumar8.vitalmed.model.response.LoginResponse;
import com.example.saravanakumar8.vitalmed.R;
import com.example.saravanakumar8.vitalmed.Rest.ApiClient;
import com.example.saravanakumar8.vitalmed.Rest.ApiInterface;
import com.example.saravanakumar8.vitalmed.Rest.ResponseListener;
import com.example.saravanakumar8.vitalmed.Rest.RetroFitUtils;
import com.google.gson.Gson;

import retrofit2.Call;

public class LoginActivity extends BaseActivity implements ResponseListener {

    LinearLayout linear_login;

    EditText edt_username, edt_password;
    private ProgressDialog mProgressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mProgressDialog = new ProgressDialog(this);
        linear_login = (LinearLayout) findViewById(R.id.linear_login);
        edt_username = (EditText) findViewById(R.id.edt_username);
        edt_password = (EditText) findViewById(R.id.edt_password);


        linear_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()) {
                    doLogin();
                }

                //fieldcheck();

            }

        });
    }

    private boolean validate() {

        if (!(edt_username.getText().toString().trim().length() > 0)) {
            showMessage("Username required");
            return false;
        }

        if (!(edt_password.getText().toString().trim().length() > 0)) {
            showMessage("Password required");
            return false;
        }

        return true;
    }


    private void doLogin() {

        mProgressDialog.setTitle("Login");
        mProgressDialog.setMessage("Please wait...");
        mProgressDialog.show();


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call localCall = apiInterface.doLogin(edt_username.getText().toString().trim(), edt_password.getText().toString().trim());
        RetroFitUtils.getInstance().retrofitEnqueue(localCall, this, 1);

    }


    @Override
    public void onSuccess(String paramString, int paramInt) {

        mProgressDialog.dismiss();
        Gson gson = new Gson();

        Log.d(TAG, "onSuccess: " + paramString);

        LoginResponse loginResponseModel = ((LoginResponse) gson.fromJson(paramString, LoginResponse.class));
        Log.d(TAG, "onSuccess: MainActivity" + paramString);

        if (loginResponseModel.getStatus().equals("1")) {
            showMessage("Logged in Successfully");
            Intent login = new Intent(LoginActivity.this, DashboardActivity.class);
            login.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            Pref.savelogin(edt_username.getText().toString().trim(),edt_password.getText().toString().trim(), loginResponseModel.getUserid(), loginResponseModel.getGroupid());
            startActivity(login);
        } else {
            showMessage("Invalid Login");
        }
    }



    //Login functions

//    Call<BasicResponse> call;
//
//    private void update_profile() {
//
//        String username = edt_username.getText().toString();
//        String password = edt_password.getText().toString();
//
//        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
//
//        call = apiService.login(username, password);
//
//
//        call.enqueue(new Callback<BasicResponse>() {
//            @Override
//            public void onResponse(Call<BasicResponse> call, Response<BasicResponse> response) {
//
//                Toast.makeText(LoginActivity.this, "Login successfull", Toast.LENGTH_SHORT).show();
//            }
//
//            @Override
//            public void onFailure(Call<BasicResponse> call, Throwable t) {
//
//                Toast.makeText(LoginActivity.this, "Login failed", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
}
