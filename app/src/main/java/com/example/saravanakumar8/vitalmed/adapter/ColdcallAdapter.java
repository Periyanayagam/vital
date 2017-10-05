package com.example.saravanakumar8.vitalmed.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.saravanakumar8.vitalmed.R;
import com.example.saravanakumar8.vitalmed.activeandroid.Coldmodel;
import com.example.saravanakumar8.vitalmed.activity.ColdCallActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saravanakumar8 on 9/9/2017.
 */

public class ColdcallAdapter extends RecyclerView.Adapter<ColdcallAdapter.ViewHolder> {

    Context context;
    List<Coldmodel> coldcall;

    public ColdcallAdapter(Context context, List<Coldmodel> coldcall) {
        this.context = context;
        this.coldcall = coldcall;

    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.coldcall_list, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        Log.d("Adapter", "onBindViewHolder: " + coldcall.get(0).getStatus());

        holder.txt_hospitaname.setText(coldcall.get(position).getHospitalname());
        holder.txt_doctorname.setText(coldcall.get(position).getDoctorname());
        holder.txt_mobilename.setText(coldcall.get(position).getMobilename());
        holder.txt_date.setText(coldcall.get(position).getDate());
        holder.txt_status.setText(coldcall.get(position).getStatus());

        //  holder.img_success.setImageResource(coldcall.get(position).getImages());
    }




    @Override
    public int getItemCount() {
        return coldcall.size();
    }


    public void refresh(int postion) {
        this.notifyItemChanged(postion);
    }

    public void refresh(List<Coldmodel> coldCallList) {
        this.coldcall = coldCallList;
        this.notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txt_hospitaname, txt_doctorname, txt_mobilename, txt_attendername, txt_date, txt_status;
        LinearLayout linear_coldcalldetail, rootLay;

        ImageView img_success;

        public ViewHolder(View itemView) {
            super(itemView);

            txt_hospitaname = (TextView) itemView.findViewById(R.id.txt_hospitaname);
            txt_doctorname = (TextView) itemView.findViewById(R.id.txt_doctorname);
            txt_mobilename = (TextView) itemView.findViewById(R.id.txt_mobilename);
            txt_attendername = (TextView) itemView.findViewById(R.id.txt_attendername);
            txt_date = (TextView) itemView.findViewById(R.id.txt_date);
            txt_status = (TextView) itemView.findViewById(R.id.txt_status);
            img_success = (ImageView) itemView.findViewById(R.id.img_success);

            linear_coldcalldetail = (LinearLayout) itemView.findViewById(R.id.linear_coldcalldetail);
            rootLay = (LinearLayout) itemView.findViewById(R.id.rootLay);

            rootLay.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            //coldcall.get()

                            Log.d("OnClick", "onClick: " + getAdapterPosition());
                            coldcall.get(getAdapterPosition()).setHospitalname(txt_hospitaname.getText().toString().trim());
                            coldcall.get(getAdapterPosition()).setDoctorname(txt_doctorname.getText().toString().trim());
                            coldcall.get(getAdapterPosition()).setMobilename(txt_mobilename.getText().toString().trim());
                            coldcall.get(getAdapterPosition()).setStatus(txt_status.getText().toString().trim());
                            coldcall.get(getAdapterPosition()).setDate(txt_date.getText().toString().trim());

                            ((ColdCallActivity) context).onClick(coldcall, getAdapterPosition(), String.valueOf(coldcall.get(getAdapterPosition()).getId()));
                        }
                    }
            );


        }


    }
}
