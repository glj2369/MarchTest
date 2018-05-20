package com.example.mpchart215test.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.mpchart215test.Class.List_class;
import com.example.mpchart215test.R;

import java.util.List;

public class ListViewAdapter extends ArrayAdapter<List_class> {
    private final Context contex;
    private int res;

    public ListViewAdapter(@NonNull Context context, int resource, @NonNull List<List_class> objects) {
        super(context, resource, objects);
        this.res = resource;
        this.contex = context;
    }


    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        List_class item = getItem(position);
        View view = LayoutInflater.from(contex).inflate(res, parent, false);
        TextView t1 = view.findViewById(R.id.list_t1);
        TextView t2 = view.findViewById(R.id.list_t2);
        if (item != null) {
            t1.setText(item.getT1() + "");
            t2.setText(item.getT2());
        }

        return view;
    }
}
