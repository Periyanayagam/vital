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

import com.example.saravanakumar8.vitalmed.activeandroid.Coldmodel;
import com.example.saravanakumar8.vitalmed.activity.ColdCallActivity;
import com.example.saravanakumar8.vitalmed.activity.ColdCallsviewActivity;
import com.example.saravanakumar8.vitalmed.R;
import com.example.saravanakumar8.vitalmed.listener.MyRecyclerListener;

import java.util.ArrayList;

/**
 * Created by saravanakumar8 on 9/9/2017.
 */

public class ColdcallAdapter extends RecyclerView.Adapter<ColdcallAdapter.ViewHolder> {

    private static final String TAG = ColdcallAdapter.class.getSimpleName();
    Context context;
    ArrayList<Coldmodel> coldcall;
    MyRecyclerListener myRecyclerListener;
    public ColdcallAdapter(Context context, ArrayList<Coldmodel> coldcall) {
        this.context = context;
        this.coldcall = coldcall;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.coldcall_list, parent, false);
        myRecyclerListener = new ColdCallActivity();
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {


        holder.txt_hospitaname.setText(coldcall.get(position).getHospitalname());
        holder.txt_doctorname.setText(coldcall.get(position).getDoctorname());
        holder.txt_mobilename.setText(coldcall.get(position).getMobilename());
        holder.txt_date.setText(coldcall.get(position).getDate());
        holder.txt_status.setText(coldcall.get(position).getStatus());
        Log.d(TAG, "onBindViewHolder: status"+ coldcall.get(position).getStatus());
       // holder.img_success.setImageResource(coldcall.get(position).getImages());

      //  Picasso.with(context).load(coldcall.get(position).getImages()).resize(240, 120).into(holder.img_success);

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


            txt_hospitaname = (TextView) itemView.findViewById(R.id.txt_hospitaname);
            txt_doctorname = (TextView) itemView.findViewById(R.id.txt_doctorname);
            txt_mobilename = (TextView) itemView.findViewById(R.id.txt_mobilename);
            txt_date = (TextView) itemView.findViewById(R.id.txt_date);
            txt_status = (TextView) itemView.findViewById(R.id.txt_status);

            Log.d(TAG, "ViewHolder: status"+ txt_status);

            linear_coldcalldetail = (LinearLayout) itemView.findViewById(R.id.linear_coldcalldetail);


            linear_coldcalldetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    myRecyclerListener.onClick();

                }
            });


        }


    }
}
