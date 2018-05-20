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

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class fiveFragment extends Fragment {


    private View view;
    private BarChart mBar2chart;
    private BarDataSet barDataSet;
    private BarData barData;
    private String s[];
    private ArrayList<BarEntry> entries = new ArrayList<>();

    public fiveFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_five, container, false);
        initView(view);

        entries.add(new BarEntry(new float[]{16f,20f}, 0));
        entries.add(new BarEntry(new float[]{20f,25f}, 1));

        barDataSet = new BarDataSet(entries, "");
        barDataSet.setColors(new int[]{Color.GREEN,Color.YELLOW});
        barDataSet.setValueFormatter(new PercentFormatter());
        barDataSet.setStackLabels(new String[]{"有违法","无违法"});
        barDataSet.setValueTextSize(20);
        barData = new BarData(s, barDataSet);
        mBar2chart.setData(barData);
        mBar2chart.setDescription("");
        mBar2chart.getAxisRight().setEnabled(false);
        mBar2chart.getLegend().setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
        XAxis xAxis = mBar2chart.getXAxis();
        xAxis.setTextSize(15);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);

        return view;
    }

    private void initView(View view) {
        mBar2chart = (BarChart) view.findViewById(R.id.Bar2chart);
        s = new String[]{"女性", "男性"};
    }

    @Override
    public void onPause() {
        super.onPause();
        barData.clearValues();
        barDataSet.clear();
        mBar2chart.clear();
    }
}
