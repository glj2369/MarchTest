package com.example.admin.test.test7Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.test.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class sevenFragment extends Fragment {


    private View view;
    private BarDataSet barDataSet;
    private BarData barData;
    private String s[];
    private ArrayList<BarEntry> entries = new ArrayList<>();
    private HorizontalBarChart mHorBar2chart;

    public sevenFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_seven, container, false);
        initView(view);
        for(int i=0;i<10;i++){
            entries.add(new BarEntry(new Random().nextInt(25)+1,i));
        }
        barDataSet=new BarDataSet(entries,"");
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueFormatter(new PercentFormatter());
        barDataSet.setValueTextSize(20);
        barData=new BarData(s,barDataSet);
        mHorBar2chart.setData(barData);
        mHorBar2chart.setDescription("");
        mHorBar2chart.getAxisRight().setValueFormatter(new PercentFormatter());
        mHorBar2chart.getAxisLeft().setEnabled(false);
        mHorBar2chart.getLegend().setEnabled(false);
        XAxis xAxis = mHorBar2chart.getXAxis();
        xAxis.setTextSize(15);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        return view;
    }

    private void initView(View view) {
        mHorBar2chart = (HorizontalBarChart) view.findViewById(R.id.horBar2chart);
        s = new String[]{"机动车逆向行驶", "违规使用专用车道", "违反禁令使用标识","不按规定系安全带","机动车不走机动车道", "违反信号灯规定", "违反禁止标线指示","违规停车拒绝驶离", "违规驶入导向车道","超速行驶",};
    }
    @Override
    public void onPause() {
        super.onPause();
        barData.clearValues();
        barDataSet.clear();
        mHorBar2chart.clear();
    }
}
