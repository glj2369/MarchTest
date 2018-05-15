package com.example.admin.marchtest.march.data_fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.marchtest.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarBarFragment extends Fragment {


    private View view;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    private BarChart mCarTimeBar;
    private BarData barData;
    private BarDataSet barDataSet;
    private ArrayList<BarEntry> entries=new ArrayList<>();
    private String s[];
    private ArrayList<IBarDataSet> iBarDataSets=new ArrayList<>();

    public CarBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_car_bar, container, false);
        initView(view);
        Ran();
        s=new String[]{"0:00:01-2:00:00","2:00:01-4:00:00","4:00:01-6:00:00","6:00:01-8:00:00","8:00:01-10:00:00","10:00:01-12:00:00","12:00:01-14:00:00","14:00:01-16:00:00","16:00:01-18:00:00", "18:00:01-20:00:00","21:00:01-22:00:00","22:00:01-24:00:00"};
        barDataSet=new BarDataSet(entries,"");
        barDataSet.setValueFormatter(new PercentFormatter());
        barDataSet.setValueTextColor(Color.parseColor("#FF0000"));
        barDataSet.setValueTextSize(20);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        iBarDataSets.add(barDataSet);
        barData=new BarData(iBarDataSets);
        mCarTimeBar.setData(barData);
        mCarTimeBar.getAxisRight().setEnabled(false);
        mCarTimeBar.getLegend().setEnabled(false);
        mCarTimeBar.getDescription().setEnabled(false);
        XAxis xAxis = mCarTimeBar.getXAxis();
        mCarTimeBar.getAxisLeft().setValueFormatter(new PercentFormatter());
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(12);
        xAxis.setValueFormatter(new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                int in= (int) value;
                if (in<0||in>s.length){
                    return "";
                }else {
                    return s[(int)value];
                }

            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        });
        xAxis.setLabelRotationAngle(-45);
        return view;
    }

    private void Ran() {
        Random random=new Random();
        for (int i=0;i<12;i++){
            int a = random.nextInt(25) + 1;
            entries.add(new BarEntry(i,a));
        }
    }

    private void initView(View view) {
        mTitle = (TextView) view.findViewById(R.id.title);
        mCarTimeBar = (BarChart) view.findViewById(R.id.car_time_bar);
        mTitle.setText("数据分析");
    }

    @Override
    public void onPause() {
        super.onPause();
        mCarTimeBar.clear();
        barDataSet.clear();
        barData.clearValues();
    }
}
