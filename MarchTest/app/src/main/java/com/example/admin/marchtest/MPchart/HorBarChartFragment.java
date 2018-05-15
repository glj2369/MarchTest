package com.example.admin.marchtest.MPchart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.admin.marchtest.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class HorBarChartFragment extends Fragment implements View.OnClickListener {


private HorizontalBarChart horizontalBarChart;
    private Button hore;
    private ArrayList<BarEntry> entries = new ArrayList<BarEntry>();
    private String[] XV = new String[12];
    private BarDataSet barDataSet;
    private BarData barData;
    private ArrayList<IBarDataSet> iBarDataSets = new ArrayList<IBarDataSet>();
    private View view;

    public HorBarChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_hor_bar_chart, container, false);
        initView();
        ran();
        barDataSet = new BarDataSet(entries, "公司年利润报表");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        iBarDataSets.add(barDataSet);
        barData = new BarData(iBarDataSets);
        horizontalBarChart.setData(barData);
        horizontalBarChart.getDescription().setText("公司前半年财务报表(单位：万元)");
        horizontalBarChart.setDragEnabled(true);//可缩放
        horizontalBarChart.animateXY(2000, 2000);
        horizontalBarChart.setVisibleXRangeMaximum(7);
        XAxis xAxis = horizontalBarChart.getXAxis();
        YAxis yAxis = horizontalBarChart.getAxisRight();
        YAxis yAxis1 = horizontalBarChart.getAxisLeft();
        xAxis.setDrawGridLines(false);//禁止绘制网格线
        yAxis.setDrawGridLines(false);
        yAxis1.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelCount(7);
        IAxisValueFormatter iAxisValueFormatter = new IAxisValueFormatter() {
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
        };
        xAxis.setValueFormatter(iAxisValueFormatter);

        return view;
    }

    private void initView() {
        horizontalBarChart = view.findViewById(R.id.HorBar_Chart);
        hore = view.findViewById(R.id.re_horbar);
        hore.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {


        barDataSet.clear();
        ran();
        horizontalBarChart.invalidate();
        horizontalBarChart.animateXY(2000, 2000);
    }

    private void ran() {
        Random random = new Random();//随机数
        for (int i = 0; i < 12; i++) {
            float profit = random.nextFloat() * 1000;
            //entries.add(BarEntry(float val,int positon);
            entries.add(new BarEntry(i, profit));
            XV[i] = (i + 1) + "月";
        }
    }
}
