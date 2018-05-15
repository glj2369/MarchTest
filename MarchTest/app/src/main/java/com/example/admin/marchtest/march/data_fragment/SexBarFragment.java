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
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class SexBarFragment extends Fragment {


    private View view;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    private BarChart mCarSexHaveBar;
    private BarData barData;
    private BarDataSet barDataSet;
    private ArrayList<BarEntry> entries=new ArrayList<>();
    private String [] s;
    private ArrayList<IBarDataSet> iBarDataSets=new ArrayList<>();


    public SexBarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_sex_bar, container, false);
        initView(view);
        ran();
        barDataSet=new BarDataSet(entries,"");
        barDataSet.setColors(Color.parseColor("#32CD32"),Color.parseColor("#FF8C00"));
        barDataSet.setStackLabels(new String[]{"有违法","无违法"});
        barDataSet.setValueFormatter(new PercentFormatter());
        barDataSet.setValueTextColor(Color.parseColor("#FF0000"));
        barDataSet.setValueTextSize(20);
        iBarDataSets.add(barDataSet);
        barData=new BarData(iBarDataSets);
        mCarSexHaveBar.setData(barData);
        mCarSexHaveBar.getDescription().setEnabled(false);
        mCarSexHaveBar.setScaleEnabled(true);
        mCarSexHaveBar.setScaleY(0.7f);
        mCarSexHaveBar.setScaleX(0.7f);
        mCarSexHaveBar.getLegend().setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);
        XAxis xAxis = mCarSexHaveBar.getXAxis();
        mCarSexHaveBar.getAxisRight().setEnabled(false);
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(2);
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
        return view;
    }

    private void ran() {
        Random random=new Random();
        for (int i=0;i<2;i++){
            float a = random.nextInt(30) + 1;
            float b = random.nextInt(20) + 1;
            entries.add(new BarEntry(i,new float[]{a,b}));

        }

    }

    private void initView(View view) {
        mTitle = (TextView) view.findViewById(R.id.title);
        mCarSexHaveBar = (BarChart) view.findViewById(R.id.car_Sex_have_bar);
        s=new String[]{"女性","男性"};
        mTitle.setText("数据分析");
    }

    @Override
    public void onPause() {
        super.onPause();
        mCarSexHaveBar.clear();
        barDataSet.clear();
        barData.clearValues();
    }
}
