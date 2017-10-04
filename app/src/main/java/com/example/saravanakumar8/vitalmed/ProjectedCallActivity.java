package com.example.saravanakumar8.vitalmed;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.saravanakumar8.vitalmed.Model.Datamodel;

import java.util.ArrayList;

public class ProjectedCallActivity extends AppCompatActivity {

    RecyclerView recycle_projectedcall;

    ProjectedCallAdapter projectedCallAdapter;

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
        setContentView(R.layout.activity_projected_call);

        recycle_projectedcall = (RecyclerView) findViewById(R.id.recycle_projectedcall);
        recycle_projectedcall.setHasFixedSize(true);

        //Recyclerview Init
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycle_projectedcall.setLayoutManager(layoutManager);


        ArrayList<Datamodel> coldcall = prepareData();


        projectedCallAdapter = new ProjectedCallAdapter(ProjectedCallActivity.this, coldcall);
        recycle_projectedcall.setAdapter(projectedCallAdapter);

    }

    private ArrayList<Datamodel> prepareData() {
        ArrayList<Datamodel> android_version = new ArrayList<>();
        for (int i = 0; i < hospitalname.length; i++) {
            Datamodel datamodel = new Datamodel();
            datamodel.setHospitalname(hospitalname[i]);
            datamodel.setDoctorname(doctoname[i]);
            datamodel.setMobilename(mobilename[i]);
            datamodel.setAttendername(attendername[i]);
            datamodel.setDate(date[i]);
            datamodel.setStatus(status[i]);
            datamodel.setImages(images[i]);
            android_version.add(datamodel);
        }
        return android_version;

    }
}
