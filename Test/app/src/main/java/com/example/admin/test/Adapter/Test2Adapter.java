package com.example.admin.test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.test.Bean.test2;
import com.example.admin.test.R;

import java.util.List;
import java.util.Map;

public class Test2Adapter extends BaseExpandableListAdapter {
    private Map<String, List<test2>> map;
    private String s[];
    private Context context;

    public Test2Adapter(Map<String, List<test2>> map, String[] s, Context context) {
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
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.test2_p, null);
        TextView t = view.findViewById(R.id.test2_p_tv);
        t.setText(s[groupPosition]);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        test2 child = (test2) getChild(groupPosition, childPosition);
        View view = LayoutInflater.from(context).inflate(R.layout.test2_item, null);
        ImageView imageView = view.findViewById(R.id.test2_item_pic);
        TextView t1 = view.findViewById(R.id.test2_item_t1);
        TextView t2 = view.findViewById(R.id.test2_item_t2);
        TextView t3 = view.findViewById(R.id.test2_item_t3);
        imageView.setImageResource(child.getPic());
        t1.setText(child.getT1());
        t2.setText(child.getT2());
        t3.setText(child.getT3());
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
