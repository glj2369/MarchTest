package com.example.mpchart215test.Fragment;


import android.os.Bundle;
import android.renderscript.RenderScript;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;
import android.widget.Toast;

import com.example.mpchart215test.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A simple {@link Fragment} subclass.
 */
public class GridViewFragment extends Fragment {


    private View view;
    private GridView mGridView;
    private List<Map<String, Object>> list = new ArrayList<>();
    private String s[] = {"秦时明月", "天行九歌", "武庚记", "天谕", "斗罗大陆"};
    private int pic[] = {R.drawable.circle1, R.drawable.logo1, R.drawable.logo2, R.drawable.circle2, R.drawable.logo1};
    private String key[] = {"1", "2"};
    private int id[] = {R.id.grid_pic, R.id.grid_tv};

    public GridViewFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_grid_view, container, false);
        initView(view);
        for (int i = 0; i < s.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put(key[0], pic[i]);
            map.put(key[1], s[i]);
            list.add(map);
        }

        SimpleAdapter simpleAdapter = new SimpleAdapter(getContext(), list, R.layout.gridview_item, key, id);
        mGridView.setAdapter(simpleAdapter);
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(getActivity(), position, Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    private void initView(View view) {
        mGridView = (GridView) view.findViewById(R.id.gridView);
    }
}
