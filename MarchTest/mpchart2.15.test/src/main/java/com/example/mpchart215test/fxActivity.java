package com.example.mpchart215test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class fxActivity extends AppCompatActivity {


    private GridView mFxGrid;
    private String s[] = new String[]{"天行九歌", "天谕", "斗罗大陆", "武庚记", "天行九歌"};
    private int pi[] = new int[]{R.drawable.logo2, R.drawable.logo1, R.drawable.circle2, R.drawable.circle1, R.drawable.logo1};
    private String key[] = new String[]{"1", "2"};
    private int id[] = new int[]{R.id.grid_tv, R.id.grid_pic};
    private List<Map<String, Object>> list = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fx);
        initView();
        for (int i = 0; i < s.length; i++) {
            Map<String, Object> map = new HashMap<>();
            map.put(key[0], s[i]);
            map.put(key[1], pi[i]);
            list.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this, list, R.layout.gridview_item, key, id);
        mFxGrid.setAdapter(simpleAdapter);


    }

    private void initView() {
        mFxGrid = (GridView) findViewById(R.id.fx_grid);
    }
}
