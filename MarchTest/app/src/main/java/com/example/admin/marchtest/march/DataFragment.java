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
import com.example.admin.marchtest.march.data_fragment.BarFragment;
import com.example.admin.marchtest.march.data_fragment.CarBarFragment;
import com.example.admin.marchtest.march.data_fragment.HorBarFragment;
import com.example.admin.marchtest.march.data_fragment.PieFragment;
import com.example.admin.marchtest.march.data_fragment.RepeatPieFragment;
import com.example.admin.marchtest.march.data_fragment.SexBarFragment;
import com.example.admin.marchtest.march.data_fragment.TraHorBarFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class DataFragment extends Fragment {


    private View view;
    private ViewPager mDataViewPager;
    private List<Fragment> list = new ArrayList<Fragment>();
    private Fragment[] f;
    private TextView mtitle;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    private ImageView mPage1;
    private ImageView mPage2;
    private ImageView mPage3;
    private ImageView mPage4;
    private ImageView mPage5;
    private ImageView mPage6;
    private ImageView mPage7;
    private ImageView[] im = new ImageView[7];
    private MyViewPagerAdapter adapter;

    public DataFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_data, container, false);
        initView(view);
        for (int i = 0; i < 7; i++) {
            list.add(f[i]);
        }

        adapter = new MyViewPagerAdapter(getChildFragmentManager(), list);
        mDataViewPager.setAdapter(adapter);
        mDataViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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
                    case 3:
                        setVP(im[position]);
                        break;
                    case 4:
                        setVP(im[position]);
                        break;
                    case 5:
                        setVP(im[position]);
                        break;
                    case 6:
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

    private void setVP(ImageView imageView) {
        for (ImageView v : im) {
            v.setImageResource(R.drawable.logo2);
        }
        imageView.setImageResource(R.drawable.logo1);
    }

    private void initView(View view) {
        mDataViewPager = (ViewPager) view.findViewById(R.id.data_view_pager);

        f = new Fragment[]{new PieFragment(), new RepeatPieFragment(), new HorBarFragment(), new BarFragment(), new SexBarFragment(), new CarBarFragment(), new TraHorBarFragment()};

        mtitle = view.findViewById(R.id.title);
        mtitle.setText("数据分析");
        mTitle = (TextView) view.findViewById(R.id.title);
        mPage1 = (ImageView) view.findViewById(R.id.page1);
        mPage2 = (ImageView) view.findViewById(R.id.page2);
        mPage3 = (ImageView) view.findViewById(R.id.page3);
        mPage4 = (ImageView) view.findViewById(R.id.page4);
        mPage5 = (ImageView) view.findViewById(R.id.page5);
        mPage6 = (ImageView) view.findViewById(R.id.page6);
        mPage7 = (ImageView) view.findViewById(R.id.page7);
        im = new ImageView[]{mPage1, mPage2, mPage3, mPage4, mPage5, mPage6, mPage7};
    }
}
