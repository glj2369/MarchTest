package com.example.mpchart215test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;

import java.util.ArrayList;
import java.util.Random;

public class Line_Activity extends AppCompatActivity implements View.OnClickListener {

    private LineChart mLineChart;
    /**
     * 数据刷新
     */
    private Button mLineRe;
    private LineData lineData;
    private LineDataSet lineDataSet;
    private String[] s;
    private ArrayList<Entry> entries = new ArrayList<>();
    /**
     * 第二条线
     */
    private ArrayList<Entry> entries1 = new ArrayList<>();
    private LineDataSet lineDataSet1;
    private ArrayList<LineDataSet> lineDataSets = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_line_);

        initView();
        Ran();
        lineDataSet = new LineDataSet(entries, "标签1");//为图例标签说明
        //第二条线
        lineDataSet1 = new LineDataSet(entries1, "标签2");
        lineDataSet1.setValueFormatter(new PercentFormatter());//百分比格式化
        //向集合填入2条线
        lineDataSets.add(lineDataSet);
        lineDataSets.add(lineDataSet1);


        lineData = new LineData(s, lineDataSets);
        mLineChart.setData(lineData);
        mLineChart.setDescription("条形图");
        mLineChart.getAxisLeft().setValueFormatter(new PercentFormatter());//百分比格式化
        mLineChart.getLegend().setPosition(Legend.LegendPosition.RIGHT_OF_CHART_CENTER);//移动图例位置
        mLineChart.setVisibleXRangeMaximum(5);///设置一屏点数量

        //mLineChart.moveViewToX(lineDataSet.getEntryCount()-1);  //移动视图位置，可用
        //以下为必须属性
        mLineChart.setGridBackgroundColor(Color.WHITE);

        mLineChart.getAxisLeft().setDrawGridLines(false);
        mLineChart.getAxisRight().setEnabled(false);
        XAxis xAxis = mLineChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setSpaceBetweenLabels(5);//设置标签间距
        xAxis.setAvoidFirstLastClipping(true);//避免去开始，结尾标签
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        // xAxis.setLabelsToSkip();   //绘制下一个标签自动跳过标签数量
    }


    private void Ran() {
        Random r = new Random();
        for (int i = 0; i < 9; i++) {
            entries.add(new Entry(r.nextInt(10), i));
            entries1.add(new Entry(r.nextInt(10), i));
        }
    }

    private void initView() {
        mLineChart = (LineChart) findViewById(R.id.line_chart);
        mLineRe = (Button) findViewById(R.id.line_re);
        mLineRe.setOnClickListener(this);
        s = new String[]{"一月", "二月", "三月", "四月", "五月", "六月", "七月", "八月", "九月",};

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.line_re:
                lineDataSet.clear();
                lineDataSet1.clear();
                Ran();
                mLineChart.invalidate();
                break;
        }
    }
}
