package com.example.mpchart215test.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;

import com.example.mpchart215test.Adapter.ExPandableListAdapter;
import com.example.mpchart215test.Class.ExpandanleList_Class;
import com.example.mpchart215test.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExpandableViewFragment extends Fragment {
    private String[] s = {"一号", "二号"};
    private Map<String, List<ExpandanleList_Class>> map = new HashMap<>();
    private List<ExpandanleList_Class> list = new ArrayList<>();
    private List<ExpandanleList_Class> list1 = new ArrayList<>();
    private View view;
    private ExpandableListView mExpand;

    public ExpandableViewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_expandable_view, container, false);
        initView(view);

        list.add(new ExpandanleList_Class(R.drawable.logo1, "盖", "聂"));
        list.add(new ExpandanleList_Class(R.drawable.logo2, "卫", "庄"));
        map.put(s[0], list);
        //list.clear();
//        list.clear();
//        StringBuilder s1=new StringBuilder();
//        for (ExpandanleList_Class c:list){
//
//            s1.append( "子项目："+c.getT1()+"-"+c.getT2()+"");
//        }
//        Log.e("Expand",s.toString());
        list = null;
        list = new ArrayList<>();
        list.add(new ExpandanleList_Class(R.drawable.logo2, "天", "明"));
        list.add(new ExpandanleList_Class(R.drawable.logo1, "荆", "轲"));
        list.add(new ExpandanleList_Class(R.drawable.logo2, "月", "儿"));
        map.put(s[1], list);
        ExpandableListAdapter ad = new ExPandableListAdapter(map, s, getContext());
        mExpand.setAdapter(ad);
        return view;
    }

    private void initView(View view) {
        mExpand = (ExpandableListView) view.findViewById(R.id.expand);
    }
}
