package com.example.admin.test.test7Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.test.R;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class fourFragment extends Fragment {


    private View view;
    private BarChart mBarchart;
    private BarChart barChart;
    private BarDataSet barDataSet;
    private BarData barData;
    private String s[];
    private ArrayList<BarEntry> entries = new ArrayList<>();

    public fourFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_four, container, false);
        initView(view);
        entries.add(new BarEntry(new float[]{16f,20f}, 0));
        entries.add(new BarEntry(new float[]{20f,25f}, 1));
        entries.add(new BarEntry(new float[]{16f,34f}, 2));
        entries.add(new BarEntry(new float[]{16f,15f}, 3));
        entries.add(new BarEntry(new float[]{16f,10f}, 4));

        barDataSet = new BarDataSet(entries, "");
        barDataSet.setColors(new int[]{Color.GREEN,Color.YELLOW});
        barDataSet.setValueFormatter(new PercentFormatter());
        barDataSet.setStackLabels(new String[]{"有违章","无违章"});
        barDataSet.setValueTextSize(20);
        barData = new BarData(s, barDataSet);
        mBarchart.setData(barData);
        mBarchart.setDescription("");
        mBarchart.getAxisRight().setEnabled(false);
        mBarchart.getLegend().setPosition(Legend.LegendPosition.ABOVE_CHART_RIGHT);
        XAxis xAxis = mBarchart.getXAxis();
        xAxis.setTextSize(15);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);


        return view;
    }

    private void initView(View view) {
        mBarchart = (BarChart) view.findViewById(R.id.Barchart);
        s = new String[]{"90后", "80后", "70后", "60后", "50后",};
    }


    @Override
    public void onPause() {
        super.onPause();
        barData.clearValues();
        barDataSet.clear();
        mBarchart.clear();
    }
}
