package com.bawei.wangyi20200227.base;

import android.app.Application;
import android.content.Context;

/**
 * 写一个app类
 */
public class App extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
       context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
