package com.example.saravanakumar8.vitalmed.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.activeandroid.query.Update;
import com.example.saravanakumar8.vitalmed.R;
import com.example.saravanakumar8.vitalmed.activeandroid.Coldmodel;

import java.util.ArrayList;
import java.util.List;

public class ColdCallsviewActivity extends AppCompatActivity {

    String TAG = ColdCallsviewActivity.class.getSimpleName();

    LinearLayout linear_back, linear_submit;
    ArrayList<String> crapList;
    private EditText mEtReqID;
    private EditText mEtEngName;
    private EditText mEtCustName;
    private EditText mEtMobile;
    private EditText mEtEid;
    private EditText mEtEqName;
    private EditText mEtEqSlNo;
    private EditText mEtContract;
    private EditText mEtSrType;
    private EditText mEtStatus;
    private EditText mEtProblem;
    private CheckBox mChkBox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coldcallsview);

        if (getIntent().getExtras() != null) {
            crapList = getIntent().getStringArrayListExtra("data");
        }

        linear_back = (LinearLayout) findViewById(R.id.linear_back);
        linear_submit = (LinearLayout) findViewById(R.id.linear_submit);

        mEtEngName = (EditText) findViewById(R.id.etEngName);
        mEtReqID = (EditText) findViewById(R.id.etReqId);
        mEtCustName = (EditText) findViewById(R.id.etCustName);
        mEtMobile = (EditText) findViewById(R.id.etMobile);
        mEtEid = (EditText) findViewById(R.id.etEid);
        mEtEqName = (EditText) findViewById(R.id.etequiEid);
        mEtEqSlNo = (EditText) findViewById(R.id.etEquipSno);
        mEtContract = (EditText) findViewById(R.id.etContract);
        mEtSrType = (EditText) findViewById(R.id.etSrType);
        mEtStatus = (EditText) findViewById(R.id.etStatus);
        mEtProblem = (EditText) findViewById(R.id.etProblem);
        mChkBox = (CheckBox) findViewById(R.id.chkBox);

        if (crapList != null) {
            Log.d(TAG, "onCreate: " + crapList.get(11).toString());
            mEtReqID.setText(crapList.get(0).toString());
            mEtCustName.setText(crapList.get(1).toString());
            mEtMobile.setText(crapList.get(2).toString());
            mEtEid.setText(crapList.get(3).toString());
            mEtEqName.setText(crapList.get(4).toString());
            mEtEqSlNo.setText(crapList.get(5).toString());
            mEtContract.setText(crapList.get(6).toString());
            mEtSrType.setText(crapList.get(7).toString());
            mEtEngName.setText(crapList.get(8).toString());
            mEtStatus.setText(crapList.get(9).toString());
            mEtProblem.setText(crapList.get(10).toString());

        }

        List<String> status = new ArrayList<String>();
        status.add("Select Status");
        status.add("Completed");
        status.add("Not finished");
        status.add("Failed");


        linear_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ColdCallActivity", "onClick: " + crapList.get(5));

                String updateSet = " request_id = ? ," +
                        " customer_name = ? ," +
                        "contact_no = ? ," +
                        "eid = ? ," +
                        "equip_name = ? ," +
                        "equip_sl_no = ? ," +
                        "contract_type = ? ," +
                        "sr_type = ? ," +
                        "eng_name = ? ," +
                        "problem = ? ," +
                        "status = ? ";

                Log.d(TAG, "onClick: newId" + crapList.get(11));

                new Update(Coldmodel.class)
                        .set(updateSet, mEtReqID.getText().toString().trim(),
                                mEtCustName.getText().toString().trim(),
                                mEtMobile.getText().toString().trim(),
                                mEtEid.getText().toString().trim(),
                                mEtEqName.getText().toString().trim(),
                                mEtEqSlNo.getText().toString().trim(),
                                mEtContract.getText().toString().trim(),
                                mEtSrType.getText().toString().trim(),
                                mEtEngName.getText().toString().trim(),
                                mEtProblem.getText().toString().trim(),
                                mEtStatus.getText().toString().trim()
                                )
                        .where("id = ? ", Long.parseLong(crapList.get(11)))
                        .execute();

                doClose();
            }
        });

        linear_back.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        doClose();
                    }
                }
        );


        initView();
    }

    private void doClose() {

        Intent returnIntent = new Intent();
        returnIntent.putExtra("isAdded", true);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

    }


    private void initView() {
        mEtEngName = (EditText) findViewById(R.id.etEngName);
        mEtCustName = (EditText) findViewById(R.id.etCustName);
        mEtMobile = (EditText) findViewById(R.id.etMobile);
        mEtEid = (EditText) findViewById(R.id.etEid);
        mEtContract = (EditText) findViewById(R.id.etContract);
        mEtSrType = (EditText) findViewById(R.id.etSrType);
        mEtStatus = (EditText) findViewById(R.id.etStatus);
        mEtProblem = (EditText) findViewById(R.id.etProblem);
        mChkBox = (CheckBox) findViewById(R.id.chkBox);
    }
}
