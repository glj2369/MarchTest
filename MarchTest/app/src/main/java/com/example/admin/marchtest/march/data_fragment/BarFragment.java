package com.example.admin.marchtest.march.data_fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

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
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class BarFragment extends Fragment {


    private View view;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    private BarChart mCarBar;
    private ArrayList<BarEntry> entries=new ArrayList<>();
    private BarDataSet barDataSet;
    private BarData barData;
    private ArrayList<IBarDataSet> iBarDataSets=new ArrayList<>();
    private String [] s;

    public BarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bar, container, false);
        initView(view);
        Ran();
        barDataSet=new BarDataSet(entries,"");
        barDataSet.setStackLabels(new String[]{"有违章","无违章"});//设置堆叠标签
        barDataSet.setColors(Color.parseColor("#32CD32"),Color.parseColor("#FF8C00"));
        IAxisValueFormatter iAxisValueFormatter=new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                return null;
            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        };
        barDataSet.setValueFormatter(new PercentFormatter());
        barDataSet.setValueTextColor(Color.parseColor("#FF0000"));
        iBarDataSets.add(barDataSet);
        barData=new BarData(iBarDataSets);
        mCarBar.setData(barData);

        XAxis xAxis = mCarBar.getXAxis();
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
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setDrawGridLines(false);
        mCarBar.getAxisRight().setEnabled(false);
        mCarBar.getLegend().setPosition(Legend.LegendPosition.RIGHT_OF_CHART);
       // mCarBar.getLegend().setEnabled(false);
        mCarBar.getDescription().setEnabled(false);
        Toast.makeText(getActivity(), "创建！！", Toast.LENGTH_SHORT).show();
        return view;
    }

    private void Ran() {
        entries.add(new BarEntry(1,new float[]{6,4}));
        entries.add(new BarEntry(2,new float[]{10,20}));
        entries.add(new BarEntry(3,new float[]{10,5}));
        entries.add(new BarEntry(4,new float[]{20,5}));
        entries.add(new BarEntry(5,new float[]{3,17}));
    s=new String[]{"90后","80后","70后","60后","50后",};
    }

    private void initView(View view) {
        mTitle = (TextView) view.findViewById(R.id.title);
        mCarBar = (BarChart) view.findViewById(R.id.car_bar);
        mTitle.setText("数据分析");
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getActivity(), "pause!!!", Toast.LENGTH_SHORT).show();
        mCarBar.clear();
        barData.clearValues();
        barDataSet.clear();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getActivity(), "destory", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getActivity(), "Resuume", Toast.LENGTH_SHORT).show();
    }
}
