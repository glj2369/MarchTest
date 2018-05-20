package com.example.mpchart215test;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TabHost;

import com.example.mpchart215test.Fragment.TabFragment1;
import com.example.mpchart215test.Fragment.TabFragment2;

public class fx2Activity extends AppCompatActivity {

    private FragmentTabHost mTabhost;
    private FrameLayout mFxTab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fx2);
        initView();
        mTabhost.setup(this, getSupportFragmentManager(), R.id.fx_tab);
        mTabhost.addTab(mTabhost.newTabSpec("1").setIndicator("1"), TabFragment1.class, null);
        mTabhost.addTab(mTabhost.newTabSpec("2").setIndicator("2"), TabFragment2.class, null);
        mTabhost.getTabWidget().getChildAt(0).setBackgroundColor(Color.GREEN);
        mTabhost.getTabWidget().getChildAt(1).setBackgroundColor(Color.YELLOW);
        mTabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for (int i = 0; i < mTabhost.getTabWidget().getTabCount(); i++) {
                    View view = mTabhost.getTabWidget().getChildAt(i);
                    if (mTabhost.getCurrentTab() == i) {
                        view.setBackgroundColor(Color.GREEN);
                    } else {
                        view.setBackgroundColor(Color.YELLOW);
                    }
                }
            }
        });
    }

    private void initView() {
        mTabhost = (FragmentTabHost) findViewById(R.id.tabhost);
        mFxTab = (FrameLayout) findViewById(R.id.fx_tab);
    }
}
