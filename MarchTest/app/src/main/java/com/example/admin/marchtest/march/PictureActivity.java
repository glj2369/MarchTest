package com.example.admin.marchtest.march;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toolbar;

import com.example.admin.marchtest.MarchUtil.Ima;
import com.example.admin.marchtest.R;

import java.io.Serializable;

public class PictureActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //requestWindowFeature(Window.FEATURE_NO_TITLE);// 隐藏标题
       getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);// 设置全屏
        setContentView(R.layout.activity_picture);
       // View view = LayoutInflater.from(this).inflate(R.layout.app_bar_main, null);
        //android.support.v7.widget.Toolbar tool = view.findViewById(R.id.toolbar);
        //AppBarLayout barLayout = view.findViewById(R.id.appBar);
        //tool.setVisibility(View.GONE);
        //barLayout.setVisibility(View.GONE);




    }


}
