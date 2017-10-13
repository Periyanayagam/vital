package com.example.saravanakumar8.vitalmed.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saravanakumar8.vitalmed.R;
import com.example.saravanakumar8.vitalmed.activity.ColdCallsviewActivity;
import com.example.saravanakumar8.vitalmed.model.Datamodel;

import java.util.ArrayList;


/**
 * Created by saravanakumar8 on 9/11/2017.
 */

public class ServicecallAdapter extends RecyclerView.Adapter<ServicecallAdapter.ViewHolder> {

    private static final String TAG = ServicecallAdapter.class.getSimpleName();
    Context context;
    ArrayList<Datamodel> coldcall;

    public ServicecallAdapter(Context context, ArrayList<Datamodel> coldcall) {
        this.context = context;
        this.coldcall = coldcall;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.servicecall_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d(TAG, "onBindViewHolder: " + coldcall.size());

        holder.txt_hospitaname.setText(coldcall.get(position).getHospitalname());
        holder.txt_doctorname.setText(coldcall.get(position).getDoctorname());
        holder.txt_mobilename.setText(coldcall.get(position).getMobilename());
        holder.txt_attendername.setText(coldcall.get(position).getAttendername());
        holder.txt_date.setText(coldcall.get(position).getDate());
        holder.txt_status.setText(coldcall.get(position).getStatus());

        if (coldcall.get(position).getStatus().equals("NEW")) {
            holder.img_success.setImageResource(R.drawable.success_icon);
        } else if (coldcall.get(position).getStatus().equals("CLOSE")) {
            holder.img_success.setImageResource(R.drawable.ic_close_black_24dp);
        }
    }


    @Override
    public int getItemCount() {
        return coldcall.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_hospitaname, txt_doctorname, txt_mobilename, txt_attendername, txt_date, txt_status;
        LinearLayout linear_coldcalldetail;


        ImageView img_success;

        public ViewHolder(View itemView) {
            super(itemView);


            txt_hospitaname = (TextView) itemView.findViewById(R.id.txtName);
            txt_doctorname = (TextView) itemView.findViewById(R.id.txtType);
            txt_mobilename = (TextView) itemView.findViewById(R.id.txtProblem);
            txt_attendername = (TextView) itemView.findViewById(R.id.txtEngName);
            txt_date = (TextView) itemView.findViewById(R.id.txtDate);
            txt_status = (TextView) itemView.findViewById(R.id.txtStatus);
            img_success = (ImageView) itemView.findViewById(R.id.img_success);

            linear_coldcalldetail = (LinearLayout) itemView.findViewById(R.id.linear_coldcalldetail);


            linear_coldcalldetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Intent coldcallview = new Intent(context, ColdCallsviewActivity.class);
                    context.startActivity(coldcallview);
                }
            });


        }


    }
}
