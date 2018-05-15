package com.example.admin.marchtest.march.En_Fragment;


import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.marchtest.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class AirFragment extends Fragment {


    private View view;
    private LineChart mAirChart;
    private LineData lineData;
    private LineDataSet lineDataSet;
    private ArrayList<Entry> entries=new ArrayList<>();
    private ArrayList<ILineDataSet> iLineDataSets=new ArrayList<>();
    private Context contex;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.contex=context;
    }

    public AirFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_air, container, false);
        Ran();
        initView(view);
        lineDataSet=new LineDataSet(entries,"(秒)");
        iLineDataSets.add(lineDataSet);
        lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet.setCircleColors(ColorTemplate.JOYFUL_COLORS);
        lineData=new LineData(iLineDataSets);
        XAxis xAxis = mAirChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        //xAxis.setAxisMinValue(3);
        xAxis.setSpaceMin(1);
        xAxis.setLabelCount(5);
        mAirChart.getAxisRight().setEnabled(false);
        mAirChart.getAxisLeft().setDrawGridLines(false);
        mAirChart.getLegend().setEnabled(false);
        mAirChart.setData(lineData);
        mAirChart.getDescription().setText("(秒)");
        return view;
    }

    private void initView(View view) {
        mAirChart = (LineChart) view.findViewById(R.id.air_chart);
    }

    private void Ran() {
        for(int i=1;i<6;i++){

            entries.add(new Entry(i*3,new Random().nextInt(500)));

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mAirChart.clear();
        lineData.clearValues();

        lineDataSet.clear();
    }
}
