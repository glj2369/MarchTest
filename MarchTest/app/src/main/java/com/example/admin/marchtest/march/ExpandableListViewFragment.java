package com.example.admin.marchtest.march;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.example.admin.marchtest.ExpandList;
import com.example.admin.marchtest.HttpUtil.HttpUrl;
import com.example.admin.marchtest.R;
import com.example.admin.marchtest.adapter.expandablelistviewAdapter;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class ExpandableListViewFragment extends Fragment {


    private View view;
    private ExpandableListView mExpandList;
    private expandablelistviewAdapter adapter;
    private String[] strings = new String[]{"一号站台", "二号站台"};
    private Map<String, List<ExpandList>> listMap = new HashMap<>();
    private List<ExpandList> list1 = new ArrayList<>();
    private List<ExpandList> list2 = new ArrayList<>();
    private Context context;
    private Timer timer;
    private TextView textView;

    public ExpandableListViewFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_expandable_list_view, container, false);
        initView(view);
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                getDate();
            }
        };
        timer.schedule(timerTask, 1000, 3000);

        adapter = new expandablelistviewAdapter(listMap, strings, context);
        mExpandList.setAdapter(adapter);
        return view;
    }

    /**
     * 可扩展的listview
     */
    private void getDate() {
        String ip = getActivity().getSharedPreferences("ipset", 0).getString("ip", "192.168.1.106");
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
                        list1.add(new ExpandList(busId + "号公交车，距离" + distance, "十年生死两茫茫", R.drawable.logo1));
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
                        list2.add(new ExpandList(busId + "号公交车，距离" + distance, "不思量 自难忘", R.drawable.logo2));
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

    private void initView(View view) {
        mExpandList = (ExpandableListView) view.findViewById(R.id.expand_List);
        textView = view.findViewById(R.id.title);
        textView.setText("公交查询");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();
    }
}
