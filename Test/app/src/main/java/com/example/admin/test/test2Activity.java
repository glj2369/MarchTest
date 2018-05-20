package com.example.admin.test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.admin.test.Adapter.Test2Adapter;
import com.example.admin.test.Bean.test2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class test2Activity extends AppCompatActivity implements View.OnClickListener {

    private ExpandableListView mTest2Exp;
    private Map<String, List<test2>> map = new HashMap<>();
    private List<test2> list1 = new ArrayList<>();
    private List<test2> list2 = new ArrayList<>();
    private String[] s = {"中医院站", "联想大厦站"};
    /**
     * 901路公交车 首：6：00 末：21:00 当前承载能力：1211人
     */
    private TextView mTextView2;
    /**
     * 详情
     */
    private Button mTest2Xq;
    private Test2Adapter test2Adapter;
    private Timer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test2);
        initView();
        Ran();
        test2Adapter = new Test2Adapter(map, s, this);
        mTest2Exp.setAdapter(test2Adapter);
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        list1.clear();
                        list2.clear();
                        map.clear();
                        Ran();
                        test2Adapter.notifyDataSetChanged();
                    }
                });

            }
        };
        timer.schedule(timerTask, 3000, 3000);

    }

    private void Ran() {
        list1.add(new test2(R.drawable.ic_action_bus, "1号(101人)", new Random().nextInt(10) + "分钟到达", "距离站台" + new Random().nextInt(500) + "米"));
        list1.add(new test2(R.drawable.ic_action_bus, "2号(101人)", new Random().nextInt(10) + "分钟到达", "距离站台" + new Random().nextInt(500) + "米"));
        map.put(s[0], list1);
        list2.add(new test2(R.drawable.ic_action_bus, "1号(101人)", new Random().nextInt(10) + "分钟到达", "距离站台" + new Random().nextInt(500) + "米"));
        list2.add(new test2(R.drawable.ic_action_bus, "2号(101人)", new Random().nextInt(10) + "分钟到达", "距离站台" + new Random().nextInt(500) + "米"));
        map.put(s[1], list2);
    }

    private void initView() {
        mTest2Exp = (ExpandableListView) findViewById(R.id.test2_exp);
        mTextView2 = (TextView) findViewById(R.id.textView2);
        mTest2Xq = (Button) findViewById(R.id.test2_xq);
        mTest2Xq.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.test2_xq:
                new test2_detailActivity(this).show();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
