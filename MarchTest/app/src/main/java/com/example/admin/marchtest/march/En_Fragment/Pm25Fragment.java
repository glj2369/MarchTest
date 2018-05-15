package com.example.admin.marchtest.march.En_Fragment;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.marchtest.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class Pm25Fragment extends Fragment {


    private View view;
    private LineChart mLightChart;
    private LineData lineData;
    private LineDataSet lineDataSet;
    private ArrayList<Entry> entries = new ArrayList<>();
    private ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();
    private Context contex;
    private Timer timer;
    private String[] s = new String[60];
    private int i = 1;

    public Pm25Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_pm25, container, false);
        initView(view);
        Ran();
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {

                //lineDataSet.clear();
                Ran();
                //lineData.clearValues();
                getActivity().runOnUiThread( new Runnable() {
                    @Override
                    public void run() {


                        mLightChart.invalidate();
                        mLightChart.notifyDataSetChanged();
                        mLightChart.moveViewToX(lineDataSet.getEntryCount());
                        mLightChart.setVisibleXRangeMaximum(20);


                    }
                });


            }
        };
        timer.schedule(timerTask, 1000, 3000);

        lineDataSet = new LineDataSet(entries, "(秒)");
        iLineDataSets.add(lineDataSet);
        lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet.setCircleColors(ColorTemplate.JOYFUL_COLORS);
        lineData = new LineData(iLineDataSets);
        YAxis left = mLightChart.getAxisLeft();
        //left.setDrawTopYLabelEntry(true);
        //left.setDrawAxisLine(false);


        XAxis xAxis = mLightChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setLabelRotationAngle(90);

        xAxis.setSpaceMin(1);//3.x独有，以前为xl.setSpaceBetweenLabels(1)
        //xAxis.setAvoidFirstLastClipping(true);//避免去掉起始标签
        xAxis.setLabelCount(5);

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //xAxis.setAxisMinValue(3);
        // xAxis.setLabelCount(5);
        //mLightChart.setVisibleXRangeMinimum(3);
        mLightChart.getAxisRight().setEnabled(false);
        left.setDrawGridLines(false);
        mLightChart.setGridBackgroundColor(Color.parseColor("#00BFFF"));
        mLightChart.getLegend().setEnabled(false);
        mLightChart.setData(lineData);

        mLightChart.setDragEnabled(true);//可拖拽
        mLightChart.fitScreen();///自动缩放图表
        mLightChart.getDescription().setText("(秒)");
        return view;
    }

    private void Ran() {

        int nextInt = new Random().nextInt(500);

        if (nextInt > 200) {
            NotificationManager service = (NotificationManager) contex.getSystemService(Context.NOTIFICATION_SERVICE);
            Notification no = new NotificationCompat.Builder(contex)
                    .setContentText("当前pm2.5值：" + nextInt)
                    .setSmallIcon(R.drawable.logo2)
                    .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.logo2))
                    .setWhen(System.currentTimeMillis())
                    .build();
            service.notify(1, no);
        }
        if (i == 1) {
            entries.add(new Entry(i * 3, nextInt));
        } else {
            lineData.addEntry(new Entry(i * 3, nextInt), 0);

        }

        i++;

        /*for (int i = 1; i < 6; i++) {

            int nextInt = new Random().nextInt(500);
            if (i == 1) {
                if (nextInt > 200) {
                    NotificationManager service = (NotificationManager) contex.getSystemService(Context.NOTIFICATION_SERVICE);
                    Notification no = new NotificationCompat.Builder(contex)
                            .setContentText("当前pm2.5值：" + nextInt)
                            .setSmallIcon(R.drawable.logo2)
                            .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.logo2))
                            .setWhen(System.currentTimeMillis())
                            .build();
                    service.notify(1, no);
                }
            }

            entries.add(new Entry(i * 3, nextInt));

        }*/
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.contex = context;
    }

    private void initView(View view) {
        mLightChart = (LineChart) view.findViewById(R.id.pm25_chart);
        for (int i = 0; i < 60; i++) {
            s[i] = i + 1 + "";
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mLightChart.clear();
        lineData.clearValues();

        lineDataSet.clear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();

    }
}
