package com.example.admin.marchtest;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.admin.marchtest.MPchart.WratherLineFragment;
import com.example.admin.marchtest.march.CarParkFragment;
import com.example.admin.marchtest.march.CarVideoFragment;
import com.example.admin.marchtest.march.CarWzFragment;
import com.example.admin.marchtest.march.Car_query_expandFragment;
import com.example.admin.marchtest.march.DataFragment;
import com.example.admin.marchtest.march.EnvFragment;
import com.example.admin.marchtest.march.ExpandableListViewFragment;
import com.example.admin.marchtest.march.RGBLightFragment;
import com.example.admin.marchtest.march.RechargeFragment;
import com.example.admin.marchtest.march.RoadFragment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        format.setTimeZone(TimeZone.getTimeZone("GMT+08:00"));
        String format1 = format.format(new Date());
        Toast.makeText(this, ""+format1, Toast.LENGTH_SHORT).show();



        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        view = findViewById(R.id.vis);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_1) {
            replace(new ChartFragment());

            // Handle the camera action
        } else if (id == R.id.nav_2) {
            replace(new MpChartFragment());

        } else if (id == R.id.nav_3) {
            replace(new WratherLineFragment());

        } else if (id == R.id.nav_4) {
            replace(new RGBLightFragment());

        } else if (id == R.id.nav_5) {
            replace(new RechargeFragment());

        } else if (id == R.id.nav_6) {
            replace(new CarVideoFragment());

        } else if (id == R.id.nav_7) {
            replace(new CarWzFragment());

        } else if (id == R.id.nav_8) {
            replace(new RoadFragment());

        } else if (id == R.id.nav_9) {
            replace(new DataFragment());

        } else if (id == R.id.nav_10) {
            replace(new ServerTest());
        } else if (id == R.id.nav_11) {
            replace(new CarParkFragment());

        } else if (id == R.id.nav_12) {
            replace(new ExpandableListViewFragment());

        } else if (id == R.id.nav_13) {
            replace(new Car_query_expandFragment());

        }
        else if (id == R.id.nav_14) {
            replace(new EnvFragment());

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void replace(Fragment fragment) {

        view.setVisibility(View.GONE);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.coor, fragment);
        transaction.commit();
    }


}
