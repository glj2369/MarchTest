package com.example.admin.marchtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.marchtest.R;
import com.example.admin.marchtest.Recharge;

import java.util.List;

public class RechargeAdapter extends ArrayAdapter <Recharge>{
    private int res;
    public RechargeAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);
        this.res=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Recharge recharge = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(res, parent, false);
        TextView mid=view.findViewById(R.id.id);
        TextView mcarid=view.findViewById(R.id.carid);
        TextView mmoney=view.findViewById(R.id.money);
        TextView mper=view.findViewById(R.id.person);
        TextView mdate=view.findViewById(R.id.date);
        mid.setText(recharge.getId());
        mcarid.setText(recharge.getCarid());
        mmoney.setText(recharge.getMoney());
        mper.setText(recharge.getPerson());
        mdate.setText(recharge.getDate());
        return view;
    }
}
