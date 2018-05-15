package com.example.admin.marchtest.march.En_Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.marchtest.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class LightFragment extends Fragment {


    private View view;
    private LineChart mLightChart;
    private LineData lineData;
    private LineDataSet lineDataSet;
    private ArrayList<Entry> entries = new ArrayList<>();
    private ArrayList<ILineDataSet> iLineDataSets = new ArrayList<>();

    public LightFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_light, container, false);
        Ran();
        initView(view);
        lineDataSet = new LineDataSet(entries, "(秒)");
        iLineDataSets.add(lineDataSet);
        lineDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        lineDataSet.setCircleColors(ColorTemplate.JOYFUL_COLORS);
        lineData = new LineData(iLineDataSets);
        XAxis xAxis = mLightChart.getXAxis();
        xAxis.setDrawGridLines(false);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
       // xAxis.setAxisMinValue(3);
        xAxis.setSpaceMin(1);
        xAxis.setLabelCount(5);
        mLightChart.getAxisRight().setEnabled(false);
        mLightChart.getAxisLeft().setDrawGridLines(false);
        mLightChart.getLegend().setEnabled(false);
        mLightChart.setData(lineData);
        mLightChart.getDescription().setText("(秒)");
        return view;
    }

    private void initView(View view) {
        mLightChart = (LineChart) view.findViewById(R.id.light_chart);
    }

    private void Ran() {
        for (int i = 1; i < 6; i++) {

            entries.add(new Entry(i * 3, new Random().nextInt(2000)));

        }
    }

    @Override
    public void onPause() {
        super.onPause();
        mLightChart.clear();
        lineData.clearValues();

        lineDataSet.clear();
    }
}
