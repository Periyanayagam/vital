package com.example.saravanakumar8.vitalmed.Rest;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.NetworkInfo.State;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetroFitUtils {
    private static RetroFitUtils RetroFitUtility = null;
    private final String TAG = "RetroFitUtils";

    public static RetroFitUtils getInstance() {
        if (RetroFitUtility != null)
            return RetroFitUtility;
        RetroFitUtility = new RetroFitUtils();
        return RetroFitUtility;
    }

    public String getStringFromByte(InputStream paramInputStream) {
        StringBuilder localStringBuilder = new StringBuilder();
        BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(paramInputStream));
        try {
            while (true) {
                String str = localBufferedReader.readLine();
                if (str == null)
                    break;
                localStringBuilder.append(str);
            }
        } catch (IOException localIOException) {
            localIOException.printStackTrace();
        }
        return localStringBuilder.toString();
    }

    public boolean isConnectingToInternet(Context paramContext) {
        ConnectivityManager localConnectivityManager = (ConnectivityManager) paramContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (localConnectivityManager != null) {
            NetworkInfo[] arrayOfNetworkInfo = localConnectivityManager.getAllNetworkInfo();
            if (arrayOfNetworkInfo != null)
                for (int i = 0; i < arrayOfNetworkInfo.length; i++)
                    if (arrayOfNetworkInfo[i].getState() == State.CONNECTED)
                        return true;
        }
        return false;
    }


    public void retrofitEnqueue(Call<ResponseBody> paramCall, final ResponseListener responseListener, final int paramInt) {

        paramCall.enqueue(

                new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> paramResponse) {

                        Log.e("RetroFitUtils", "response.code(): " + paramResponse.code());
                        Log.e("RetroFitUtils", "response.code(): " + paramResponse.raw().code());
                        Log.e("RetroFitUtils", "=" + paramResponse.raw());

                        Object localObject = paramResponse.body();
                        String str = null;
                        if (localObject != null) {
                            str = RetroFitUtils.this.getStringFromByte(((ResponseBody) paramResponse.body()).byteStream());
                            Log.e("RetroFitUtils", "=" + str);
                        }

                        switch (paramResponse.code()) {
                            case 200:
                                //ok
                                responseListener.onSuccess(str, paramInt);
                                return;
                            case 201:
                                //created
                                responseListener.onSuccess(str, paramInt);
                                return;
                            case 400:
                                responseListener.showErrorDialog(RetroFitUtils.this.getStringFromByte(paramResponse.errorBody().byteStream()), paramInt, 400);
                                return;
                            case 401:
                                responseListener.showErrorDialog(RetroFitUtils.this.getStringFromByte(paramResponse.errorBody().byteStream()), paramInt,401);
                                return;
                            case 403:
                                //forbitten
                                responseListener.showErrorDialog(paramResponse.raw().message(), paramInt,403);
                                return;
                            case 404:
                                //not found
                                responseListener.showErrorDialog(paramResponse.raw().message(), paramInt, 404);
                                return;
                            case 500:
                                //server error
                                responseListener.showErrorDialog(RetroFitUtils.this.getStringFromByte(paramResponse.errorBody().byteStream()),  paramInt, 500);
                                return;
                            case 204:
                                return;
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        responseListener.onFailure(t, paramInt);
                    }
                }

        );

    }
}

/* Location:           C:\Users\Perusu\Desktop\to\dex2jar-0.0.9.15\dex2jar-0.0.9.15\classes-dex2jar.jar
 * Qualified Name:     com.rideshare.retrofit.RetroFitUtils
 * JD-Core Version:    0.6.0
 */