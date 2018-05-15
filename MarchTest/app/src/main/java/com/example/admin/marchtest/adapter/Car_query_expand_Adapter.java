package com.example.admin.marchtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.marchtest.Car_query_expand;
import com.example.admin.marchtest.ExpandList;
import com.example.admin.marchtest.R;

import java.util.List;
import java.util.Map;

public class Car_query_expand_Adapter extends BaseExpandableListAdapter {
    private Map<String, List<Car_query_expand>> map;
    private String [] s;
    private Context context;

    public Car_query_expand_Adapter(Map<String, List<Car_query_expand>> map, String[] s, Context context) {
        this.map = map;
        this.s = s;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return map.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return map.get(s[groupPosition]).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return map.get(s[groupPosition]);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return map.get(s[groupPosition]).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.car_query_par_layout, null);
        TextView tv = view.findViewById(R.id.par_car_query_list);
        tv.setText(s[groupPosition]);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        Car_query_expand child = (Car_query_expand) getChild(groupPosition, childPosition);
        View view = LayoutInflater.from(context).inflate(R.layout.car_query_child_layout, null);
        ImageView imageView=view.findViewById(R.id.item_im_car_query_list);
        TextView tv1=view.findViewById(R.id.item_tv1_car_query_list);
        TextView tv2=view.findViewById(R.id.item_tv2_car_query_list);
        TextView tv3=view.findViewById(R.id.item_tv3_car_query_list);
        imageView.setImageResource(child.getPic());
        tv1.setText(child.getTv1());
        tv2.setText(child.getTv2());
        tv3.setText(child.getTv3());
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
