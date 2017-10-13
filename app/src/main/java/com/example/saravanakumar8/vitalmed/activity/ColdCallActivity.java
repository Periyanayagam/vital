package com.example.saravanakumar8.vitalmed.activity;

import android.app.Activity;
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
    ArrayList<Coldmodel> coldCallList;

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

//asbcv
        Log.d(TAG, "onSuccess: " + paramString);

        switch (paramInt) {
            case 0:

                new Delete().from(Coldmodel.class).execute();

                Log.d(TAG, "onSuccess: Deleted");


                Gson gson = new Gson();

                ColdResponse coldResponse = (gson.fromJson(paramString, ColdResponse.class));

                for (int i = 0; i < coldResponse.getServiceList().size(); i++) {

                    Coldmodel coldmodel = new Coldmodel(
                            coldResponse.getServiceList().get(i).getRequest_id(),
                            coldResponse.getServiceList().get(i).getCustomer_name(),
                            coldResponse.getServiceList().get(i).getContact_no(),
                            coldResponse.getServiceList().get(i).getEid(),
                            coldResponse.getServiceList().get(i).getEquip_name(),
                            coldResponse.getServiceList().get(i).getEquip_sl_no(),
                            coldResponse.getServiceList().get(i).getContract_type(),
                            coldResponse.getServiceList().get(i).getSr_type(),
                            coldResponse.getServiceList().get(i).getEng_name(),
                            coldResponse.getServiceList().get(i).getStatus(),
                            coldResponse.getServiceList().get(i).getProblem(),
                            coldResponse.getServiceList().get(i).getCreated_dt(),
                            coldResponse.getServiceList().get(i).getGroupID()
                    );
                    coldmodel.save();
                    coldCallList.add(coldmodel);
                }

                setAdapter(coldCallList);
                break;
        }
    }

    private void setAdapter(List<Coldmodel> coldCallList) {

        if (coldcallAdapter == null) {
            coldcallAdapter = new ColdcallAdapter(ColdCallActivity.this, coldCallList);
            recycle_coldcall.setAdapter(coldcallAdapter);
        } else {
            coldcallAdapter.refresh(coldCallList);
        }

    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    private void doGetLatestData(int postion) {

        List<Coldmodel> abcList = new Select()
                .all()
                .from(Coldmodel.class)
                .execute();

        setAdapter(abcList);

        Log.d(TAG, "doGetLatestData: Saved new Data");
    }

    @Override
    public void showErrorDialog(String paramString, int anInt, int paramInt) {

    }


    @Override
    public void onClick(List<Coldmodel> myList, int i, String Id) {

        ArrayList<String> crapList = new ArrayList<>();

        crapList.add(myList.get(i).getRequest_id().toString());
        crapList.add(myList.get(i).getCustomer_name().toString());
        crapList.add(myList.get(i).getContact_no().toString());
        crapList.add(myList.get(i).getEid().toString());
        crapList.add(myList.get(i).getEquip_name().toString());
        crapList.add(myList.get(i).getEquip_sl_no().toString());
        crapList.add(myList.get(i).getContract_type().toString());
        crapList.add(myList.get(i).getSr_type().toString());
        crapList.add(myList.get(i).getEng_name().toString());
        crapList.add(myList.get(i).getStatus().toString());
        crapList.add(myList.get(i).getProblem().toString());
        crapList.add(String.valueOf(Id));


        Intent intent = new Intent(ColdCallActivity.this, ColdCallsviewActivity.class);
        intent.putStringArrayListExtra("data", crapList);
        startActivityForResult(intent, 1);
    }


    public void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK) {
                if (data.getBooleanExtra("isAdded", false)) {
                    doGetLatestData(data.getIntExtra("postion", 0));
                }
            }
        }
    }

}
