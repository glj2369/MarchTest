package com.example.admin.marchtest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.marchtest.ExpandList;
import com.example.admin.marchtest.R;

import java.util.List;
import java.util.Map;

public class expandablelistviewAdapter extends BaseExpandableListAdapter {
    private Map<String, List<ExpandList>> map;
    private String[] par;
    private Context context;

    public expandablelistviewAdapter(Map<String, List<ExpandList>> map, String[] par, Context context) {
        this.map = map;
        this.par = par;
        this.context = context;
    }

    @Override
    public int getGroupCount() {
        return map.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return map.get(par[groupPosition]).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return map.get(par[groupPosition]);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return map.get(par[groupPosition]).get(childPosition);
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
        return true;//改为true
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.exp_par_layout, null);
        TextView partv = view.findViewById(R.id.par_exp_list);
        partv.setText(par[groupPosition]);
        return view;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        ExpandList child = (ExpandList) getChild(groupPosition, childPosition);
        View view = LayoutInflater.from(context).inflate(R.layout.exp_item_layout, null);
        ImageView itemPic = view.findViewById(R.id.item_im_exp_list);
        TextView itemTv1 = view.findViewById(R.id.item_tv1_exp_list);
        TextView itemTv2 = view.findViewById(R.id.item_tv2_exp_list);
        itemPic.setImageResource(child.getPic());
        itemTv1.setText(child.getTv1());
        itemTv2.setText(child.getTv2());
        return view;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return false;
    }
}
