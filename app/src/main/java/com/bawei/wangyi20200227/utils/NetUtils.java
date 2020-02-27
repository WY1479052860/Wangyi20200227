package com.bawei.wangyi20200227.utils;

import android.os.Handler;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 工具类
 */
public class NetUtils  {
    public static NetUtils netUtils=new NetUtils();

    public NetUtils() {
    }

    public static NetUtils getInstance() {
        return netUtils;
    }
    private Handler handler=new Handler();
    //接口回调
    interface CallBack{
        void Success(String json);
        void Error(String msg);
    }
    public void doGet(final String Jsonurl, final CallBack callBack){
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL(Jsonurl);
                    HttpURLConnection conn= (HttpURLConnection) url.openConnection();
                    conn.setReadTimeout(5000);
                    conn.setConnectTimeout(5000);
                    int responseCode = conn.getResponseCode();
                    if(responseCode==200){
                        InputStream inputStream = conn.getInputStream();
                        int len=0;
                        byte[] by=new byte[1024];
                        StringBuffer sb = new StringBuffer();
                        while((len=inputStream.read(by))!=-1){
                            String s = new String(by, 0, len);
                            sb.append(s);
                        }
                        inputStream.close();
                        final String json = sb.toString();
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                             if(callBack!=null){
                                 callBack.Success(json);
                             }
                            }
                        });

                    }else{
                        handler.post(new Runnable() {
                            @Override
                            public void run() {
                                if(callBack!=null){
                                    callBack.Error("请求失败");
                                }
                            }
                        });
                    }


                } catch (final Exception e) {
                    e.printStackTrace();
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            if(callBack!=null){
                                callBack.Error(e.toString());
                            }
                        }
                    });
                }
            }
        }).start();

    }
}
