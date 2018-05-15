package com.example.admin.marchtest.march;


import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import com.example.admin.marchtest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class VideFragment extends Fragment {

    private List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
    private View view;
    private GridView mGrid;

    public VideFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_vide, container, false);
        initView(view);

            String[] s = {"武庚记-20", "斗罗大陆", "秦时明月", "天行九歌", "空山鸟语"};
            int[] drawables = {R.drawable.wgj,R.drawable.dldl,R.drawable.qsmy,R.drawable.txjg,R.drawable.ksny};
            for (int i=0;i<s.length;i++){
                Map<String,Object> map= new HashMap<String,Object>();
                map.put("name",s[i]);
                map.put("icon",drawables[i]);
                list.add(map);
            }
            SimpleAdapter simpleAdapter=new SimpleAdapter(
                    getActivity(),
                    list,
                    R.layout.gridview_itemlayout,new String[]{"name","icon"},
                    new int[]{R.id.video_Tv,R.id.video_image});
            mGrid.setAdapter(simpleAdapter);
            mGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent=new Intent(getActivity(),VideoActivity.class);
                    startActivity(intent);

                }
            });



        return view;
    }

    private void initView(View view) {
        mGrid = (GridView) view.findViewById(R.id.grid);
    }

    @Override
    public void onPause() {
        super.onPause();
        list.clear();
    }
}
