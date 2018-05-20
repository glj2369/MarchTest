package com.example.admin.test.test7Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.test.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class twoFragment extends Fragment {


    private View view;
    private PieChart mPie2chart;
    private PieDataSet pieDataSet;
    private PieData pieData;
    private String string[];
    private ArrayList<Entry> entries = new ArrayList<>();
    public twoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_two, container, false);
        initView(view);
        entries.add(new Entry(13.8f, 0));
        entries.add(new Entry(86.1f, 1));
        pieDataSet = new PieDataSet(entries, "");
        pieDataSet.setValueFormatter(new PercentFormatter());
        pieDataSet.setValueTextSize(20);
        pieDataSet.setSliceSpace(4);
        pieDataSet.setSelectionShift(2);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieData = new PieData(string, pieDataSet);
        mPie2chart.setData(pieData);
        mPie2chart.setDrawHoleEnabled(false);
        mPie2chart.setDescription("");
        mPie2chart.getLegend().setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        return view;
    }

    private void initView(View view) {
        mPie2chart = (PieChart) view.findViewById(R.id.pie2chart);
        string = new String[]{"有重复违章", "无重复违章"};
    }

    @Override
    public void onPause() {
        super.onPause();
        pieData.clearValues();
        pieDataSet.clear();
        mPie2chart.clear();
    }
}
