package com.example.saravanakumar8.vitalmed.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.saravanakumar8.vitalmed.model.Datamodel;
import com.example.saravanakumar8.vitalmed.R;
import com.example.saravanakumar8.vitalmed.Response.service.ServiceResponse;
import com.example.saravanakumar8.vitalmed.Rest.ApiClient;
import com.example.saravanakumar8.vitalmed.Rest.ApiInterface;
import com.example.saravanakumar8.vitalmed.Rest.ResponseListener;
import com.example.saravanakumar8.vitalmed.Rest.RetroFitUtils;
import com.example.saravanakumar8.vitalmed.adapter.ServicecallAdapter;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;

public class ServiceCallActivity extends BaseActivity implements ResponseListener {

    private static final String TAG = ServiceCallActivity.class.getSimpleName();
    RecyclerView recycle_servicecall;

    ServicecallAdapter servicecallAdapter;
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
        setContentView(R.layout.activity_service_call);
        mProgressDialog = new ProgressDialog(this);
        recycle_servicecall = (RecyclerView) findViewById(R.id.recycle_servicecall);
        recycle_servicecall.setHasFixedSize(true);

        //Recyclerview Init
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycle_servicecall.setLayoutManager(layoutManager);


        mProgressDialog.setMessage("Please Wait");
        mProgressDialog.show();
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call localCall = apiInterface.initSync("7", "3");
        //Call localCall = apiInterface.initSync(Pref.getUSERID(), Pref.getGROUPID());
        RetroFitUtils.getInstance().retrofitEnqueue(localCall, this, 3);


    }


    @Override
    public void onFailure(Throwable paramThrowable, int paramInt) {

    }

    @Override
    public void onSuccess(String paramString, int paramInt) {

        mProgressDialog.dismiss();

        switch (paramInt) {
            case 3:

                Gson gson = new Gson();

                Log.d(TAG, "onSuccess: " + paramString);

                ServiceResponse serviceResponse = ((ServiceResponse) gson.fromJson(paramString, ServiceResponse.class));
                Log.d(TAG, "onSuccess: MainActivity" + paramString);

                ArrayList<Datamodel> syncResponse = new ArrayList<>();
                Log.d(TAG, "onSuccess: " + serviceResponse.getServiceList().size());

                for (int i = 0; i < serviceResponse.getServiceList().size(); i++) {

                    syncResponse.add(new Datamodel(serviceResponse.getServiceList().get(i).getCustomer_name(),
                            serviceResponse.getServiceList().get(i).getEng_name(),
                            serviceResponse.getServiceList().get(i).getContact_no(),
                            serviceResponse.getServiceList().get(i).getCreated_dt(),
                            serviceResponse.getServiceList().get(i).getStatus()
                    ));
                }

                servicecallAdapter = new ServicecallAdapter(ServiceCallActivity.this, syncResponse);
                recycle_servicecall.setAdapter(servicecallAdapter);

                break;
        }


    }

    @Override
    public void showErrorDialog(String paramString, int anInt, int paramInt) {

    }
}
