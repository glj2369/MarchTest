package com.example.admin.test;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class test2_detailActivity extends Dialog implements View.OnClickListener {

    /**
     * 返回
     */
    private Button mBtBack;

    public test2_detailActivity(@NonNull Context context) {
        super(context);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_test2_detail2);
        initView();
    }

    private void initView() {
        mBtBack = (Button) findViewById(R.id.bt_back);
        mBtBack.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            default:
                break;
            case R.id.bt_back:
                dismiss();

                break;
        }
    }
}
