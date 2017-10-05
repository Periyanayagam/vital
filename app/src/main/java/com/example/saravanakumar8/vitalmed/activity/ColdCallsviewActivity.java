package com.example.saravanakumar8.vitalmed.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.activeandroid.query.Update;
import com.example.saravanakumar8.vitalmed.R;
import com.example.saravanakumar8.vitalmed.activeandroid.Coldmodel;
import com.example.saravanakumar8.vitalmed.adapter.CustomSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ColdCallsviewActivity extends AppCompatActivity {

    String TAG = ColdCallsviewActivity.class.getSimpleName();
    Spinner select_status;
    LinearLayout linear_back, linear_submit;
    EditText edt_name, edt_serialno, edt_eqpname, edt_eidnum, edt_contract, edt_problem;
    ArrayList<String> crapList;

    //String[] status = {"Select Status","Completed","Not finished","Failed"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coldcallsview);
//someData
        if (getIntent().getExtras() != null) {
            crapList = getIntent().getStringArrayListExtra("data");
        }

        select_status = (Spinner) findViewById(R.id.select_status);

        linear_back = (LinearLayout) findViewById(R.id.linear_back);
        linear_submit = (LinearLayout) findViewById(R.id.linear_submit);

        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_serialno = (EditText) findViewById(R.id.edt_serialno);
        edt_eqpname = (EditText) findViewById(R.id.edt_eqpname);
        edt_eidnum = (EditText) findViewById(R.id.edt_eidnum);
        edt_contract = (EditText) findViewById(R.id.edt_contract);
        edt_problem = (EditText) findViewById(R.id.edt_problem);

        if (crapList != null) {
            Log.d(TAG, "onCreate: " + crapList.get(5).toString());
            edt_name.setText(crapList.get(0).toString());
            edt_serialno.setText(crapList.get(1).toString());
            edt_eqpname.setText(crapList.get(2).toString());
            edt_eidnum.setText(crapList.get(3).toString());
            edt_contract.setText(crapList.get(4).toString());
        }

//        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
//                android.R.layout.simple_spinner_item, status);
//
//        select_status.setAdapter(adapter);

        //Spinner init

        List<String> status = new ArrayList<String>();
        status.add("Select Status");
        status.add("Completed");
        status.add("Not finished");
        status.add("Failed");

        CustomSpinnerAdapter customSpinnerAdapter = new CustomSpinnerAdapter(ColdCallsviewActivity.this, status);
        select_status.setAdapter(customSpinnerAdapter);

        //Inti

        linear_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Log.d("ColdCallActivity", "onClick: " + crapList.get(5));

                String updateSet = " hospitalname = ? ," +
                        " doctorname = ? ," +
                        "mobilename = ? ," +
                        "date = ? ," +
                        "status = ? ";

                new Update(Coldmodel.class)
                        .set(updateSet, edt_name.getText().toString().trim(),
                                edt_serialno.getText().toString().trim(),
                                edt_eqpname.getText().toString().trim(),
                                edt_eidnum.getText().toString().trim(),
                                edt_contract.getText().toString().trim()
                        )
                        .where("id = ? ", Long.parseLong(crapList.get(5)))
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


    }

    private void doClose() {

        Intent returnIntent = new Intent();
        returnIntent.putExtra("isAdded", true);
        setResult(Activity.RESULT_OK, returnIntent);
        finish();

    }


}
