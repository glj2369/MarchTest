package com.example.admin.marchtest.march;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.Toast;

import com.example.admin.marchtest.Car_wz;
import com.example.admin.marchtest.Mythread;
import com.example.admin.marchtest.R;
import com.example.admin.marchtest.Sql.Car_Wx_Sql;
import com.example.admin.marchtest.adapter.Car_wz_Adapter;

import java.util.ArrayList;
import java.util.List;

public class CarWZQueryActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mCaradd;
    private ListView mCarWzList;
    private List<Car_wz> list;
    private Car_Wx_Sql car_wx_sql;
    private List<String> carlist;
    ;
    SQLiteDatabase database;
    private String cph;
    private LinearLayout layout1;
    private LinearLayout layout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_car_wzquery);
        initView();
        Intent intent = getIntent();
        cph = intent.getStringExtra("cph");
        carlist = new ArrayList<>();//chepaihao
        list = new ArrayList<>();//窗口
        Toast.makeText(this, cph, Toast.LENGTH_SHORT).show();
        car_wx_sql = new Car_Wx_Sql(CarWZQueryActivity.this);


        database = car_wx_sql.getReadableDatabase();
        Cursor cursor = database.query("car_wz", null, "car_wz_id=?", new String[]{cph}, null, null, null);
        query(cursor);
        cursor.close();
        Cursor cursor1 = database.query("car_wz_his", new String[]{"car_wz_id"
        }, null, null, null, null, "car_wz_id desc");

        if (cursor1.moveToFirst()) {

            do {
                String carid_his = cursor1.getString(cursor1.getColumnIndex("car_wz_id"));
                carlist.add(carid_his);
            } while (cursor1.moveToNext());

            cursor1.close();
            //读取历史记录，加入list集合
            for (int i = 0; i < carlist.size(); i++) {
                Cursor cursora = database.query("car_wz", null, "car_wz_id=?", new String[]{carlist.get(i)}, null, null, null, null);
                query(cursora);
                cursora.close();

            }
//            for (String str : carlist) {
//                Cursor cursora = database.query("car_wz", null, "car_wz_id=?", new String[]{str}, null, null, null, null);
//                query(cursora);
//                cursora.close();
//            }
            database.close();
        }

       /* String s1 = carlist.get(1);
        Cursor cursorb = database.query("car_wz", null, "car_wz_id=?", new String[]{s1}, null, null, null, null);
        query(cursorb);*/


        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Car_wz_Adapter car_wz_adapter = new Car_wz_Adapter(CarWZQueryActivity.this, R.layout.car_wz_list_itemlayout, list);
                mCarWzList.setAdapter(car_wz_adapter);
            }
        });


    }

    private void query(Cursor cursor) {
        do {

            cursor.moveToFirst();
            String car_wz_id = cursor.getString(cursor.getColumnIndex("car_wz_id"));
            String car_wz_count = cursor.getString(cursor.getColumnIndex("car_wz_count"));
            String car_wz_math = cursor.getString(cursor.getColumnIndex("car_wz_math"));
            String car_wz_money = cursor.getString(cursor.getColumnIndex("car_wz_money"));
            list.add(new Car_wz(car_wz_id, car_wz_count, car_wz_math, car_wz_money));

        } while (cursor.moveToNext());

    }

    @SuppressLint("WrongViewCast")
    private void initView() {
        mCarWzList = (ListView) findViewById(R.id.car_wz_list);
        mCaradd = findViewById(R.id.car_wz_add);
        mCaradd.setOnClickListener(this);
        layout1 = findViewById(R.id.car_wz_item1);
        layout2 = findViewById(R.id.car_wz_item2);
        layout1.setOnClickListener(this);
        layout2.setOnClickListener(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        list.clear();
        carlist.clear();
    }

    @Override
    public void onClick(View v) {


        switch (v.getId()) {
            case R.id.car_wz_add:
                SQLiteDatabase writableDatabase = car_wx_sql.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("car_wz_id", cph);
                writableDatabase.insert("car_wz_his", null, values);
                Toast.makeText(this, "数据加入历史记录！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, MonitorActivity.class);
                startActivityForResult(intent, 1);
                //startActivity(intent);
                break;
            case R.id.car_wz_item1:
                Intent intent1 = new Intent(this, MonitorActivity.class);
                startActivityForResult(intent1, 1);
                break;
            case R.id.car_wz_item2:
                Intent intent2 = new Intent(this, MonitorActivity.class);
                startActivityForResult(intent2, 1);
                break;
            default:
                break;
        }
    }
}
