package com.example.mpchart215test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

public class BarActivity extends AppCompatActivity implements View.OnClickListener {

    private BarChart mBarChart;
    /**
     * 数据刷新
     */
    private Button mBarRe;
    private BarDataSet barDataSet;
    private BarData barData;
    private String[] s = new String[]{};
    private ArrayList<BarEntry> barEntries = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bar);
        initView();
        ran();
        barDataSet=new BarDataSet(barEntries,"label1");
        barDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        //顶点值格式化测试
        barDataSet.setValueFormatter(new PercentFormatter());

        barData=new BarData(s,barDataSet);
        mBarChart.setData(barData);
        mBarChart.setVisibleXRangeMaximum(7);
        mBarChart.setGridBackgroundColor(Color.WHITE);
        mBarChart.getAxisRight().setEnabled(false);
        XAxis xAxis = mBarChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
    }

    private void ran() {
        Random random = new Random();
        for (int i = 0; i < 9; i++) {
            barEntries.add(new BarEntry(random.nextInt(10) + 1, i));
        }
    }

    private void initView() {
        mBarChart = (BarChart) findViewById(R.id.bar_chart);
        mBarRe = (Button) findViewById(R.id.bar_re);
        mBarRe.setOnClickListener(this);
        s = new String[]{"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月",};
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bar_re:
                barDataSet.clear();
                ran();
                mBarChart.invalidate();
                break;
        }
    }
}
