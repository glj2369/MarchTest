package com.example.admin.marchtest;



import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.admin.marchtest.MPchart.BarChartFragment;
import com.example.admin.marchtest.MPchart.HorBarChartFragment;
import com.example.admin.marchtest.MPchart.LineChartFragment;
import com.example.admin.marchtest.MPchart.PieChartFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class MpChartFragment extends Fragment implements View.OnClickListener {


    private View view;
    private Button btn_linechart;
    private Button btn_barchart, btn_horizonalbarchart;
    private Button btn_combinedchart;
    private Button btn_piechart;
    private Button btn_scatterchart;
    private Button btn_candlechart;
    private Button btn_radarchart;
    MainActivity mainActivity;


    public MpChartFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_mp_chart, container, false);
        initView();
        // Inflate the layout for this fragment
        return view;
    }

    private void initView() {

        btn_linechart = (Button) view.findViewById(R.id.btn_linechart);
        btn_barchart = (Button) view.findViewById(R.id.btn_barchart);
        btn_horizonalbarchart = (Button) view.findViewById(R.id.btn_horizontalchart);

        btn_combinedchart = (Button) view.findViewById(R.id.btn_combinedchart);

        btn_piechart = (Button) view.findViewById(R.id.btn_piechart);
        btn_scatterchart = (Button) view.findViewById(R.id.btn_scatterchart);
        btn_candlechart = (Button) view.findViewById(R.id.btn_candlechart);
        btn_radarchart = (Button) view.findViewById(R.id.btn_radarchart);

        btn_linechart.setOnClickListener(this);

        btn_barchart.setOnClickListener(this);
        btn_horizonalbarchart.setOnClickListener(this);
        btn_combinedchart.setOnClickListener(this);
        btn_piechart.setOnClickListener(this);
        btn_scatterchart.setOnClickListener(this);
        btn_candlechart.setOnClickListener(this);
        btn_radarchart.setOnClickListener(this);
         mainActivity= (MainActivity) getActivity();
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.btn_linechart:
                mainActivity.replace(new LineChartFragment());

                //Toast.makeText(activity, "nononoon", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_barchart:
                mainActivity.replace(new BarChartFragment());
                break;
            case R.id.btn_horizontalchart:
                mainActivity.replace(new HorBarChartFragment());
                break;
            case R.id.btn_combinedchart:

                break;
            case R.id.btn_piechart:
                mainActivity.replace(new PieChartFragment());
                break;
            case R.id.btn_scatterchart:

                break;
            case R.id.btn_candlechart:

                break;
            case R.id.btn_radarchart:

                break;
        }


    }

}
