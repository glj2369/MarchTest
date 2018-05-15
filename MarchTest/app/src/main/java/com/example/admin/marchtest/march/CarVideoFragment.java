package com.example.admin.marchtest.march;


import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTabHost;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.marchtest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarVideoFragment extends Fragment {
    private TextView title;
    private FragmentTabHost fragmentTabHost;
    private View view;

    public CarVideoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_car_video, container, false);
        fragmentTabHost = view.findViewById(android.R.id.tabhost);
        title=view.findViewById(R.id.title);
        title.setText("车辆违章");
        fragmentTabHost.setup(getActivity(), getChildFragmentManager(), R.id.flayout_content);
        TabHost.TabSpec video = fragmentTabHost.newTabSpec("违章视频").setIndicator("违章视频");
        fragmentTabHost.addTab(video, VideFragment.class, null);
        TabHost.TabSpec picture = fragmentTabHost.newTabSpec("违章图片").setIndicator("违章图片");
        fragmentTabHost.addTab(picture, PictureFragment.class, null);
        fragmentTabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                Toast.makeText(getActivity(),tabId, Toast.LENGTH_SHORT).show();
                for (int i=0;i<fragmentTabHost.getTabWidget().getTabCount();i++){
                    View view = fragmentTabHost.getTabWidget().getChildAt(i);
                    if(fragmentTabHost.getCurrentTab()==i){
                        view.setBackgroundColor(-16728065);

                    }else {view.setBackgroundColor(Color.WHITE);

                    }
                }
            }
        });

        return view;
    }

}
