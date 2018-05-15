package com.example.admin.marchtest.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import java.util.List;

public class MyViewPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> mFragments;

    //修改构造方法
    public MyViewPagerAdapter(FragmentManager fm, List<Fragment> mFragments) {
        super(fm);
        this.mFragments = mFragments;
    }

    //必须实现, 显示多少个页面
    @Override
    public int getCount() {
        return mFragments.size();
    }


    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }



}
