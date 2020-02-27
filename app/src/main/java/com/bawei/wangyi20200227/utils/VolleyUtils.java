package com.bawei.wangyi20200227.utils;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bawei.wangyi20200227.base.App;


/**
 * 网路工具类
 */
public class VolleyUtils {
    //请求队列
    RequestQueue mQueue;
    //单例模式
    private static VolleyUtils volleyUtils=new VolleyUtils();

    public VolleyUtils() {
        mQueue=Volley.newRequestQueue(App.getContext());
    }

    public static VolleyUtils getInstance() {
        return volleyUtils;
    }

    public void doGet(String url, final CallBack callBack){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.Success(response);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                callBack.Error(error.getMessage());
            }
        });
        mQueue.add(stringRequest);

    }
    //接口回调
    public interface CallBack{
        void Success(String json);
        void Error(String msg);
    }

}
