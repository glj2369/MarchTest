package com.example.mpchart215test;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import com.example.mpchart215test.Adapter.ViewPagerAdapter;
import com.github.mikephil.charting.data.PieDataSet;

public class MainActivity extends AppCompatActivity {
    private PieDataSet pieDataSet;
    private NavigationView mNav;
    private DrawerLayout mDra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_action_name);
        }

        mNav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                mDra.closeDrawers();
                switch (itemId) {
                    case R.id.one:
                        startActivity(new Intent(MainActivity.this, Line_Activity.class));
                        overridePendingTransition(R.anim.in, R.anim.out);
                        break;
                    case R.id.two:
                        startActivity(new Intent(MainActivity.this, BarActivity.class));
                        break;
                    case R.id.three:
                        startActivity(new Intent(MainActivity.this, HorActivity.class));
                        break;
                    case R.id.four:
                        startActivity(new Intent(MainActivity.this, PieActivity.class));
                        break;
                    case R.id.five:
                        startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
                        break;
                    case R.id.six:
                        startActivity(new Intent(MainActivity.this, fxActivity.class));
                        break;
                    case R.id.seven:
                        startActivity(new Intent(MainActivity.this, fx2Activity.class));
                        break;
                    case R.id.eight:
                        // startActivity(new Intent(MainActivity.this, ViewPagerActivity.class));
                        break;
                }
                return true;
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            mDra.openDrawer(GravityCompat.START);
        }
        return super.onOptionsItemSelected(item);
    }

    private void initView() {
        mNav = (NavigationView) findViewById(R.id.nav);
        mDra = (DrawerLayout) findViewById(R.id.dra);
    }
}
