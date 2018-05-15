package com.example.admin.marchtest.march.data_fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.RotateAnimation;
import android.widget.TextView;

import com.example.admin.marchtest.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.IValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorBarFragment extends Fragment implements View.OnClickListener {


    private View view;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    private HorizontalBarChart mCarHorBar;
    private BarData barData;
    private BarDataSet barDataSet;
    private ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
    private String[] XV;
    private ArrayList<IBarDataSet> iBarDataSets = new ArrayList<IBarDataSet>();

    public HorBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_hor_bar, container, false);
        initView(view);
        Ran();
        barDataSet = new BarDataSet(entries, "");
        XV = new String[]{"1-2条违章", "3-5条违章", "5条以上违章"};
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        barDataSet.setDrawValues(true);//显示顶点值
        // barDataSet.setValueFormatter(new PercentFormatter());
        //barDataSet.setValueTextColor(Color.parseColor("#FFA500"));
        iBarDataSets.add(barDataSet);
        barData = new BarData(iBarDataSets);

        // barData.setDrawValues(true);

        mCarHorBar.setData(barData);
        mCarHorBar.setScaleEnabled(true);
        mCarHorBar.setScaleX(0.8f);
        mCarHorBar.setScaleX(0.8f);
        mCarHorBar.setMaxVisibleValueCount(10);
        mCarHorBar.getDescription().setEnabled(false);
        //mCarHorBar.getDescription().setPosition(10,10);
        //mCarHorBar.setVisibleXRangeMaximum(3);
        XAxis xAxis = mCarHorBar.getXAxis();
        xAxis.setLabelCount(3);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                int in = (int) value;
                if (in < 0 || in > XV.length) {
                    return "";
                } else {
                    return XV[(int) value];
                }

            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });
        Legend legend = mCarHorBar.getLegend();
        legend.setEnabled(false);
        YAxis right = mCarHorBar.getAxisRight();
        YAxis left = mCarHorBar.getAxisLeft();
        right.setValueFormatter(new PercentFormatter());
        left.setEnabled(false);//隐藏左边y轴
        // xAxis.setLabelCount(3);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//设置x轴位置

        return view;
    }

    private void Ran() {
        Random random = new Random();

        entries.add(new BarEntry(0, 20));
        entries.add(new BarEntry(1, 60));
        entries.add(new BarEntry(2, 40));


    }

    private void initView(View view) {
        mTitle = (TextView) view.findViewById(R.id.title);

        mTitle.setOnClickListener(this);
        mCarHorBar = (HorizontalBarChart) view.findViewById(R.id.car_Hor_Bar);
        mTitle.setText("数据分析");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.title:
                break;
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mCarHorBar.clear();
        barDataSet.clear();
        barData.clearValues();
    }
}
