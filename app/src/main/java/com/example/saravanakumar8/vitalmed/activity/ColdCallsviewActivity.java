package com.example.saravanakumar8.vitalmed.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import com.example.saravanakumar8.vitalmed.R;
import com.example.saravanakumar8.vitalmed.activeandroid.Coldmodel;
import com.example.saravanakumar8.vitalmed.adapter.CustomSpinnerAdapter;

import java.util.ArrayList;
import java.util.List;

public class ColdCallsviewActivity extends AppCompatActivity {

    Spinner select_status;
    LinearLayout linear_back, linear_submit;
    EditText edt_name, edt_serialno, edt_eqpname, edt_eidnum, edt_contract, edt_problem;


    //String[] status = {"Select Status","Completed","Not finished","Failed"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coldcallsview);

        select_status = (Spinner) findViewById(R.id.select_status);

        linear_back = (LinearLayout) findViewById(R.id.linear_back);
        linear_submit = (LinearLayout) findViewById(R.id.linear_submit);

        edt_name = (EditText) findViewById(R.id.edt_name);
        edt_serialno = (EditText) findViewById(R.id.edt_serialno);
        edt_eqpname = (EditText) findViewById(R.id.edt_eqpname);
        edt_eidnum = (EditText) findViewById(R.id.edt_eidnum);
        edt_contract = (EditText) findViewById(R.id.edt_contract);
        edt_problem = (EditText) findViewById(R.id.edt_problem);

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

                ArrayList<Coldmodel> android_version = new ArrayList<>();

                Coldmodel coldmodel = new Coldmodel(edt_name.getText().toString().trim(),
                        edt_serialno.getText().toString().trim(),
                        edt_eqpname.getText().toString().trim(),
                        edt_eidnum.getText().toString().trim(),
                        edt_contract.getText().toString().trim()
                );
                coldmodel.save();
                android_version.add(coldmodel);

                Intent submit = new Intent(ColdCallsviewActivity.this, ColdCallActivity.class);
                submit.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(submit);
            }
        });

        linear_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent();
                intent.putExtra("isAdded", true);
                setResult(RESULT_OK, intent);
                finish();
                startActivity(intent);
            }
        });


    }


}
