package com.example.admin.materialtest;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class FruitActivity extends AppCompatActivity {
    public static final String FRUIT_NAME="fruit_name";
    public static final String FRUIT_IMAGE_ID="fruit_image_id";
    private ImageView mFruitImageView;
    private Toolbar mToolbar;
    private CollapsingToolbarLayout mCollapsingToolbar;
    private AppBarLayout mAppBar;
    private TextView mfruitContentText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit);
        initView();
        Intent intent=getIntent();
        String fruitname = intent.getStringExtra(FRUIT_NAME);
        int fruitimage = intent.getIntExtra(FRUIT_IMAGE_ID,0);
        setSupportActionBar(mToolbar);
        ActionBar actionBar = getSupportActionBar();//设置一个返回箭头
        if(actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        mCollapsingToolbar.setTitle(fruitname);//设置标题
        Glide.with(this).load(fruitimage).into(mFruitImageView);
        String fruitContent = generateFruitContent(fruitname);
        mfruitContentText.setText(fruitContent);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private String generateFruitContent(String fruitname) {
        StringBuilder stringBuilder=new StringBuilder();
        for(int i=0;i<500;i++){
            stringBuilder.append(fruitname);
        }
        return stringBuilder.toString();
    }

    private void initView() {
        mFruitImageView = (ImageView) findViewById(R.id.fruit_image_view);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mCollapsingToolbar = (CollapsingToolbarLayout) findViewById(R.id.Collapsing_Toolbar);
        mAppBar = (AppBarLayout) findViewById(R.id.app_bar);
        mfruitContentText=findViewById(R.id.fruit_content_text);
    }
}
