package com.example.admin.marchtest.Sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class CarParkSql extends SQLiteOpenHelper {
    private String create="create table car_park(" +
            "id integer primary key autoincrement," +
            "icid text," +
            "carid text ," +
            "person text," +
            "inTime DateTime," +
            "outTime DateTime," +
            "money text)";
    public CarParkSql(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,"car_Park.db",null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
