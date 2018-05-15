package com.example.admin.marchtest.march;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.marchtest.R;
import com.example.admin.marchtest.Recharge;
import com.example.admin.marchtest.Sql.RechargeSQL;
import com.example.admin.marchtest.adapter.RechargeAdapter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class RechargeFragment extends Fragment implements View.OnClickListener {
    private Button mdelete;
    private List<Recharge> list = new ArrayList<>();
    private View view;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    private Spinner mRechargeSpinner;
    /**
     * 查询
     */
    private Button mRechareQuery;
    private ListView mRechareList;
    private Button minsert;
    private RechargeSQL rechargeSQL;
    private RechargeAdapter rechargeAdapter;
    private SQLiteDatabase readableDatabase;

    public RechargeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_recharge, container, false);
        initView(view);
        rechargeSQL = new RechargeSQL(getActivity(), "Recharge.db", null, 1);//指定数据库名
        String[] s = {"时间升序", "时间降序"};
        ArrayAdapter<String> sp = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_item, s);
        sp.setDropDownViewResource(android.R.layout.simple_spinner_item);
        //mRechargeSpinner.setSelection(0, true);   //解决第一项默认执行问题
        mRechargeSpinner.setAdapter(sp);
        mRechargeSpinner.setSelection(1, true);

        mRechargeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        Toast.makeText(getActivity(), "升序", Toast.LENGTH_SHORT).show();
                        SpinnerSort("date asc");
                        break;
                    case 1:
                        Toast.makeText(getActivity(), "降序", Toast.LENGTH_SHORT).show();
                        SpinnerSort("date desc");
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        rechargeAdapter = new RechargeAdapter(getActivity(), R.layout.recharge_listitem_layout, list);
        mRechareList.setAdapter(rechargeAdapter);

        SpinnerSort("date desc");
        return view;
    }

    private void SpinnerSort(String s) {
        readableDatabase = rechargeSQL.getReadableDatabase();
        rechargeAdapter.clear();
        Cursor cursor1 = readableDatabase.query("history", null, null, null, null, null, s);
        queryIF(cursor1);
        cursor1.close();
    }

    private void initView(View view) {
        mTitle = (TextView) view.findViewById(R.id.title);
        mRechargeSpinner = (Spinner) view.findViewById(R.id.recharge_spinner);
        mRechareQuery = (Button) view.findViewById(R.id.rechare_query);
        mRechareQuery.setOnClickListener(this);
        mRechareList = (ListView) view.findViewById(R.id.rechare_list);
        minsert = view.findViewById(R.id.rechare_insert);
        minsert.setOnClickListener(this);
        mdelete = view.findViewById(R.id.rechare_delete);
        mdelete.setOnClickListener(this);
        mTitle.setText("账单管理");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.rechare_query:
                Cursor cursor;
                readableDatabase = rechargeSQL.getReadableDatabase();
                list.clear();
                if (mRechargeSpinner.getSelectedItemPosition() == 0) {
                    cursor = readableDatabase.query("history", null, null, null, null, null, "date asc");
                } else {
                    cursor = readableDatabase.query("history", null, null, null, null, null, "date desc");

                }

                queryIF(cursor);

                cursor.close();
                break;
            case R.id.rechare_insert:
                SQLiteDatabase db = rechargeSQL.getWritableDatabase();
                ContentValues valur = new ContentValues();
                String time1 = "2015-3-1 16:20";
                String time2 = "2017-10-1 5:10";
                String time3 = "2016-9-18 9:18";
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                try {
                    Date date1 = simpleDateFormat.parse(time1);
                    Date date2 = simpleDateFormat.parse(time2);
                    Date date3 = simpleDateFormat.parse(time3);
                    Timestamp timestamp1 = new Timestamp(date1.getTime());
                    Timestamp timestamp2 = new Timestamp(date2.getTime());
                    Timestamp timestamp3 = new Timestamp(date3.getTime());

                    valur.put("carid", "1");
                    valur.put("Remoney", "100");
                    valur.put("person", "admin");
                    valur.put("date", String.valueOf(timestamp1));
                    db.insert("history", null, valur);
                    valur.clear();
                    valur.put("carid", "1");
                    valur.put("Remoney", "50");
                    valur.put("person", "admin");
                    valur.put("date", String.valueOf(timestamp2));
                    db.insert("history", null, valur);
                    valur.clear();
                    valur.put("carid", "2");
                    valur.put("Remoney", "140");
                    valur.put("person", "admin");
                    valur.put("date", String.valueOf(timestamp3));
                    db.insert("history", null, valur);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                Toast.makeText(getActivity(), "插入完成！！", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rechare_delete:
                SQLiteDatabase writableDatabase = rechargeSQL.getWritableDatabase();
                writableDatabase.execSQL("delete from history");
                list.clear();
                Toast.makeText(getActivity(), "sql 清除完成！！", Toast.LENGTH_SHORT).show();
                rechargeAdapter.notifyDataSetChanged();
                break;
        }
    }

    private void queryIF(Cursor cursor) {
        if (cursor.getCount() == 0) {
            Toast.makeText(getActivity(), "暂无历史数据", Toast.LENGTH_SHORT).show();
        }
        if (cursor.moveToFirst()) {

            do {
                int id = cursor.getInt(cursor.getColumnIndex("id"));
                String carid = cursor.getString(cursor.getColumnIndex("carid"));
                String Remoney = cursor.getString(cursor.getColumnIndex("Remoney"));
                String person = cursor.getString(cursor.getColumnIndex("person"));
                String date = cursor.getString(cursor.getColumnIndex("date"));
                String s = date.replace("-", ".");
                list.add(new Recharge(id + "", carid, Remoney, person, date));
                rechargeAdapter.notifyDataSetChanged();
            } while (cursor.moveToNext());


        }
    }
}
