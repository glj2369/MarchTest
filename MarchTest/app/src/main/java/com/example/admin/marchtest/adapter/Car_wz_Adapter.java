package com.example.admin.marchtest.adapter;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.admin.marchtest.Car_wz;
import com.example.admin.marchtest.R;
import com.example.admin.marchtest.Sql.Car_Wx_Sql;

import java.util.List;

public class Car_wz_Adapter extends ArrayAdapter<Car_wz> {
    private int res;
    private List<Car_wz> list;
    private Context context;
    private Car_Wx_Sql car_wx_sql;

    public Car_wz_Adapter(@NonNull Context context, int resource, @NonNull List<Car_wz> objects) {
        super(context, resource, objects);
        this.res = resource;
        this.list = objects;
        this.context = context;

    }

    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Car_wz car_wz = getItem(position);
        View view = LayoutInflater.from(getContext()).inflate(res, parent, false);
        TextView tv_carid = view.findViewById(R.id.car_list_item_id);
        TextView tv_carcount = view.findViewById(R.id.car_list_item_count);
        TextView tv_carmath = view.findViewById(R.id.car__list_item_math);
        TextView tv_carmoney = view.findViewById(R.id.car_list_item_money);
        Button bt = view.findViewById(R.id.car_wz_j);
        tv_carid.setText(car_wz.getCar_wz_id());
        tv_carcount.setText(car_wz.getCar_wz_count());
        tv_carmath.setText(car_wz.getCar_wz_math());
        tv_carmoney.setText(car_wz.getCar_wz_money());
        car_wx_sql = new Car_Wx_Sql(context);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Car_wz item = getItem(position);
                String s = item.getCar_wz_id();
                SQLiteDatabase writableDatabase = car_wx_sql.getWritableDatabase();
                writableDatabase.delete("car_wz_his","car_wz_id=?",new String[]{s});
                notifyDataSetChanged();
                Toast.makeText(getContext(), "数据从历史记录删除！", Toast.LENGTH_SHORT).show();
                list.remove(position);
            }
        });


        return view;
    }
}
