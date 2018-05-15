package com.example.admin.marchtest.march;


import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.admin.marchtest.CarPark;
import com.example.admin.marchtest.R;
import com.example.admin.marchtest.Sql.CarParkSql;
import com.example.admin.marchtest.adapter.Car_Park_Adapter;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarParkFragment extends Fragment implements View.OnClickListener {

    private CarParkSql carParkSql;
    private View view;
    private Spinner mCarPark1;
    private Spinner mCarPark2;
    private Spinner mCarPark3;
    private Spinner mCarPark4;
    private List<CarPark> list=new ArrayList<CarPark>();
    private ListView mCarParkList;
    /**
     * 查询
     */
    private Button mCarParkQuery;
    /**
     * 退出
     */
    private Button mCarParkExit;
    /**
     * 插入
     */
    private Button mCarParkInsert;
    /**
     * 清除
     */
    private Button mCarParkDelete;
    private Car_Park_Adapter car_park_adapter;

    public CarParkFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_car_park, container, false);
        initView(view);
        initSPinner();
        car_park_adapter = new Car_Park_Adapter(getContext(), R.layout.car_park_list_item_layout, list);
        mCarParkList.setAdapter(car_park_adapter);
        return view;
    }

    private void initSPinner() {
        String[] s = new String[]{"2012", "2013", "2014", "2015", "2016", "2017", "2018"};
        String[] s1 = new String[31];
        for (int i = 0; i < 31; i++) {
            if (i < 9) {
                s1[i] = "0" + (i + 1);
            } else {
                s1[i] = i + 1 + "";
            }


        }
        ArrayAdapter a1 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, s);
        ArrayAdapter a2 = new ArrayAdapter(getContext(), android.R.layout.simple_spinner_item, s1);
        a1.setDropDownViewResource(android.R.layout.simple_spinner_item);
        a2.setDropDownViewResource(android.R.layout.simple_spinner_item);
        mCarPark1.setAdapter(a1);
        mCarPark3.setAdapter(a1);
        mCarPark2.setAdapter(a2);
        mCarPark4.setAdapter(a2);
    }

    private void initView(View view) {
        mCarPark1 = (Spinner) view.findViewById(R.id.car_park1);
        mCarPark2 = (Spinner) view.findViewById(R.id.car_park2);
        mCarPark3 = (Spinner) view.findViewById(R.id.car_park3);
        mCarPark4 = (Spinner) view.findViewById(R.id.car_park4);
        mCarParkList = (ListView) view.findViewById(R.id.car_park_list);
        mCarParkQuery = (Button) view.findViewById(R.id.car_park_query);
        mCarParkQuery.setOnClickListener(this);
        mCarParkExit = (Button) view.findViewById(R.id.car_park_exit);
        mCarParkExit.setOnClickListener(this);
        mCarParkInsert = (Button) view.findViewById(R.id.car_park_insert);
        mCarParkInsert.setOnClickListener(this);
        mCarParkDelete = (Button) view.findViewById(R.id.car_park_delete);
        mCarParkDelete.setOnClickListener(this);
        carParkSql=new  CarParkSql(getActivity(), null, null, 1);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.car_park_query:
                list.clear();
                car_park_adapter.notifyDataSetChanged();
                SQLiteDatabase db1 = carParkSql.getReadableDatabase();
                String t1 = (String) mCarPark1.getSelectedItem();
                String t2 = (String) mCarPark2.getSelectedItem();
                String t3 = (String) mCarPark3.getSelectedItem();
                String t4 = (String) mCarPark4.getSelectedItem();
                String sp1 = t1 + "-"+t2;
                String sp2 = t3 + "-"+t4;
                Log.e("CarParkSQL",sp1+""+sp2);
                Toast.makeText(getActivity(), sp1+" "+sp2, Toast.LENGTH_SHORT).show();

                //跨日期sql查询方法1： sql中日期以datetime进行存储。
                Cursor cursor = db1.query("car_park",
                        null, "datetime(outTime )>=datetime(?) and datetime(outTime )<=datetime(?)",
                        new String[]{sp1+"-01",sp2+"-01"},//这里的？替代只能为规范的DateTime日期格式，
                                                            // 如:yyyy-MM-dd HH:mm:ss.fff,yyyy-MM-dd
                        null,
                        null,
                        null);

                //跨日期sql查询方法2：sql中日期以datetime进行存储。
               /* Cursor cursor1 = db1.query("car_park",//这里的？可以为不完整的日期，如yyyy-MM
                        null, "outTime between ? and ?",
                        new String[]{sp1, sp2}, null, null, null);*/



                //db1.execSQL("SELECT * FROM \"car_park\"  WHERE  datetime(outTime )>=datetime('2011-08-01') and datetime(outTime )<=datetime('2017-09-01')");
               // db1.query("car_park",null,"outTime between '"+?+"' and '"+？+"'",new String[]{sp1,sp2},null);
                //db1.execSQL("select * from  ");
                if (cursor.moveToFirst()) {
                    do {

                        String icid = cursor.getString(cursor.getColumnIndex("icid"));
                        String carid = cursor.getString(cursor.getColumnIndex("carid"));
                        String person = cursor.getString(cursor.getColumnIndex("person"));
                        String inTime = cursor.getString(cursor.getColumnIndex("inTime"));
                        String outTime = cursor.getString(cursor.getColumnIndex("outTime"));
                        String money = cursor.getString(cursor.getColumnIndex("money"));
                        list.add(new CarPark(icid,carid,person,inTime,outTime,money));
                        Log.e("","-=-=-=-=-=-=--=-=-=");
                    } while (cursor.moveToNext());
                    cursor.close();
                    car_park_adapter.notifyDataSetChanged();
                }else {
                    Toast.makeText(getActivity(), "查询数据为空！！", Toast.LENGTH_SHORT).show();
                }
                db1.close();

                break;
            case R.id.car_park_exit:
                break;
            case R.id.car_park_insert:
                SQLiteDatabase db = carParkSql.getWritableDatabase();
                String s1 = "2012-02";
                String s2 = "2012-03";
                Timestamp in_one = sqlTime(s1);
                Timestamp out_one = sqlTime(s2);
                ContentValues values = new ContentValues();
                values.put("icid", "123");
                values.put("carid", "11111");
                values.put("person", "高战强");
                values.put("inTime", String.valueOf(in_one));
                values.put("outTime", String.valueOf(out_one));
                values.put("money", "1500");
                db.insert("car_park", null, values);
                values.clear();
                String s3 = "2013-05";
                String s4 = "2013-07";
                Timestamp in_two = sqlTime(s3);
                Timestamp out_two = sqlTime(s4);
                values.put("icid", "124");
                values.put("carid", "22222");
                values.put("person", "周宝健");
                values.put("inTime", String.valueOf(in_two));
                values.put("outTime", String.valueOf(out_two));
                values.put("money", "343");
                db.insert("car_park", null, values);
                values.clear();
                String s5 = "2013-06";
                String s6 = "2013-08";
                Timestamp in_three = sqlTime(s5);
                Timestamp out_three = sqlTime(s6);
                values.put("icid", "125");
                values.put("carid", "33333");
                values.put("person", "张万鹏");
                values.put("inTime", String.valueOf(in_three));
                values.put("outTime", String.valueOf(out_three));
                values.put("money", "300");
                db.insert("car_park", null, values);
                values.clear();
                String s7 = "2014-12";
                String s8 = "2014-12";
                Timestamp in_four = sqlTime(s7);
                Timestamp out_four = sqlTime(s8);
                values.put("icid", "126");
                values.put("carid", "44444");
                values.put("person", "朴永亮");
                values.put("inTime", String.valueOf(in_four));
                values.put("outTime", String.valueOf(out_four));
                values.put("money", "3477");
                db.insert("car_park", null, values);
                values.clear();
                String s9 = "2017-08";
                String s10 = "2017-12";
                Timestamp in_five = sqlTime(s9);
                Timestamp out_five = sqlTime(s10);
                values.put("icid", "127");
                values.put("carid", "55555");
                values.put("person", "张天铖");
                values.put("inTime", String.valueOf(in_five));
                values.put("outTime", String.valueOf(out_five));
                values.put("money", "465");
                db.insert("car_park", null, values);
                values.clear();
                Toast.makeText(getContext(), "数据插入成功！", Toast.LENGTH_SHORT).show();
                db.close();
                break;
            case R.id.car_park_delete:
                SQLiteDatabase db2 = carParkSql.getWritableDatabase();
                db2.delete("car_park",null,null);
                db2.close();
                break;
        }
    }




    private Timestamp sqlTime(String s1) {
        Timestamp t1 = null;
        try {
            Date de = new SimpleDateFormat("yyyy-MM").parse(s1);
            t1 = new Timestamp(de.getTime());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return t1;
    }
}
