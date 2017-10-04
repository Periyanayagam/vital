package com.example.saravanakumar8.vitalmed.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.SpinnerAdapter;
import android.widget.TextView;

import com.example.saravanakumar8.vitalmed.R;

import java.util.List;


public class CustomSpinnerAdapter extends BaseAdapter implements SpinnerAdapter {

    Context context;

    List<String> status;


    public CustomSpinnerAdapter(Context context, List<String> status) {

        this.context = context;
        this.status = status;

    }


    public int getCount() {
        return status.size();
    }

    public Object getItem(int i) {
        return status.get(i);
    }

    public long getItemId(int i) {
        return (long) i;
    }


    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView txt = new TextView(context);
        txt.setPadding(0, 0, 16, 16);
        txt.setTextSize(18);
        txt.setGravity(Gravity.START);
        txt.setText(status.get(position));
        txt.setTextColor(Color.parseColor("#005a5b"));
        return txt;
    }

    public View getView(int i, View view, ViewGroup viewgroup) {
        TextView txt = new TextView(context);
        txt.setGravity(Gravity.CENTER);
        txt.setPadding(16, 16, 16, 16);
        txt.setTextSize(16);
        txt.setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.ic_arrow_drop_down_black_24dp, 0);
        txt.setText(status.get(i));
        txt.setTextColor(Color.parseColor("#005a5b"));
        return txt;
    }


}
