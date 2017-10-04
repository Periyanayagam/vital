package com.example.saravanakumar8.vitalmed;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.saravanakumar8.vitalmed.Helper.Pref;

public class DashboardActivity extends BaseActivity {

    LinearLayout linear_sales, linear_service;
    ImageView img_logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);


        linear_sales = (LinearLayout) findViewById(R.id.linear_sales);
        linear_service = (LinearLayout) findViewById(R.id.linear_service);
        img_logout = (ImageView) findViewById(R.id.img_logout);

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
