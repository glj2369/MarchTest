package com.example.admin.test.test7Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.test.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
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
public class sixFragment extends Fragment {


    private View view;
    private BarChart mBar3chart;
    private BarDataSet barDataSet;
    private BarData barData;
    private String s[];
    private ArrayList<BarEntry> entries = new ArrayList<>();

    public sixFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_six, container, false);
        initView(view);
        for (int i=0;i<12;i++){
            entries.add(new BarEntry(new Random().nextInt(25)+1,i));
        }
        barDataSet = new BarDataSet(entries, "");
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS
        );
        barDataSet.setValueFormatter(new PercentFormatter());
        barDataSet.setStackLabels(new String[]{"有违法","无违法"});
        barDataSet.setValueTextSize(20);
        barData = new BarData(s, barDataSet);
        mBar3chart.setData(barData);
        mBar3chart.setDescription("");
        mBar3chart.getAxisRight().setEnabled(false);
        mBar3chart.getLegend().setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
        XAxis xAxis = mBar3chart.getXAxis();
        xAxis.setTextSize(15);
        xAxis.setLabelsToSkip(0);//显示12个值
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        return view;
    }

    private void initView(View view) {
        mBar3chart = (BarChart) view.findViewById(R.id.Bar3chart);
        s = new String[]{"0:00:01-2:00:00","2:00:01-4:00:00","4:00:01-6:00:00","6:00:01-8:00:00","8:00:01-10:00:00","10:00:01-12:00:00","12:00:01-14:00:00","14:00:01-16:00:00","16:00:01-18:00:00","18:00:01-20:00:00","20:00:01-22:00:00","22:00:01-24:00:00"};
    }

    @Override
    public void onPause() {
        super.onPause();
        barData.clearValues();
        barDataSet.clear();
        mBar3chart.clear();
    }
}
