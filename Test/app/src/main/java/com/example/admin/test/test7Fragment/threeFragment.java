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

/**
 * A simple {@link Fragment} subclass.
 */
public class threeFragment extends Fragment {


    private View view;
    private HorizontalBarChart mHorBarchart;
    private BarChart barChart;
    private BarDataSet barDataSet;
    private BarData barData;
    private String s[];
    private ArrayList<BarEntry> entries = new ArrayList<>();

    public threeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_three, container, false);
        initView(view);
        entries.add(new BarEntry(60.51f, 0));
        entries.add(new BarEntry(26.28f, 1));
        entries.add(new BarEntry(13.20f, 2));
        barDataSet=new BarDataSet(entries,"");
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        barDataSet.setValueFormatter(new PercentFormatter());
        barDataSet.setValueTextSize(20);
        barData=new BarData(s,barDataSet);
        mHorBarchart.setData(barData);
        mHorBarchart.setDescription("");
        mHorBarchart.getAxisRight().setValueFormatter(new PercentFormatter());
        mHorBarchart.getAxisLeft().setEnabled(false);
        mHorBarchart.getLegend().setEnabled(false);
        XAxis xAxis = mHorBarchart.getXAxis();
        xAxis.setTextSize(15);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        return view;
    }

    private void initView(View view) {
        mHorBarchart = (HorizontalBarChart) view.findViewById(R.id.horBarchart);
        s = new String[]{"1-2条违章", "3-5条违章", "5条以上违章",};
    }

    @Override
    public void onPause() {
        super.onPause();
        barData.clearValues();
        barDataSet.clear();
        mHorBarchart.clear();
    }
}
