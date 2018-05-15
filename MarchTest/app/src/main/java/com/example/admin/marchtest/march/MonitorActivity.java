package com.example.admin.marchtest.march;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.admin.marchtest.MarchUtil.ScImageView;
import com.example.admin.marchtest.R;

public class MonitorActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout mLayout;
    private FrameLayout mCarWzFrame;
    /**
     * 返回
     */
    private Button mCarReturn;
    private ImageView mImg1;
    private ImageView mImg2;
    private ImageView mImg3;
    private ImageView mImg4;
    private ScImageView mCarWzPic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_monitor);
        initView();
    }

    @SuppressLint("WrongViewCast")
    private void initView() {
        mLayout = (LinearLayout) findViewById(R.id.layout);
        mCarWzPic = (ScImageView) findViewById(R.id.scpic);
        mCarWzFrame = findViewById(R.id.car_wz_frame);
        mCarReturn = (Button) findViewById(R.id.car_return);
        mCarReturn.setOnClickListener(this);
        mImg1 = (ImageView) findViewById(R.id.img1);
        mImg2 = (ImageView) findViewById(R.id.img2);
        mImg3 = (ImageView) findViewById(R.id.img3);
        mImg4 = (ImageView) findViewById(R.id.img4);
        mLayout.setOnClickListener(this);
        mCarWzPic.setOnClickListener(this);
        mCarWzFrame.setOnClickListener(this);
        mImg1.setOnClickListener(this);
        mImg2.setOnClickListener(this);
        mImg3.setOnClickListener(this);
        mImg4.setOnClickListener(this);
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.car_return:

                Intent intent = new Intent(this, CarWZQueryActivity.class);
                setResult(1, intent);
                finish();
                //startActivity(intent);

                break;
            case R.id.layout:
                break;
            case R.id.car_wz_frame:
                break;
            case R.id.img1:
                Drawable drawable = mImg1.getDrawable();
                /**
                 * 代码加载布局方法
                 */
                /*
                ScImageView scImageView = new ScImageView(this);
                scImageView.setImageDrawable(drawable);
                scImageView.setMaxHeight(FrameLayout.LayoutParams.MATCH_PARENT);
                scImageView.setMaxWidth(FrameLayout.LayoutParams.MATCH_PARENT);
                  mCarWzFrame.addView(scImageView);
                */
                mLayout.setVisibility(View.GONE);
                mCarWzFrame.setVisibility(View.VISIBLE);
                mCarWzPic.setImageDrawable(drawable);
                break;
            case R.id.img2:
                mLayout.setVisibility(View.GONE);
                mCarWzFrame.setVisibility(View.VISIBLE);
                Drawable drawable2 = mImg2.getDrawable();
                mCarWzPic.setImageDrawable(drawable2);
                break;
            case R.id.img3:
                mLayout.setVisibility(View.GONE);
                mCarWzFrame.setVisibility(View.VISIBLE);
                Drawable drawable3 = mImg3.getDrawable();
                mCarWzPic.setImageDrawable(drawable3);
                break;
            case R.id.img4:
                mLayout.setVisibility(View.GONE);
                mCarWzFrame.setVisibility(View.VISIBLE);

                Drawable drawable4 = mImg4.getDrawable();
                Toast.makeText(this, drawable4.toString(), Toast.LENGTH_SHORT).show();
                mCarWzPic.setImageDrawable(drawable4);
                break;
        }
    }
}
