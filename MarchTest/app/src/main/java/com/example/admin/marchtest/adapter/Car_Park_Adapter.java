package com.example.admin.marchtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.admin.marchtest.CarPark;
import com.example.admin.marchtest.R;

import java.util.List;

public class Car_Park_Adapter extends ArrayAdapter<CarPark> {
    private int res;
    private Context context;
    public Car_Park_Adapter(@NonNull Context context, int resource, @NonNull List<CarPark> objects) {
        super(context, resource, objects);
        this.res=resource;
        this.context=context;
    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        CarPark carPark = getItem(position);
        View view = LayoutInflater.from(context).inflate(res, parent, false);
        TextView icid=view.findViewById(R.id.carParkicid);
        TextView carid=view.findViewById(R.id.carParkid);
        TextView person=view.findViewById(R.id.carParkPerson);
        TextView intime=view.findViewById(R.id.carParkin);
        TextView outtime=view.findViewById(R.id.carParkout);
        TextView money=view.findViewById(R.id.carParkMoney);
        icid.setText(carPark.getIcid());
        carid.setText(carPark.getCarid());
        person.setText(carPark.getPerson());
        intime.setText(carPark.getIntime());
        outtime.setText(carPark.getOuttime());
        money.setText(carPark.getMonry());
        return view;
    }
}
