package com.example.saravanakumar8.vitalmed.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saravanakumar8.vitalmed.helper.Pref;
import com.example.saravanakumar8.vitalmed.R;

public class DashboardActivity extends BaseActivity {

    LinearLayout linear_sales, linear_service;
    ImageView img_logout;
    TextView txtFinalSync;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        txtFinalSync = (TextView) findViewById(R.id.txtFinalSync);

        linear_sales = (LinearLayout) findViewById(R.id.linear_sales);
        linear_service = (LinearLayout) findViewById(R.id.linear_service);
        img_logout = (ImageView) findViewById(R.id.img_logout);

        txtFinalSync.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                }
        );

        img_logout.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Pref.clearlogin();
                        showMessage("Logged out successfully!");
                        startActivity(new Intent(DashboardActivity.this, LoginActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));
                        finish();

                    }
                }
        );

        //Onclick listener

        linear_sales.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent sales = new Intent(DashboardActivity.this, SalesDashboardActivity.class);
                sales.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(sales);
            }
        });

        linear_service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent sales = new Intent(DashboardActivity.this, ServiceCallActivity.class);
                sales.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(sales);
            }
        });

    }
}
