package com.example.admin.marchtest.march.data_fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.marchtest.R;
import com.github.mikephil.charting.charts.HorizontalBarChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.interfaces.datasets.IBarDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class TraHorBarFragment extends Fragment {


    private View view;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    private HorizontalBarChart mCarTraHorBar;
    private BarData barData;
    private BarDataSet barDataSet;
    private ArrayList<BarEntry> entries=new ArrayList<>();
    private String [] s;
    private ArrayList<IBarDataSet> iBarDataSets=new ArrayList<>();

    public TraHorBarFragment() {
        // Required empty public constructor
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_tra_hor_bar, container, false);
        initView(view);
        Ran();
        s=new String[]{"机动车逆向行驶","违规使用专用车道","违反禁令标志指示","不按规定系安全带","机动车不走机动车道","违反信号灯规定","违反禁止标线指示","违规停车拒绝驶离","违规驶入导向车道", "超速行驶"};

        barDataSet=new BarDataSet(entries,"");
        barDataSet.setValueFormatter(new PercentFormatter());
        barDataSet.setValueTextSize(20);
        barDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        iBarDataSets.add(barDataSet);
        barData=new BarData(iBarDataSets);
        mCarTraHorBar.setData(barData);
        mCarTraHorBar.setDrawValueAboveBar(true);
        XAxis xAxis = mCarTraHorBar.getXAxis();
        xAxis.setDrawGridLines(false);
        mCarTraHorBar.getAxisLeft().setEnabled(false);
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
        xAxis.setLabelCount(8);
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        mCarTraHorBar.getAxisRight().setValueFormatter(new PercentFormatter());
        mCarTraHorBar.setDrawValueAboveBar(true);
        mCarTraHorBar.getAxisLeft().setEnabled(false);
        mCarTraHorBar.getLegend().setEnabled(false);
        mCarTraHorBar.getDescription().setEnabled(false);//顶点值消失
        mCarTraHorBar.setScaleEnabled(true);
        mCarTraHorBar.setScaleY(0.7F);
       mCarTraHorBar.setVisibleXRangeMaximum(8);
        return view;
    }

    private void Ran() {
        Random random=new Random();
        for (int i=0;i<10;i++){
            int a = random.nextInt(30) + 1;
            entries.add(new BarEntry(i,a));
        }
    }

    private void initView(View view) {
        mTitle = (TextView) view.findViewById(R.id.title);
        mCarTraHorBar = (HorizontalBarChart) view.findViewById(R.id.car_Tra_Hor_Bar);
        mTitle.setText("数据分析");
    }

    @Override
    public void onPause() {
        super.onPause();
        mCarTraHorBar.clear();
        barDataSet.clear();
        barData.clearValues();
    }
}
