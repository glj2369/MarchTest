package com.example.admin.test.test7Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.test.R;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class oneFragment extends Fragment {


    private View view;
    private PieChart mPiechart;
    private PieDataSet pieDataSet;
    private PieData pieData;
    private String string[];
    private ArrayList<Entry> entries = new ArrayList<>();

    public oneFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_one, container, false);
        initView(view);
        entries.add(new Entry(71.3f, 0));
        entries.add(new Entry(28.6f, 1));
        pieDataSet = new PieDataSet(entries, "");
        pieDataSet.setValueFormatter(new PercentFormatter());
        pieDataSet.setValueTextSize(20);
        pieDataSet.setSliceSpace(4);
        pieDataSet.setSelectionShift(2);
        pieDataSet.setColors(ColorTemplate.JOYFUL_COLORS);
        pieData = new PieData(string, pieDataSet);
        mPiechart.setData(pieData);
        mPiechart.setDrawHoleEnabled(false);
        mPiechart.setDescription("");
        mPiechart.getLegend().setPosition(Legend.LegendPosition.BELOW_CHART_CENTER);
        return view;
    }

    private void initView(View view) {
        mPiechart = (PieChart) view.findViewById(R.id.piechart);
        string = new String[]{"有违章", "无违章"};
    }
    @Override
    public void onPause() {
        super.onPause();
        pieData.clearValues();
        pieDataSet.clear();
        mPiechart.clear();
    }
}
