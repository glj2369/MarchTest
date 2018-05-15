package com.example.admin.marchtest.Sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RechargeSQL extends SQLiteOpenHelper {
    private String create="create table history(" +
            "id integer primary key autoincrement," +
            "carid text," +
            "Remoney text," +
            "person text," +
            "date DateTime)";
    public RechargeSQL(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(create);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
