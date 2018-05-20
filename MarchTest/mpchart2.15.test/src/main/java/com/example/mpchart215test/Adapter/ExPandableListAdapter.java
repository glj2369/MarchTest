package com.example.mpchart215test.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mpchart215test.Class.ExpandanleList_Class;
import com.example.mpchart215test.R;

import java.util.List;
import java.util.Map;

public class ExPandableListAdapter extends BaseExpandableListAdapter {
    private Map<String, List<ExpandanleList_Class>> list;
    private String[] s;
    private Context context;

    public ExPandableListAdapter(Map<String, List<ExpandanleList_Class>> list, String[] s, Context context) {
        this.list = list;
        this.s = s;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return list.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return list.get(s[groupPosition]).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return list.get(s[groupPosition]);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return list.get(s[groupPosition]).get(childPosition);
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
        View view = LayoutInflater.from(context).inflate(R.layout.expandlist_parent, null);
        TextView textView = view.findViewById(R.id.ex_par_tv);
        textView.setText(s[groupPosition]);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ExpandanleList_Class child = (ExpandanleList_Class) getChild(groupPosition, childPosition);
        View view = LayoutInflater.from(context).inflate(R.layout.expandlist_item, null);
        TextView textView = view.findViewById(R.id.ex_it_1);
        TextView textView1 = view.findViewById(R.id.ex_it_2);
        ImageView imageView = view.findViewById(R.id.ex_pic);
        textView.setText(child.getT1());
        textView1.setText(child.getT2());
        imageView.setImageResource(child.getPic());
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
