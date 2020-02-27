package com.bawei.wangyi20200227.activity;

import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.bawei.wangyi20200227.R;
import com.bawei.wangyi20200227.adapter.MyAdapter;
import com.bawei.wangyi20200227.base.BaseActivity;
import com.bawei.wangyi20200227.bean.BeanInfo;
import com.bawei.wangyi20200227.utils.VolleyUtils;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class MainActivity extends BaseActivity {

    private GridView gv;
    String path="http://mobile.bwstudent.com/small/commodity/v1/commodityList";
    private List<BeanInfo.ResultBean.PzshBean.CommodityListBeanX> commodityList;
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //找控件
        gv = findViewById(R.id.gv);
    }
    @Override
    protected void initData() {
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                BeanInfo.ResultBean.PzshBean.CommodityListBeanX commodityListBeanX = commodityList.get(position);
                String commodityName = commodityListBeanX.getCommodityName();

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
               intent.putExtra("name",commodityName);
               startActivity(intent);

            }
        });

        VolleyUtils.getInstance().doGet(path, new VolleyUtils.CallBack() {

            @Override
            public void Success(String json) {
                Log.i("xxx",json);
                Gson gson = new Gson();
                BeanInfo beanInfo = gson.fromJson(json, BeanInfo.class);
                BeanInfo.ResultBean result = beanInfo.getResult();
                BeanInfo.ResultBean.PzshBean pzsh = result.getPzsh();
                commodityList = pzsh.getCommodityList();
                //创建适配器
                MyAdapter myAdapter = new MyAdapter(MainActivity.this, commodityList);
                //设置适配器
                gv.setAdapter(myAdapter);
            }


            @Override
            public void Error(String msg) {
                Log.i("xxx",msg);

            }
        });

    }
}
