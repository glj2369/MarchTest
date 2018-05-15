package com.example.admin.marchtest.march;


import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.marchtest.R;
import com.example.admin.marchtest.RoadLight;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class RoadFragment extends Fragment implements View.OnClickListener {

    private TextView mtitle;
    private View view;
    /**
     * 环城快速路
     */
    private TextView mHcks2;
    /**
     * 环城快速路
     */
    private TextView mHcks1;
    /**
     * 学院路
     */
    private TextView mXyl;
    /**
     * 联想路
     */
    private TextView mLxl;
    /**
     * 幸福路
     */
    private TextView mXfl;
    /**
     * 医院路
     */
    private TextView mYyl;
    /**
     * 停车场
     */
    private TextView mCarPark;
    /**
     * 环城高速
     */
    private TextView mHcgs;
    /**
     * 环城快速路
     */
    private TextView mHcks3;
    /**
     * 2017_6-7
     */
    private TextView mTime1;
    /**
     * 星期三
     */
    private TextView mTimeweek;
    /**
     * 温度：17 ℃
     */
    private TextView mTemp;
    /**
     * 相对湿度：58%
     */
    private TextView mXdsd;
    /**
     * PM2.5:29μg/m³
     */
    private TextView mPm25;
    private Button mFlu;
    int[] color;
    private TextView[] road;
    private String w;
    private Timer timer;
    private ImageView mRoadLight;

    public RoadFragment() {
        // Required empty public constructor
    }

    private int i = 0;
    private int light[] = new int[]{R.drawable.red, R.drawable.yellow, R.drawable.green};

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 1:
                    setRoad();
                    Drawable background = mHcks1.getBackground();
                    ColorDrawable colorDrawable = (ColorDrawable) background;
                    int color = colorDrawable.getColor();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                        mHcks2.setBackgroundColor(color);
                        mHcks3.setBackgroundColor(color);
                    }
                    break;
                case 2:
                    int a = i%3;
                    mRoadLight.setImageResource(
                            light[a]);
                    break;
                default:
                    break;
            }
        }
    };


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_road, container, false);
        initView(view);
        road = new TextView[]{mXyl, mLxl, mYyl, mXfl, mHcks1, mHcgs, mCarPark};
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                RanRoad();

                Message message = new Message();
                message.what = 1;
                handler.sendMessage(message);

            }
        };

        TimerTask timerTask1 = new TimerTask() {
            @Override
            public void run() {

                Message message = new Message();
                message.what = 2;
                handler.sendMessage(message);

                i++;
                if (i == 12) {
                    i = 0;

                }

            }
        };
        timer.schedule(timerTask, 1000, 3000);
        timer.schedule(timerTask1, 1000, 1000);


        RanSetWeather();
        String simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
        int week = new Date().getDay();

        if (week == 0) {
            w = "星期日";
        } else if (week == 1) {
            w = "星期一";
        } else if (week == 2) {
            w = "星期二";
        } else if (week == 3) {
            w = "星期三";
        } else if (week == 4) {
            w = "星期四";
        } else if (week == 5) {
            w = "星期五";
        } else if (week == 6) {
            w = "星期六";
        }

        mTime1.setText(simpleDateFormat);
        mTimeweek.setText(w);
        //Toast.makeText(getContext(), simpleDateFormat, Toast.LENGTH_SHORT).show();
        return view;
    }

    private void RanSetWeather() {
        Random random = new Random();
        int tmp = random.nextInt(30) + 1;
        int pm = random.nextInt(40) + 1;
        int sd = random.nextInt(100) + 1;
        mTemp.setText("温度：" + tmp + "℃");
        mPm25.setText("PM2.5:" + pm + "μg/m³");
        mXdsd.setText("相对湿度：" + sd + "%");
    }

    private void setRoad() {
        for (int i = 0; i < 7; i++) {
            TextView view = road[i];
            SetColor(view, i);
        }
    }

    private void SetColor(TextView view, int i) {
        if (color[i] == 1) {
            view.setBackgroundColor(Color.parseColor("#6ab82e"));
        } else if (color[i] == 2) {
            view.setBackgroundColor(Color.parseColor("#ece93a"));
        } else if (color[i] == 3) {
            view.setBackgroundColor(Color.parseColor("#f49b25"));
        } else if (color[i] == 4) {
            view.setBackgroundColor(Color.parseColor("#e33532"));
        } else if (color[i] == 5) {
            view.setBackgroundColor(Color.parseColor("#b01e23"));
        }
    }


    private void initView(View view) {
        mHcks2 = (TextView) view.findViewById(R.id.hcks2);
        mHcks1 = (TextView) view.findViewById(R.id.hcks1);
        mXyl = (TextView) view.findViewById(R.id.xyl);
        mLxl = (TextView) view.findViewById(R.id.lxl);
        mXfl = (TextView) view.findViewById(R.id.xfl);
        mYyl = (TextView) view.findViewById(R.id.yyl);
        mCarPark = (TextView) view.findViewById(R.id.car_park);
        mHcgs = (TextView) view.findViewById(R.id.hcgs);
        mHcks3 = (TextView) view.findViewById(R.id.hcks3);
        mTime1 = (TextView) view.findViewById(R.id.time1);
        mTimeweek = (TextView) view.findViewById(R.id.timeweek);
        mTemp = (TextView) view.findViewById(R.id.temp);
        mXdsd = (TextView) view.findViewById(R.id.xdsd);
        mPm25 = (TextView) view.findViewById(R.id.pm25);
        mFlu = (Button) view.findViewById(R.id.flu);
        mFlu.setOnClickListener(this);
        mtitle = view.findViewById(R.id.title);
        mtitle.setText("路况查询");
        mRoadLight = (ImageView) view.findViewById(R.id.road_light);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.flu:
                RanSetWeather();
                break;
        }
    }

    private void RanRoad() {
        Random random = new Random();
        color = new int[7];
        for (int i = 0; i < 7; i++) {
            int r = random.nextInt(5) + 1;
            color[i] = r;

        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        timer.cancel();

    }
}
