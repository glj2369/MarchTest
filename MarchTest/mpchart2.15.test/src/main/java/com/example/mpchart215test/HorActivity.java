package com.example.mpchart215test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

public class HorActivity extends AppCompatActivity implements View.OnClickListener {

    private HorizontalBarChart mHorbarChart;
    /**
     * 数据刷新
     */
    private Button mHorbarRe;
    private BarDataSet barDataSet;
    private BarData barData;
    private String [] s=new String[]{};
    private ArrayList<BarEntry> entries=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor);
        initView();
        ran();
        barDataSet=new BarDataSet(entries,"标签1");
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);

        barData=new BarData(s,barDataSet);
        mHorbarChart.setData(barData);
        mHorbarChart.setGridBackgroundColor(Color.WHITE);
        mHorbarChart.setVisibleXRangeMaximum(6);
        mHorbarChart.setScaleEnabled(true);
        XAxis xAxis = mHorbarChart.getXAxis();
        xAxis.setSpaceBetweenLabels(5);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        mHorbarChart.getAxisRight().setEnabled(false);
        mHorbarChart.setDescription("");
        mHorbarChart.getAxisLeft().setDrawGridLines(false);
    }

    private void ran() {
        Random random=new Random();
        for (int i=0;i<9;i++){
            entries.add(new BarEntry(random.nextInt(12)+1,i));
        }
    }

    private void initView() {
        mHorbarChart = (HorizontalBarChart) findViewById(R.id.horbar_chart);
        mHorbarRe = (Button) findViewById(R.id.horbar_re);
        mHorbarRe.setOnClickListener(this);
        s = new String[]{"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月",};
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.horbar_re:
                barDataSet.clear();
                ran();
                mHorbarChart.invalidate();
                break;
        }
    }
}
