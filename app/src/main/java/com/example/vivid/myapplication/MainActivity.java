package com.example.vivid.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private List<Map<String, Object>> mData;
    private ListView listview;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        listview = (ListView) findViewById(R.id.listView);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        //listview
        mData = getData();
        MyAdapter adapter = new MyAdapter(this);
        listview.setAdapter(adapter);
    }

    private List<Map<String, Object>> getData() {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();

        Map<String, Object> map = new HashMap<String, Object>();
        map = new HashMap<String, Object>();
        map.put("order_id", "1234567890");
        map.put("train_id", "K115 北京西-天津 09车");
        map.put("train_time", "2016-01-02 01:30开");
        map.put("order_time", "2016-01-02 01:30:23");
        map.put("person", "李四");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("order_id", "1234567890");
        map.put("train_id", "K115 北京西-天津 09车");
        map.put("train_time", "2016-01-02 01:30开");
        map.put("order_time", "2016-01-02 01:30:23");
        map.put("person", "李四");
        list.add(map);

        map = new HashMap<String, Object>();
        map.put("order_id", "1234567890");
        map.put("train_id", "K115 北京西-天津 09车");
        map.put("train_time", "2016-01-02 01:30开");
        map.put("order_time", "2016-01-02 01:30:23");
        map.put("person", "李四");
        list.add(map);

        return list;
    }

    // ListView 中某项被选中后的逻辑


    public final class ViewHolder{
        //public ImageView img;
        public TextView order_id;
        public TextView train_id;
        public TextView train_time;
        public Button get_order;
        public TextView person;
        public TextView order_time;

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

                convertView = mInflater.inflate(R.layout.items, null);
                holder.order_id = (TextView)convertView.findViewById(R.id.order_id);
                holder.train_id = (TextView)convertView.findViewById(R.id.train_id);
                holder.train_time = (TextView)convertView.findViewById(R.id.train_time);
                holder.person = (TextView)convertView.findViewById(R.id.person);

                holder.order_time = (TextView)convertView.findViewById(R.id.order_time);
                holder.get_order=(Button)convertView.findViewById(R.id.get);
                convertView.setTag(holder);

            }else {

                holder = (ViewHolder)convertView.getTag();
            }


            //holder.img.setBackgroundResource((Integer) mData.get(position).get("img"));

            
            holder.order_id.setText((String) mData.get(position).get("order_id"));


            holder.train_id.setText((String) mData.get(position).get("train_id"));
            holder.train_time.setText((String) mData.get(position).get("train_time"));
            holder.person.setText((String)mData.get(position).get("person"));
            holder.order_time.setText((String)mData.get(position).get("order_time"));
            holder.get_order.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
//                    点击按钮事件
                    Intent intent = new Intent(MainActivity.this, PullRefresh.class);
                    startActivity(intent);
                }
            });

            return convertView;
        }

    }



    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.order) {
            // Handle the camera action
            Intent intent = new Intent(MainActivity.this, OrderView.class);
            startActivity(intent);
        }  else if (id == R.id.msg) {
            Intent intent = new Intent(MainActivity.this, MessageView.class);
            startActivity(intent);
        } else if (id == R.id.exit) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }




}
