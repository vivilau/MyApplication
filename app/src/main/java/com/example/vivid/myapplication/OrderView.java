package com.example.vivid.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderView extends AppCompatActivity {
    private View layout_1;
//    listview
    private List<Map<String, Object>> mData;
    private ListView listview1,listview2,listview3;
    //  viewpage
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private LayoutInflater mInflater;
    private List<String> mTitleList = new ArrayList<>();//页卡标题集合
    private View view1, view2,view3;//页卡视图
    private List<View> mViewList = new ArrayList<>();//页卡视图集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_orderview);


        //viewpage
        mViewPager = (ViewPager) findViewById(R.id.viewpager);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);

        mInflater = LayoutInflater.from(this);
        view1 = mInflater.inflate(R.layout.layout_1, null);
        view2 = mInflater.inflate(R.layout.layout_1, null);
        view3 = mInflater.inflate(R.layout.layout_1, null);
        listview1 = (ListView) view1.findViewById(R.id.cards_list);
        listview2 = (ListView) view2.findViewById(R.id.cards_list);
        listview3 = (ListView) view3.findViewById(R.id.cards_list);
        //添加页卡视图
        mViewList.add(view1);
        mViewList.add(view2);
        mViewList.add(view3);
        //添加页卡标题
        mTitleList.add("全部");
        mTitleList.add("未接单");
        mTitleList.add("未完成");



        mTabLayout.setTabMode(TabLayout.MODE_FIXED);//设置tab模式，当前为系统默认模式
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(0)));//添加tab选项卡
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(1)));
        mTabLayout.addTab(mTabLayout.newTab().setText(mTitleList.get(2)));

        MyPagerAdapter mAdapter = new MyPagerAdapter(mViewList);
        mViewPager.setAdapter(mAdapter);//给ViewPager设置适配器
        mTabLayout.setupWithViewPager(mViewPager);//将TabLayout和ViewPager关联起来。
        mTabLayout.setTabsFromPagerAdapter(mAdapter);//给Tabs设置适配器
        //listview
        mData = getData();
        MyAdapter adapter = new MyAdapter(this);
        listview1.setAdapter(adapter);
        listview2.setAdapter(adapter);
        listview3.setAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map = new HashMap<String, Object>();
        map.put("time", "2016-01-12 12:45");
        map.put("status", "已完成");
        map.put("order_id", "123456789");
        map.put("train", "K115次 北京西 - 天津  09车12B座 ");
        map.put("train_time", "2016-01-12 12:12开");
        map.put("service", "张三 接站");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("time", "2016-01-12 12:45");
        map.put("status", "已完成");
        map.put("order_id", "123456789");
        map.put("train", "K115次 北京西 - 天津  09车12B座 ");
        map.put("train_time", "2016-01-12 12:12开");
        map.put("service", "张三 接站");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("time", "2016-01-12 12:45");
        map.put("status", "已完成");
        map.put("order_id", "123456789");
        map.put("train", "K115次 北京西 - 天津  09车12B座 ");
        map.put("train_time", "2016-01-12 12:12开");
        map.put("service", "张三 接站");
        list.add(map);

        return list;
    }

    public final class ViewHolder{
        //public ImageView img;
        public TextView time;
        public TextView status;
        public TextView order_id;
        public TextView train;
        public TextView train_time;
        public TextView service;
    }
    //listview适配器
    public class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public MyAdapter(Context context){
            this.mInflater = LayoutInflater.from(context);
        }

        public int getCount() {
            // TODO Auto-generated method stub
            return mData.size();
        }

        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewHolder holder = null;
            if (convertView == null) {

                holder=new ViewHolder();

                convertView = mInflater.inflate(R.layout.item_order, null);
                holder.order_id = (TextView)convertView.findViewById(R.id.order_id);
                holder.service = (TextView)convertView.findViewById(R.id.service);
                holder.train_time = (TextView)convertView.findViewById(R.id.train_time);
                holder.status = (TextView)convertView.findViewById(R.id.status);
                holder.time = (TextView)convertView.findViewById(R.id.time);
                holder.train = (TextView)convertView.findViewById(R.id.train);
                convertView.setTag(holder);

            }else {

                holder = (ViewHolder)convertView.getTag();
            }


            //holder.img.setBackgroundResource((Integer) mData.get(position).get("img"));
            holder.order_id.setText((String) mData.get(position).get("order_id"));
            holder.service.setText((String) mData.get(position).get("service"));
            holder.train_time.setText((String) mData.get(position).get("train_time"));
            holder.status.setText((String) mData.get(position).get("status"));
            holder.train.setText((String) mData.get(position).get("train"));
            holder.time.setText((String) mData.get(position).get("time"));


            return convertView;
        }

    }



    //pageview
    class MyPagerAdapter extends PagerAdapter {
        private List<View> mViewList;

        public MyPagerAdapter(List<View> mViewList) {
            this.mViewList = mViewList;
        }

        @Override
        public int getCount() {
            return mViewList.size();//页卡数
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;//官方推荐写法
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mViewList.get(position));//添加页卡
            return mViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(mViewList.get(position));//删除页卡
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mTitleList.get(position);//页卡标题
        }

    }
}
