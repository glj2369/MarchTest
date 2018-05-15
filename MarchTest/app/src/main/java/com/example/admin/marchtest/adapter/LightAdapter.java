package com.example.admin.marchtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.admin.marchtest.R;
import com.example.admin.marchtest.RoadLight;

import java.util.List;

public class LightAdapter extends ArrayAdapter<RoadLight> {
private int resid;
    public LightAdapter(@NonNull Context context, int resource, @NonNull List<RoadLight> objects) {
        super(context, resource, objects);
        this.resid=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        RoadLight roadLight = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(resid, parent, false);
        TextView roadTv=view.findViewById(R.id.road);
        TextView redTv=view.findViewById(R.id.red);
        TextView yellowTv=view.findViewById(R.id.yellow);
        TextView greenTv=view.findViewById(R.id.green);
        roadTv.setText(roadLight.getRoad());
        redTv.setText(roadLight.getRed());
        yellowTv.setText(roadLight.getYellow());
        greenTv.setText(roadLight.getGreen());


        return view;
    }
}
