package com.example.admin.marchtest.Sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Car_Wx_Sql extends SQLiteOpenHelper {
    private String create="create table car_wz(" +
            "id integer primary key autoincrement," +
            "car_wz_id text," +
            "car_wz_count text ," +
            "car_wz_math text," +
            "car_wz_money text)";
    private String create2 = "create table car_wz_his(" +
            "id integer primary key autoincrement," +
            "car_wz_id text)";
    public Car_Wx_Sql(Context context) {
        super(context, "CarWZ.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create);
        db.execSQL(create2);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
