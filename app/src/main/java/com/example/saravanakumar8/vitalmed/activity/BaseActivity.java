package com.example.saravanakumar8.vitalmed.activity;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.example.saravanakumar8.vitalmed.Rest.ResponseListener;

/**
 * Created by perusu on 1/10/17.
 */

public class BaseActivity extends AppCompatActivity implements ResponseListener {

    protected static String TAG = BaseActivity.class.getSimpleName();

    protected void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }


    public BaseActivity() {

    }

    @Override
    public void onFailure(Throwable paramThrowable, int paramInt) {
        Log.d(TAG, "onFailure: ");

    }

    @Override
    public void onSuccess(String paramString, int paramInt) {
        // mProgressDialog.dismiss();
    }

    @Override
    public void showErrorDialog(String paramString, int anInt, int paramInt) {
        Log.d(TAG, "showErrorDialog: ");

    }
}
