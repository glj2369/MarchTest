package com.example.mpchart215test;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.example.mpchart215test.Adapter.ViewPagerAdapter;
import com.example.mpchart215test.Fragment.ExpandableViewFragment;
import com.example.mpchart215test.Fragment.FragmentTabHostFragment;
import com.example.mpchart215test.Fragment.GridViewFragment;
import com.example.mpchart215test.Fragment.ListViewFragment;
import com.example.mpchart215test.Fragment.SpinnerFragment;

import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity {

    private ViewPager mViewpagerTest;
    private ImageView mPage1;
    private ImageView mPage2;
    private ImageView mPage3;
    private ImageView mPage4;
    private ImageView mPage5;
    private List<Fragment> list = new ArrayList<>();
    private Fragment[] f;
    private ImageView[] imageViews;
    private ImageView pic;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);
        initView();
        for (int i = 0; i < 5; i++) {
            list.add(f[i]);
        }
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
        mViewpagerTest.setAdapter(adapter);
        mViewpagerTest.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        setpic(imageViews[position]);
                        break;
                    case 1:
                        setpic(imageViews[position]);
                        break;
                    case 2:
                        setpic(imageViews[position]);
                        break;
                    case 3:
                        setpic(imageViews[position]);
                        break;
                    case 4:
                        setpic(imageViews[position]);
                        break;
                    default:
                        break;


                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    private void initView() {
        mViewpagerTest = (ViewPager) findViewById(R.id.viewpager_test);
        mPage1 = (ImageView) findViewById(R.id.page1);
        mPage2 = (ImageView) findViewById(R.id.page2);
        mPage3 = (ImageView) findViewById(R.id.page3);
        mPage4 = (ImageView) findViewById(R.id.page4);
        mPage5 = (ImageView) findViewById(R.id.page5);
        imageViews = new ImageView[]{mPage1, mPage2, mPage3, mPage4, mPage5};
        f = new Fragment[]{new ExpandableViewFragment(), new FragmentTabHostFragment(), new GridViewFragment(), new ListViewFragment(), new SpinnerFragment()};

    }

    public void setpic(ImageView pic) {
        for (ImageView i : imageViews) {
            i.setImageResource(R.drawable.circle1);
        }
        pic.setImageResource(R.drawable.circle2);

    }

    public ImageView getPic() {
        return pic;
    }

    public void setPic(ImageView pic) {
        this.pic = pic;
    }
}
