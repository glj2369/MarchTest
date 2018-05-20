package com.example.mpchart215test.Fragment;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TabHost;

import com.example.mpchart215test.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentTabHostFragment extends Fragment {


    private View view;
    private FragmentTabHost mTabhost;
    private FrameLayout mFraLayout;

    public FragmentTabHostFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_fragment_tab_host, container, false);
        initView(view);

        mTabhost.setup(getContext(), getChildFragmentManager(), R.id.fra_layout);
        mTabhost.addTab(mTabhost.newTabSpec("一号").setIndicator("一号"), TabFragment1.class, null);
        mTabhost.addTab(mTabhost.newTabSpec("二号").setIndicator("二号"), TabFragment2.class, null);
        mTabhost.getTabWidget().getChildAt(0).setBackgroundColor(Color.GREEN);
        mTabhost.getTabWidget().getChildAt(1).setBackgroundColor(Color.YELLOW);
        //mTabhost.setSelected(true);
        mTabhost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                for (int i = 0; i < mTabhost.getTabWidget().getTabCount(); i++) {
                    View at = mTabhost.getTabWidget().getChildAt(i);
                    if (mTabhost.getCurrentTab() == i) {
                        at.setBackgroundColor(Color.GREEN);
                    } else {
                        at.setBackgroundColor(Color.YELLOW);
                    }
                }


            }
        });
        return view;
    }

    private void initView(View view) {
        mTabhost = (FragmentTabHost) view.findViewById(R.id.tabhost);
        mFraLayout = (FrameLayout) view.findViewById(R.id.fra_layout);
    }
}
