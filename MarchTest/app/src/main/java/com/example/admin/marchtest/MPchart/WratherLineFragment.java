package com.example.admin.marchtest.MPchart;


import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.marchtest.GSON.Weather;
import com.example.admin.marchtest.HttpUtil.Okhttp;
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
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import okhttp3.internal.Util;

/**
 * A simple {@link Fragment} subclass.
 */
public class WratherLineFragment extends Fragment implements View.OnClickListener {
    private View view;
    private Button re;
    private LineChart lineChart;
    private String[] XV;
    private ArrayList<Entry> YV = new ArrayList<Entry>();
    private LineDataSet lineDataSet;
    private LineData lineData;
    private ArrayList<ILineDataSet> data = new ArrayList<ILineDataSet>();
    private TextView mshow;
    private String string = "";
    private String loc;
    private Button nullBt;
    private String[] test;
    private Button newTestBt;
    private Button ZSTestBt;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public WratherLineFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_wrather_line, container, false);
        initView();
        try {


            Post();
            test = new String[]{"1", "2"};
        } catch (IOException e) {

        }

        // Inflate the layout for this fragment
        return view;
    }

    private void Post() throws IOException {
        Okhttp.conn("https://free-api.heweather.com/s6/weather/forecast?location=auto_ip&key=3c591beff19d4801946767a77c5a7cd5", new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "请求失败", Toast.LENGTH_SHORT).show();

                        Toast.makeText(getActivity(), e.toString(), Toast.LENGTH_SHORT).show();

                    }
                });

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                string = response.body().string();
                Par();
                UPLine();

                    /*JSONObject jsonObject = new JSONObject(string);
                    JSONArray jsonArray = jsonObject.getJSONArray("HeWeather6");*/
                // JsonObject jsonObject = new JsonParser().parse(string).getAsJsonObject();
                //final JsonArray jsonArray = jsonObject.getAsJsonArray("HeWeather6");
                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getActivity(), "数据更新完成！", Toast.LENGTH_SHORT).show();
                        mshow.setText("最近更新：" + loc);
                    }
                });


            }
        });
    }

    private void Par() {
        // JsonObject jsonObject1 = jsonArray.getAsJsonObject();
        Gson gson = new Gson();
        ;
        // JsonArray daily_forecast1 = jsonObject1.getAsJsonArray("daily_forecast");
        Weather weather = gson.fromJson(string, Weather.class);
        if (string == null) {
            Toast.makeText(getActivity(), "kong   strinng", Toast.LENGTH_SHORT).show();
        }
        if (weather == null) {
            Log.e("WratherLineFragment", string);
            Log.e("WratherLineFragment", "weather 为空！！！");
        }
        Log.e("WratherLineFragment", weather.toString());

        List<Weather.HeWeather6Bean> heWeather6 = weather.getHeWeather6();
        // List<Weather.HeWeather6Bean> heWeather6Bean = gson.fromJson(jsonArray.toString(), new TypeToken<Weather.HeWeather6Bean>() {}.getType());
        Weather.HeWeather6Bean heWeather6Bean1 = heWeather6.get(0);
        Weather.HeWeather6Bean.UpdateBean update = heWeather6Bean1.getUpdate();
        loc = update.getLoc();
        List<Weather.HeWeather6Bean.DailyForecastBean> daily_forecast = heWeather6Bean1.getDaily_forecast();
        XV = new String[daily_forecast.size()];
        for (int i = 0; i < daily_forecast.size(); i++) {
            Weather.HeWeather6Bean.DailyForecastBean dailyForecastBean = daily_forecast.get(i);
            String date = dailyForecastBean.getDate();
            int tmp_min = Integer.parseInt(dailyForecastBean.getTmp_min());
            YV.add(new Entry(i, tmp_min));
            XV[i] = date;

        }

    }

    private void UPLine() {
        lineDataSet = new LineDataSet(YV, "本地最低温度曲线");
        lineDataSet.setColors(ColorTemplate.COLORFUL_COLORS);
        data.add(lineDataSet);
        lineData = new LineData(data);
        lineChart.setData(lineData);
        lineChart.getDescription().setText("本地最低温度变化曲线");


        XAxis xAxis = lineChart.getXAxis();
        IAxisValueFormatter iAxisValueFormatter = new IAxisValueFormatter() {
            @Override
            public String getFormattedValue(float value, AxisBase axis) {
                int in = (int) value;


                if (in < 0 || in > XV.length) {
                    return "";
                } else {
                    return XV[(int) value];
                }


            }

            @Override
            public int getDecimalDigits() {
                return 0;
            }
        };
        xAxis.setValueFormatter(iAxisValueFormatter);
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                lineChart.animateXY(3000, 3000);
            }
        });

        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setLabelRotationAngle(20);
        xAxis.setLabelCount(2);
        lineChart.setDragEnabled(true);
        lineChart.setGridBackgroundColor(Color.YELLOW);
        //lineChart.setVisibleXRangeMaximum(4);

    }

    private void initView() {
        re = view.findViewById(R.id.re_weather);
        lineChart = view.findViewById(R.id.weather_line);
        mshow = view.findViewById(R.id.show);
        nullBt = view.findViewById(R.id.null_weather);
        re.setOnClickListener(this);
        nullBt.setOnClickListener(this);
        newTestBt = view.findViewById(R.id.test_weather);
        newTestBt.setOnClickListener(this);
        ZSTestBt = view.findViewById(R.id.ZStest_weather);
        ZSTestBt.setOnClickListener(this);

    }

    private void newTest() {
        Random random = new Random();
        test = new String[random.nextInt(5) + 1];
        for (int i = 0; i < test.length; i++) {
            test[i] = random.nextInt(10) + 1 + "";
        }
        Toast.makeText(getActivity(), "重新new 出test成功！！", Toast.LENGTH_SHORT).show();
    }

    private void zxTest() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : test) {
            stringBuilder.append(s);

        }
        Toast.makeText(getActivity(), stringBuilder, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.re_weather:

                //XV = null;//防止重复开辟数组空间
                // lineChart.clear();

                lineDataSet.clear();
                lineData.clearValues();
                try {

                    Post();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                lineChart.invalidate();
                lineChart.notifyDataSetChanged();
                break;
            case R.id.null_weather:
                if (lineDataSet != null && lineData != null && XV != null) {
                    Toast.makeText(getActivity(), "lineDataSet,lineData,XV不为空！", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.test_weather:
                newTest();
            case R.id.ZStest_weather:
                zxTest();
                break;
            default:
                break;
        }


    }
}
