package com.example.admin.marchtest.MPchart;


import android.graphics.Matrix;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.example.admin.marchtest.R;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.AxisBase;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IAxisValueFormatter;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.utils.ColorTemplate;

import java.util.ArrayList;
import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 */
public class LineChartFragment extends Fragment implements View.OnClickListener {
    private LineChart chart;
    private LineData data;
    private String[] xVals = new String[12];
    private LineDataSet dataSet;
    private ArrayList<Entry> yVals;
    private Random random;
    private View view;
    private Button mfl;

    public LineChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_line_chart, container, false);
        // Inflate the layout for this fragment
        initview();

        //解决定义x轴值的valuebug。
        // chart.setScaleMinima(1.0f, 1.0f);
        // chart.getViewPortHandler().refresh(new Matrix(), chart, true);


        yVals = new ArrayList<>();
        random = new Random();
        Random();
        ArrayList<ILineDataSet> arr = new ArrayList<ILineDataSet>();

        dataSet = new LineDataSet(yVals, "公司年度利润");
        dataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        arr.add(dataSet);
        data = new LineData(arr);
        chart.setData(data);

        //3.0失效
        //chart.setDescription ("公司年度利润");
        chart.getDescription().setText("公司年度利润");


        //3.0设置x，y轴描述文字使用IAxisValueFormatter
        XAxis xAxis = chart.getXAxis();


        xAxis.setLabelCount(4);//标签数量
        chart.setVisibleXRangeMaximum(4);//一屏显示点的数量
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);//x轴位置
        IAxisValueFormatter iAxisValueFormatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                //  Toast.makeText(getActivity(), value+"", Toast.LENGTH_SHORT).show();
                //解决可能的越界问题
                int in = (int) value;
                if (in < 0 || in > xVals.length) {//集合判断.size()
                    return "";
                } else {
                    return xVals[(int) value];
                }

            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        };

        xAxis.setValueFormatter(iAxisValueFormatter);
        //xAxis.setGranularity(0.3f);//x轴描述为数组添加此行。

        chart.animateY(3000);

        return view;
    }

    private void Random() {
        for (int i = 0; i < 12; i++) {
            float profix = random.nextInt(12) + 1;
            yVals.add(new Entry(i, profix));
            xVals[i] = (i + 1) + "月";
            // Toast.makeText(getActivity(), xVals[11], Toast.LENGTH_SHORT).show();


        }
    }

    private void initview() {
        chart = view.findViewById(R.id.lineChart);
        mfl = view.findViewById(R.id.fl);
        mfl.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        //chart.notifyDataSetChanged();
        dataSet.clear();//清理折线图数据，否则滑动时数据发生叠加。这里·清理点的集合数据。不是最后的data。
        Random();
        chart.invalidate();// 如果在非UI主线程中，需要调用postInvalidate()
        chart.animateXY(2000,2000);

    }
}
