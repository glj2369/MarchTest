package com.example.admin.marchtest.march.data_fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.marchtest.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
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
public class PieFragment extends Fragment {


    private View view;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    private PieChart mCarPie;
    private ArrayList<PieEntry> entries=new ArrayList<PieEntry>();
    private PieDataSet pieDataSet;
    private PieData pieData;

    public PieFragment() {
        // Required empty public constructor
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Ran();
        pieDataSet=new PieDataSet(entries,"");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);//设置块颜色
        pieData=new PieData(pieDataSet);
        pieDataSet.setValueFormatter(new PercentFormatter());
        // pieDataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setValueTextColor(Color.parseColor("#FF8C00"));
        pieDataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        pieDataSet.setValueLinePart1Length(0.3f);
        pieDataSet.setValueLinePart2Length(0.4f);
        pieDataSet.setValueTextSize(30);
        pieDataSet.setValueLinePart1OffsetPercentage(50.0f);
        mCarPie.setData(pieData);
        mCarPie.setDrawHoleEnabled(false);
        mCarPie.getDescription().setEnabled(false);
        Legend legend=mCarPie.getLegend();
        legend.setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        legend.setTextSize(20);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pie, container, false);
        mTitle = (TextView) view.findViewById(R.id.title);
        mCarPie = (PieChart) view.findViewById(R.id.car_pie);
        mTitle.setText("数据分析");
        return view;
    }

    private void Ran() {
        Random random=new Random();
        float a = random.nextFloat() + 1;
        float b=100-a;
        entries.add(new PieEntry(a,"有违章"));
        entries.add(new PieEntry(b,"无违章"));
    }

    @Override
    public void onPause() {
        super.onPause();
        mCarPie.clear();
        pieData.clearValues();
        pieDataSet.clear();
    }
}
