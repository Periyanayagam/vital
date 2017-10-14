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
import com.example.saravanakumar8.vitalmed.model.Datamodel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by saravanakumar8 on 9/9/2017.
 */

public class FollowupCallAdapter extends RecyclerView.Adapter<FollowupCallAdapter.ViewHolder> {

    Context context;
    List<Coldmodel> coldcall;

    public FollowupCallAdapter(Context context, List<Coldmodel> coldcall) {
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

        Log.d("Adapter", "onBindViewHolder: "+ coldcall.get(0).getStatus());

        holder.txtName.setText(coldcall.get(position).getCustomer_name());
        holder.txtEngName.setText(coldcall.get(position).getEng_name());
        holder.txtMobile.setText(coldcall.get(position).getContact_no());
        holder.txtProblem.setText(coldcall.get(position).getProblem());
        holder.txtDate.setText(coldcall.get(position).getCreated_dt());
        holder.txtStatus.setText(coldcall.get(position).getStatus());
      //  holder.img_success.setImageResource(coldcall.get(position).getImages());
    }



    @Override
    public int getItemCount() {
        return coldcall.size();
    }

    public void refresh(List<Coldmodel> followList) {

    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView txtName, txtEngName, txtMobile, txtProblem, txtDate, txtStatus;
        LinearLayout linear_coldcalldetail, rootLay;

        ImageView img_success;

        public ViewHolder(View itemView) {
            super(itemView);


            txtName = (TextView) itemView.findViewById(R.id.txtName);
            txtEngName = (TextView) itemView.findViewById(R.id.txtEngName);
            txtMobile = (TextView) itemView.findViewById(R.id.txtMobile);
            txtProblem = (TextView) itemView.findViewById(R.id.txtProblem);
            txtDate = (TextView) itemView.findViewById(R.id.txtDate);
            txtStatus = (TextView) itemView.findViewById(R.id.txtStatus);
            img_success = (ImageView) itemView.findViewById(R.id.img_success);
            img_success = (ImageView) itemView.findViewById(R.id.img_success);

            linear_coldcalldetail = (LinearLayout) itemView.findViewById(R.id.linear_coldcalldetail);


            linear_coldcalldetail.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                  /*  Intent coldcallview = new Intent(context,ColdCallsviewActivity.class);
                    context.startActivity(coldcallview);*/
                }
            });


        }


    }
}
