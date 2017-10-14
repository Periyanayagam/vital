package com.example.saravanakumar8.vitalmed.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.activeandroid.Model;
import com.activeandroid.query.Select;
import com.example.saravanakumar8.vitalmed.R;
import com.example.saravanakumar8.vitalmed.Response.follow.FollowResponse;
import com.example.saravanakumar8.vitalmed.Rest.ApiClient;
import com.example.saravanakumar8.vitalmed.Rest.ApiInterface;
import com.example.saravanakumar8.vitalmed.Rest.ResponseListener;
import com.example.saravanakumar8.vitalmed.Rest.RetroFitUtils;
import com.example.saravanakumar8.vitalmed.activeandroid.Coldmodel;
import com.example.saravanakumar8.vitalmed.adapter.FollowupCallAdapter;
import com.example.saravanakumar8.vitalmed.model.Datamodel;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class FollowupCallActivity extends AppCompatActivity implements ResponseListener {


    private static final String TAG = FollowupCallActivity.class.getSimpleName();
    RecyclerView recycle_followupcall;

    FollowupCallAdapter followupCallAdapter;

    ProgressDialog mProgressDialog;

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
        setContentView(R.layout.activity_followup_call);

        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage("Please wait...");
        mProgressDialog.show();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call localCall = apiInterface.initSync("2", "9");
        //Call localCall = apiInterface.initSync(Pref.getUSERID(), Pref.getGROUPID());
        RetroFitUtils.getInstance().retrofitEnqueue(localCall, this, 0);

        recycle_followupcall = (RecyclerView) findViewById(R.id.recycle_followupcall);
        recycle_followupcall.setHasFixedSize(true);

        //Recyclerview Init
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycle_followupcall.setLayoutManager(layoutManager);

        prepareData();


    }

    private void prepareData() {
        List<Coldmodel> myList = new Select()
                .from(Coldmodel.class)
                .execute();

        setAdapter(myList);

    }

    private void setAdapter(List<Coldmodel> followList) {

        if (followupCallAdapter == null) {
            followupCallAdapter = new FollowupCallAdapter(this, followList);
            recycle_followupcall.setAdapter(followupCallAdapter);
        } else {
            followupCallAdapter.refresh(followList);
        }

    }

    @Override
    public void onFailure(Throwable paramThrowable, int paramInt) {

    }

    @Override
    public void onSuccess(String paramString, int paramInt) {
        mProgressDialog.dismiss();
        Log.d(TAG, "onSuccess: " + paramString);

        switch (paramInt) {
            case 0:
                ArrayList<Datamodel> coldcall = new ArrayList<>();
                Gson gson = new Gson();

                Log.d(TAG, "onSuccess: " + paramString);

                FollowResponse syncResponse = (gson.fromJson(paramString, FollowResponse.class));
                Log.d(TAG, "onSuccess: MainActivity" + syncResponse.getServiceList().get(0).getStatus());

                for (int i = 0; i < syncResponse.getServiceList().size(); i++) {
                    coldcall.add(new Datamodel(syncResponse.getServiceList().get(i).getCustomer_name(),
                            syncResponse.getServiceList().get(i).getEng_name(),
                            syncResponse.getServiceList().get(i).getEquip_name(),
                            syncResponse.getServiceList().get(i).getCreated_dt(),
                            syncResponse.getServiceList().get(i).getStatus()
                    ));
                }


                /*followupCallAdapter = new FollowupCallAdapter(FollowupCallActivity.this, coldcall);
                recycle_followupcall.setAdapter(followupCallAdapter);*/

                break;
        }


    }

    @Override
    public void showErrorDialog(String paramString, int anInt, int paramInt) {

    }
}
