package com.bawei.wangyi20200227.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import com.bawei.wangyi20200227.R;
import com.bawei.wangyi20200227.base.BaseActivity;

public class Main2Activity extends BaseActivity {


    private TextView tv;

    @Override
    protected int getLayout() {
        return R.layout.activity_main2;
    }

    @Override
    protected void initView() {
        tv = findViewById(R.id.tv);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        tv.setText(name);
    }

    @Override
    protected void initData() {

    }
}
