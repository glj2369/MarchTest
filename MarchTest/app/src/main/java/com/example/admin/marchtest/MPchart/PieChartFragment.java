package com.example.admin.marchtest.MPchart;


import android.icu.util.ValueIterator;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.marchtest.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IPieDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class PieChartFragment extends Fragment implements View.OnClickListener {
    private PieChart pieChart;
    private Button mre;
    private ArrayList<PieEntry> entries = new ArrayList<PieEntry>();
    private String[] XV = new String[4];
    private PieDataSet pieDataSet;
    private PieData pieData;
    private ArrayList<IPieDataSet> arr = new ArrayList<IPieDataSet>();
    private View view;

    public PieChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_pie_chart, container, false);
        initView();
        ran();
        pieDataSet = new PieDataSet(entries, "班级成绩统计图");
        pieDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        pieDataSet.setValueTextSize(20);
        pieDataSet.setDrawValues(true);
        pieDataSet.setValueFormatter(new PercentFormatter());
        arr.add(pieDataSet);
        pieData = new PieData(pieDataSet);//??????
        pieChart.setData(pieData);
        pieChart.setUsePercentValues(true);//使用百分比
        pieChart.setDrawHoleEnabled(false);//隐藏中间洞
        pieChart.animateXY(2000,2000);
        pieChart.getDescription().setText("班级成绩统计图");

        return view;
    }

    private void initView() {
        pieChart = view.findViewById(R.id.pie_chart);
        mre = view.findViewById(R.id.re_pie);
        mre.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        pieDataSet.clear();

        ran();
        pieChart.invalidate();
        pieChart.notifyDataSetChanged();
        pieChart.animateXY(2000,2000);
    }

    private void ran() {
        Random random = new Random();
        int a = random.nextInt(20) + 1;
        int b = random.nextInt(100 - a-50)+1;
        int c = random.nextInt(100 - a - b)+1 ;
        int d = 100-a-b-c;
        if (a+b+c+d==100){
            Toast.makeText(getActivity(), "百分比正确！！", Toast.LENGTH_SHORT).show();
        }
        entries.add(new PieEntry(a, "优秀"));
        entries.add(new PieEntry(b, "良好"));
        entries.add(new PieEntry(c, "及格"));
        entries.add(new PieEntry(d, "不及格"));
    }
}
