package com.example.admin.marchtest.march;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.admin.marchtest.Car_query_expand;
import com.example.admin.marchtest.ExpandList;
import com.example.admin.marchtest.HttpUtil.HttpUrl;
import com.example.admin.marchtest.R;
import com.example.admin.marchtest.adapter.Car_query_expand_Adapter;
import com.example.admin.marchtest.adapter.expandablelistviewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


/**
 * A simple {@link Fragment} subclass.
 */
public class Car_query_expandFragment extends Fragment implements View.OnClickListener {


    private View view;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    /**
     * 详情
     */
    private Button mBtDetail;
    private ExpandableListView mCarBusqueryExpand;
    private Car_query_expand_Adapter adapter;
    private String[] strings=new String[]{"中医院站","联想大厦站"};
    private Map<String,List<Car_query_expand>> listMap=new HashMap<>();
    private List<Car_query_expand> list1=new ArrayList<>();
    private List<Car_query_expand> list2=new ArrayList<>();
    private Context context;
    private Timer timer;

    public Car_query_expandFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_car_query_expand, container, false);
        initView(view);
        timer = new Timer();
        TimerTask timerTask= new TimerTask() {
            @Override
            public void run() {
                getDate();
            }
        };
        timer.schedule(timerTask,1000,3000);

        adapter = new Car_query_expand_Adapter(listMap,strings,context);
        mCarBusqueryExpand.setAdapter(adapter);
        return view;
    }

    private void initView(View view) {
        mTitle = (TextView) view.findViewById(R.id.title);
        mBtDetail = (Button) view.findViewById(R.id.bt_detail);
        mBtDetail.setOnClickListener(this);
        mCarBusqueryExpand=view.findViewById(R.id.car_busquery_expand);
        mCarBusqueryExpand = (ExpandableListView) view.findViewById(R.id.car_busquery_expand);
        mTitle.setText("公交查询");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_detail:
                new Detail(context).show();
                break;
        }
    }



    private void getDate() {
        String ip = "192.168.1.106";
        final String address = "http://" + ip + ":8080/transportservice/type/jason/action/";
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //1111


                    JSONObject jsonObject1 = new JSONObject();
                    jsonObject1.put("BusStationId", 1);
                    String result1 = HttpUrl.posthttp(address + "GetBusStationInfo.do",
                            jsonObject1.toString());
                    result1 = new JSONObject(result1).getString("serverinfo");
                    JSONArray jsonArray1 = new JSONArray(result1);
                    list1.clear();
                    for (int i = 0; i < jsonArray1.length(); i++) {
                        JSONObject jsonObject = jsonArray1.getJSONObject(i);
                        int distance = jsonObject.getInt("Distance");
                        int busId = jsonObject.getInt("BusId");
                        //这里给数据
                        //busId + "号公交车，距离" + distance
                        list1.add( new Car_query_expand(busId + "号(101人)",new Random().nextInt(10)+1+"分钟到达","距离站台"+distance+"米",R.drawable.bus));
                    }

                    JSONObject jsonObject2 = new JSONObject();
                    jsonObject2.put("BusStationId", 2);
                    String result2 = HttpUrl.posthttp(address + "GetBusStationInfo.do",
                            jsonObject2.toString());
                    result2 = new JSONObject(result2).getString("serverinfo");
                    JSONArray jsonArray2 = new JSONArray(result2);
                    list2.clear();
                    for (int i = 0; i < jsonArray2.length(); i++) {
                        JSONObject json = jsonArray2.getJSONObject(i);
                        int distance = json.getInt("Distance");
                        int busId = json.getInt("BusId");
                        //这里给数据
                        // busId + "号公交车，距离" + distance
                        list2.add( new Car_query_expand(busId + "号(101人)",new Random().nextInt(10)+1+"分钟到达","距离站台"+distance+"米",R.drawable.bus));
                    }
                    //这里给数据
                    listMap.clear();
                    listMap.put(strings[0], list1);
                    Log.e("11111", "" + list1);
                    listMap.put(strings[1], list2);
                    Log.e("22222", "" + list2);

                    showView();
                } catch (JSONException e) {
                    e.printStackTrace();
                    //showViewerror();
                } catch (IOException e) {
                    e.printStackTrace();
                    //showViewerror();
                }

            }
        }).start();
    }


    private void showView() {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }

    @Override
    public void onPause() {
        super.onPause();
        timer.cancel();
    }
}
