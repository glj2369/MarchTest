package com.example.mpchart215test;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

public class PieActivity extends AppCompatActivity implements View.OnClickListener {

    private PieChart mPieChart;
    /**
     * 数据刷新
     */
    private Button mPieRe;
    private PieDataSet pieDataSet;
    private PieData pieData;
    private ArrayList<Entry> entries=new ArrayList<>();
    private String [ ]s =new String[]{};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie);
        initView();
        ran();
        pieDataSet=new PieDataSet(entries,"标签1");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueFormatter(new PercentFormatter());
        pieData=new PieData(s,pieDataSet);
        pieData.setValueTextSize(20);
        pieDataSet.setSelectionShift(25f);//设置饼状Item被选中时变化的距离
        pieDataSet.setSliceSpace(5); //设置饼状Item之间的间隙
        mPieChart.setData(pieData);
        mPieChart.setDrawHoleEnabled(false);

    }

    private void ran() {
        Random random=new Random();;

            int a=random.nextInt(30)+1;
            int b=random.nextInt(20)+1;
            int c=random.nextInt(100-a-b)+1;
            int d=100-a-b-c;
            entries.add(new Entry(a,0));
            entries.add(new Entry(b,1));
            entries.add(new Entry(c,2));
            entries.add(new Entry(d,3));


    }

    private void initView() {
        mPieChart = (PieChart) findViewById(R.id.pie_chart);
        mPieRe = (Button) findViewById(R.id.pie_re);
        mPieRe.setOnClickListener(this);
        s=new String[]{"周一","周二","周三","周四"};
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.pie_re:
                pieDataSet.clear();
                ran();
                mPieChart.invalidate();
                break;
        }
    }
}
