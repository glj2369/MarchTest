package com.example.admin.marchtest.march;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.marchtest.R;
import com.example.admin.marchtest.adapter.MyViewPagerAdapter;
import com.example.admin.marchtest.march.En_Fragment.AirFragment;
import com.example.admin.marchtest.march.En_Fragment.LightFragment;
import com.example.admin.marchtest.march.En_Fragment.Pm25Fragment;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class EnvFragment extends Fragment {


    private View view;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    private ViewPager mEnVp;
    private List<Fragment> list=new ArrayList<>();
    private Fragment[] f;
    private ImageView mCarPage1;
    private ImageView mCarPage2;
    private ImageView mCarPage3;
    private ImageView[] im = new ImageView[3];

    public EnvFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_env, container, false);
        initView(view);
        f = new Fragment[]{new Pm25Fragment(), new AirFragment(), new LightFragment()};
        for (Fragment fragment : f) {
            list.add(fragment);
        }
        MyViewPagerAdapter viewPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager(), list);
        mEnVp.setAdapter(viewPagerAdapter);
        mEnVp.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                switch (position) {
                    case 0:
                        setVP(im[position]);
                        break;
                    case 1:
                        setVP(im[position]);
                        break;
                    case 2:
                        setVP(im[position]);
                        break;

                }
            }


            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


        return view;
    }

    private void initView(View view) {
        mTitle = (TextView) view.findViewById(R.id.title);
        mEnVp = (ViewPager) view.findViewById(R.id.en_vp);
        mTitle.setText("实时环境");
        mCarPage1 = (ImageView) view.findViewById(R.id.car_page1);
        mCarPage2 = (ImageView) view.findViewById(R.id.car_page2);
        mCarPage3 = (ImageView) view.findViewById(R.id.car_page3);
        im=new ImageView[]{mCarPage1,mCarPage2,mCarPage3};

    }

    private void setVP(ImageView imageView) {
        for (ImageView v : im) {
            v.setImageResource(R.drawable.logo2);
        }
        imageView.setImageResource(R.drawable.logo1);
    }
}
