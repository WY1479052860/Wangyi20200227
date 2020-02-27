package com.bawei.wangyi20200227.base;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

/**
 * 抽取基类
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        //加载控件
        initView();
        //加载数据
        initData();
    }
    //加载布局资源ID
    protected abstract int getLayout();
    //加载控件
    protected abstract void initView();
    //加载数据
    protected abstract void initData();
}
