package com.example.mpchart215test.Fragment;


import android.app.Notification;
import android.app.NotificationManager;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.NotificationCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

import com.example.mpchart215test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TabFragment1 extends Fragment implements View.OnClickListener {

    private boolean i = true;
    private View view;
    private Button mStart;
    private Switch mSwitchTest;
    /**
     * 系统通知
     */
    private Button mNoti;
    /**
     * 禁用
     */
    private Button mJy;

    public TabFragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_tab_fragment1, container, false);
        initView(view);
        mSwitchTest.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(getActivity(), "被点击", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getActivity(), "取消点击", Toast.LENGTH_SHORT).show();
                }
            }
        });

        return view;
    }

    private void initView(View view) {
        mStart = (Button) view.findViewById(R.id.start);
        mStart.setOnClickListener(this);
        mSwitchTest = (Switch) view.findViewById(R.id.switchTest);
        mNoti = (Button) view.findViewById(R.id.noti);
        mNoti.setOnClickListener(this);
        mJy = (Button) view.findViewById(R.id.stop);
        mJy.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.start:
                ProgressDialog progressDialog = new ProgressDialog(getContext());
                progressDialog.setTitle("加载中。。。");
                progressDialog.setMessage("等待吧^_^");
                progressDialog.setCancelable(true);
                progressDialog.show();
                break;
            case R.id.noti:
                NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
                Notification on = new NotificationCompat.Builder(getContext())
                        .setContentTitle("标题")
                        .setContentText("十年生死两茫茫")
                        .setSmallIcon(R.drawable.logo1)
                        .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.drawable.circle2))
                        .build();
                manager.notify(1, on);


                break;
            case R.id.stop:
                if (i) {
                    mSwitchTest.setClickable(false);
                    Toast.makeText(getActivity(), "禁用", Toast.LENGTH_SHORT).show();
                    i = false;
                } else {
                    mSwitchTest.setClickable(true);
                    Toast.makeText(getActivity(), "启用", Toast.LENGTH_SHORT).show();
                    i = true;
                }

                break;
        }
    }
}
