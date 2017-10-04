package com.example.saravanakumar8.vitalmed;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.saravanakumar8.vitalmed.Helper.Pref;
import com.example.saravanakumar8.vitalmed.Model.Datamodel;
import com.example.saravanakumar8.vitalmed.Response.cold.ColdResponse;
import com.example.saravanakumar8.vitalmed.Rest.ApiClient;
import com.example.saravanakumar8.vitalmed.Rest.ApiInterface;
import com.example.saravanakumar8.vitalmed.Rest.ResponseListener;
import com.example.saravanakumar8.vitalmed.Rest.RetroFitUtils;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;

public class ColdCallActivity extends BaseActivity implements ResponseListener {

    private static final String TAG = ColdCallActivity.class.getSimpleName();
    RecyclerView recycle_coldcall;

    ColdcallAdapter coldcallAdapter;
    private ProgressDialog mProgressDialog;

    // ArrayList<Datamodel> data;

    private final String[] hospitalname = {"Saravana Hospitals Pvt ltd", "Saravana Hospitals Pvt ltd", "Saravana Hospitals Pvt ltd", "Saravana Hospitals Pvt ltd", "Saravana Hospitals Pvt ltd",
            "Saravana Hospitals Pvt ltd", "Saravana Hospitals Pvt ltd", "Saravana Hospitals Pvt ltd", "Saravana Hospitals Pvt ltd", "Saravana Hospitals Pvt ltd"};
    private final String[] doctoname = {"1.5", "1.5", "1.5", "1.5", "1.5", "1.5", "1.5", "1.5", "1.5", "1.5"};
    private final String[] mobilename = {"MULTIMOBIL 2.5", "MULTIMOBIL 2.5", "MULTIMOBIL 2.5", "MULTIMOBIL 2.5", "MULTIMOBIL 2.5", "MULTIMOBIL 2.5", "MULTIMOBIL 2.5",
            "MULTIMOBIL 2.5", "MULTIMOBIL 2.5", "MULTIMOBIL 2.5"};
    private final String[] attendername = {"Sathish", "Sathish", "Sathish", "Sathish", "Sathish", "Sathish", "Sathish", "Sathish", "Sathish", "Sathish"};
    private final String[] date = {"207-03-31", "207-03-31", "207-03-31", "207-03-31", "207-03-31", "207-03-31", "207-03-31", "207-03-31", "207-03-31", "207-03-31"};
    private final String[] status = {"Status1", "Status1", "Status1", "Status1", "Status1", "Status1", "Status1", "Status1", "Status1", "Status1"};
    private final int[] images = {R.drawable.success_icon, R.drawable.success_icon, R.drawable.success_icon, R.drawable.success_icon, R.drawable.success_icon, R.drawable.success_icon,
            R.drawable.success_icon, R.drawable.success_icon, R.drawable.success_icon, R.drawable.success_icon};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold_call);


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call localCall = apiInterface.initSync("7", "3");
        //Call localCall = apiInterface.initSync(Pref.getUSERID(), Pref.getGROUPID());
        RetroFitUtils.getInstance().retrofitEnqueue(localCall, this, 0);

        recycle_coldcall = (RecyclerView) findViewById(R.id.recycle_coldcall);
        recycle_coldcall.setHasFixedSize(true);

        //Recyclerview Init
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycle_coldcall.setLayoutManager(layoutManager);


    }

    @Override
    public void onFailure(Throwable paramThrowable, int paramInt) {

    }

    @Override
    public void onSuccess(String paramString, int paramInt) {


        Log.d(TAG, "onSuccess: " + paramString);

        switch (paramInt) {
            case 0:
                ArrayList<Datamodel> android_version = new ArrayList<>();
                Gson gson = new Gson();


                ColdResponse syncResponse = (gson.fromJson(paramString, ColdResponse.class));

                for (int i = 0; i < syncResponse.getServiceList().size(); i++) {

                    android_version.add(new Datamodel(syncResponse.getServiceList().get(i).getCustomer_name(),
                            syncResponse.getServiceList().get(i).getEng_name(),
                            syncResponse.getServiceList().get(i).getEquip_name(),
                            syncResponse.getServiceList().get(i).getCreated_dt(),
                            syncResponse.getServiceList().get(i).getStatus()
                    ));
                }


                coldcallAdapter = new ColdcallAdapter(ColdCallActivity.this, android_version);
                recycle_coldcall.setAdapter(coldcallAdapter);

                break;
        }
    }

    @Override
    public void showErrorDialog(String paramString, int anInt, int paramInt) {

    }
}
