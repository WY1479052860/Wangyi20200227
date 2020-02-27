package com.bawei.wangyi20200227.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bawei.wangyi20200227.R;
import com.bawei.wangyi20200227.activity.MainActivity;
import com.bawei.wangyi20200227.base.BaseActivity;
import com.bawei.wangyi20200227.bean.BeanInfo;
import com.bumptech.glide.Glide;

import java.util.List;

/**
 * 适配器类
 */
public class MyAdapter extends BaseAdapter {
    Context context;
    List<BeanInfo.ResultBean.PzshBean.CommodityListBeanX> commodityList;

    public MyAdapter(Context context, List<BeanInfo.ResultBean.PzshBean.CommodityListBeanX> commodityList) {
        this.context = context;
        this.commodityList = commodityList;
    }

    @Override
    public int getCount() {
        return commodityList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=null;
        holder=new ViewHolder();
        if(convertView==null){
            convertView=View.inflate(context, R.layout.item,null);
            holder.iv=convertView.findViewById(R.id.iv);
            holder.tv_name=convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);
        }else{
           holder= (ViewHolder) convertView.getTag();
        }
        BeanInfo.ResultBean.PzshBean.CommodityListBeanX commodityListBeanX = commodityList.get(position);
        int commodityId = commodityListBeanX.getCommodityId();
        String commodityName = commodityListBeanX.getCommodityName();
        String masterPic = commodityListBeanX.getMasterPic();
        holder.tv_name.setText(commodityName);
        Glide.with(context).load(masterPic).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(holder.iv);
        return convertView;
    }
    private class ViewHolder{
        private TextView tv_name;
        private ImageView iv;
    }
}
