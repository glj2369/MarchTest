package com.example.admin.test;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.admin.test.Adapter.test7Adapter;
import com.example.admin.test.test7Fragment.fiveFragment;
import com.example.admin.test.test7Fragment.fourFragment;
import com.example.admin.test.test7Fragment.oneFragment;
import com.example.admin.test.test7Fragment.sevenFragment;
import com.example.admin.test.test7Fragment.sixFragment;
import com.example.admin.test.test7Fragment.threeFragment;
import com.example.admin.test.test7Fragment.twoFragment;

public class Test7Activity extends AppCompatActivity {

    private ViewPager mTest7ViewPager;
    private ImageView mTest7P1;
    private ImageView mTest7P2;
    private ImageView mTest7P3;
    private ImageView mTest7P4;
    private ImageView mTest7P5;
    private ImageView mTest7P6;
    private ImageView mTest7P7;
    private Fragment[] fragments = {new oneFragment(), new twoFragment(), new threeFragment(), new fourFragment(), new fiveFragment(), new sixFragment(), new sevenFragment(),};
    private ImageView[] imageViews ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test7);
        initView();
        test7Adapter adapter = new test7Adapter(getSupportFragmentManager(), fragments);
        mTest7ViewPager.setAdapter(adapter);
        mTest7ViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                pic(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void pic(int position) {
        for (ImageView imageView : imageViews) {
            imageView.setImageResource(R.drawable.ic_action_stop);
        }
        imageViews[position].setImageResource(R.drawable.ic_action_run);
    }

    private void initView() {
        mTest7ViewPager = (ViewPager) findViewById(R.id.test7_viewPager);
        mTest7P1 = (ImageView) findViewById(R.id.test7_p1);
        mTest7P2 = (ImageView) findViewById(R.id.test7_p2);
        mTest7P3 = (ImageView) findViewById(R.id.test7_p3);
        mTest7P4 = (ImageView) findViewById(R.id.test7_p4);
        mTest7P5 = (ImageView) findViewById(R.id.test7_p5);
        mTest7P6 = (ImageView) findViewById(R.id.test7_p6);
        mTest7P7 = (ImageView) findViewById(R.id.test7_p7);
        imageViews =new ImageView[] {mTest7P1, mTest7P2, mTest7P3, mTest7P4, mTest7P5, mTest7P6, mTest7P7};

    }
}
