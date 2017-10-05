package com.example.saravanakumar8.vitalmed.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.activeandroid.query.Delete;
import com.activeandroid.query.Select;
import com.example.saravanakumar8.vitalmed.R;
import com.example.saravanakumar8.vitalmed.Response.cold.ColdResponse;
import com.example.saravanakumar8.vitalmed.Rest.ApiClient;
import com.example.saravanakumar8.vitalmed.Rest.ApiInterface;
import com.example.saravanakumar8.vitalmed.Rest.ResponseListener;
import com.example.saravanakumar8.vitalmed.Rest.RetroFitUtils;
import com.example.saravanakumar8.vitalmed.activeandroid.Coldmodel;
import com.example.saravanakumar8.vitalmed.adapter.ColdcallAdapter;
import com.example.saravanakumar8.vitalmed.listener.MyRecyclerListener;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class ColdCallActivity extends BaseActivity implements ResponseListener, MyRecyclerListener {

    private static final String TAG = ColdCallActivity.class.getSimpleName();
    RecyclerView recycle_coldcall;

    ColdcallAdapter coldcallAdapter;
    private ProgressDialog mProgressDialog;
    ArrayList<Coldmodel> coldCallList;

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
    private boolean refreshAdapter = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cold_call);


        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call localCall = apiInterface.initSync("7", "3");
        //Call localCall = apiInterface.initSync(Pref.getUSERID(), Pref.getGROUPID());
        RetroFitUtils.getInstance().retrofitEnqueue(localCall, this, 0);
        coldCallList = new ArrayList<>();
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

                new Delete().from(Coldmodel.class).execute();

                Log.d(TAG, "onSuccess: Deleted");


                Gson gson = new Gson();

                ColdResponse syncResponse = (gson.fromJson(paramString, ColdResponse.class));


                for (int i = 0; i < syncResponse.getServiceList().size(); i++) {

                    Coldmodel coldmodel = new Coldmodel(syncResponse.getServiceList().get(i).getCustomer_name(),
                            syncResponse.getServiceList().get(i).getEng_name(),
                            syncResponse.getServiceList().get(i).getEquip_name(),
                            syncResponse.getServiceList().get(i).getCreated_dt(),
                            syncResponse.getServiceList().get(i).getStatus()
                    );
                    coldmodel.save();
                    coldCallList.add(coldmodel);
                }

                coldcallAdapter = new ColdcallAdapter(ColdCallActivity.this, coldCallList);
                recycle_coldcall.setAdapter(coldcallAdapter);

                break;
        }
    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    private void doGetLatestData() {

        coldCallList = new ArrayList<>();

        List<Coldmodel> syncResponse = new Select()
                .from(Coldmodel.class)
                .orderBy("Name ASC")
                .execute();

        for (int i = 0; i < syncResponse.size(); i++) {

            coldCallList.add(new Coldmodel(syncResponse.get(i).getHospitalname(),
                    syncResponse.get(i).getDoctorname(),
                    syncResponse.get(i).getMobilename(),
                    syncResponse.get(i).getDate(),
                    syncResponse.get(i).getStatus()
            ));

        }
        coldcallAdapter.notifyDataSetChanged();

        Log.d(TAG, "doGetLatestData: Saved new Data");
    }

    @Override
    public void showErrorDialog(String paramString, int anInt, int paramInt) {

    }

    @Override
    public void onClick() {
        Log.d(TAG, "onClick: ");
        Intent i = new Intent(ColdCallActivity.this, ColdCallsviewActivity.class);
        startActivityForResult(i, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            if (resultCode == RESULT_OK) {
                if (data.getBooleanExtra("isAdded", false)) {
                    doGetLatestData();
                }
            }
        }
    }
}
