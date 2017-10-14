package com.example.saravanakumar8.vitalmed.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.example.saravanakumar8.vitalmed.R;

public class SalesDashboardActivity extends AppCompatActivity {

    LinearLayout linear_coldcall,linear_followupcall,linear_projectedcall;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sales_dashboard);


        linear_coldcall =(LinearLayout)findViewById(R.id.linear_coldcall);
        linear_followupcall =(LinearLayout)findViewById(R.id.linear_followupcall);
        linear_projectedcall =(LinearLayout)findViewById(R.id.linear_projectedcall);

        //onClikclistener

        linear_coldcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent coldcall = new Intent(SalesDashboardActivity.this,ColdCallsviewActivity.class);
                coldcall.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(coldcall);
            }
        });



        linear_followupcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent followcall = new Intent(SalesDashboardActivity.this,FollowupCallActivity.class);
                followcall.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(followcall);
            }
        });
        linear_projectedcall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent projectedcall = new Intent(SalesDashboardActivity.this,ProjectedCallActivity.class);
                projectedcall.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(projectedcall);
            }
        });

    }

    public void logoutClicked(View v){
        startActivity(new Intent(SalesDashboardActivity.this, LoginActivity.class));
        finish();
    }
}
