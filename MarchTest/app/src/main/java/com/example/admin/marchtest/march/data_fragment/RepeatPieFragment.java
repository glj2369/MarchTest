package com.example.admin.marchtest.march.data_fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.marchtest.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class RepeatPieFragment extends Fragment {


    private View view;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    private PieChart mCarRepeatPie;
    private PieData pieData;
    private PieDataSet pieDataSet;
    private ArrayList<PieEntry> entries=new ArrayList<PieEntry>();

    public RepeatPieFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_repeat_pie, container, false);
        initView(view);
        Ran();
        pieDataSet.setValueLinePart1Length(0.3f);
        pieDataSet.setValueLinePart2Length(0.4f);
        pieDataSet.setValueLinePart1OffsetPercentage(80.0f);
        pieDataSet.setValueTextColor(Color.parseColor("#00BFFF"));
        pieDataSet.setValueTextSize(20);
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setValueFormatter(new PercentFormatter());
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieData=new PieData(pieDataSet);
        mCarRepeatPie.setData(pieData);
        mCarRepeatPie.setDrawHoleEnabled(false);
        mCarRepeatPie.getDescription().setEnabled(false);
        Legend legend=mCarRepeatPie.getLegend();
        legend.setTextSize(20);
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        return view;
    }

    private void Ran() {
        Random random=new Random();
        float a = random.nextFloat() + 1;
        float b=100-a;
        entries.add(new PieEntry(a,"有重复违章"));
        entries.add(new PieEntry(b,"无重复违章"));
        pieDataSet=new PieDataSet(entries,"");
    }

    private void initView(View view) {
        mTitle = (TextView) view.findViewById(R.id.title);
        mCarRepeatPie = (PieChart) view.findViewById(R.id.car_repeat_pie);
        mTitle.setText("数据分析");
    }

    @Override
    public void onPause() {
        super.onPause();
    pieData.clearValues();
    pieDataSet.clear();
        mCarRepeatPie.clear();
    }
}
