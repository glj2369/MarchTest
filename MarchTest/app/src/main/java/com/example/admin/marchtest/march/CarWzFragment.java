package com.example.admin.marchtest.march;


import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.marchtest.R;
import com.example.admin.marchtest.Sql.Car_Wx_Sql;

/**
 * A simple {@link Fragment} subclass.
 */
public class CarWzFragment extends Fragment implements View.OnClickListener {


    private View view;
    /**
     * 红绿灯管理
     */
    private TextView mTitle;
    private EditText mCarId;
    /**
     * 查询
     */
    private Button mCarWzQuery;
    private Button mCarWzInsert;
    Car_Wx_Sql car_wx_sql;
    private Button mdelete;
    private Context context;
    public CarWzFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.context=context;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_car_wz, container, false);
        car_wx_sql = new Car_Wx_Sql(context);
        initView(view);
        return view;
    }

    private void initView(View view) {
        mTitle = (TextView) view.findViewById(R.id.title);
        mCarId = (EditText) view.findViewById(R.id.car_id);
        mCarWzQuery = (Button) view.findViewById(R.id.car_wz_query);
        mCarWzQuery.setOnClickListener(this);
        mCarWzInsert = view.findViewById(R.id.car_wz_insert);
        mCarWzInsert.setOnClickListener(this);
        mTitle.setText("车辆违章");
        mdelete=view.findViewById(R.id.car_wz_ddelete);
        mdelete.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.car_wz_query:
                String trim = mCarId.getText().toString().trim();
                SQLiteDatabase readableDatabase = car_wx_sql.getReadableDatabase();
                Cursor cursor = readableDatabase.query("car_wz", null, "car_wz_id=?", new String[]{trim}, null, null, null, null);
                if (cursor.getCount() == 0) {
                    Toast.makeText(context, "没有查询到" + trim + "车的违章数据！", Toast.LENGTH_SHORT).show();

                } else {
                    Intent intent = new Intent(getActivity(), CarWZQueryActivity.class);
                    intent.putExtra("cph", trim);
                    startActivity(intent);
                }

                break;
            case R.id.car_wz_insert:
                SQLiteDatabase database = car_wx_sql.getWritableDatabase();
                ContentValues values = new ContentValues();
                values.put("car_wz_id", "11111");
                values.put("car_wz_count", "10");
                values.put("car_wz_math", "3");
                values.put("car_wz_money", "40");
                database.insert("car_wz", null, values);
                values.clear();
                values.put("car_wz_id", "11112");
                values.put("car_wz_count", "2");
                values.put("car_wz_math", "6");
                values.put("car_wz_money", "122");
                database.insert("car_wz", null, values);
                values.clear();
                values.put("car_wz_id", "11113");
                values.put("car_wz_count", " 6");
                values.put("car_wz_math", " 1");
                values.put("car_wz_money", " 53");
                database.insert("car_wz", null, values);
                values.clear();
                values.put("car_wz_id", "11114");
                values.put("car_wz_count", " 7");
                values.put("car_wz_math", " 8");
                values.put("car_wz_money", " 72");
                database.insert("car_wz", null, values);
                database.close();
                Toast.makeText(getActivity(), "违章数据已插入", Toast.LENGTH_SHORT).show();
                break;
            case R.id.car_wz_ddelete:
                SQLiteDatabase writableDatabase = car_wx_sql.getWritableDatabase();
                writableDatabase.delete("car_wz",null,null);
                writableDatabase.delete("car_wz_his",null,null);
                writableDatabase.close();

                break;
        }
    }
}
