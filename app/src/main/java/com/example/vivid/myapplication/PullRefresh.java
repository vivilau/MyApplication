package com.example.vivid.myapplication;


import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.handmark.pulltorefresh.library.extras.SoundPullEventListener;

import java.util.Arrays;
import java.util.LinkedList;

public class PullRefresh extends Activity {


    static final int MENU_MANUAL_REFRESH = 0;
    static final int MENU_DISABLE_SCROLL = 1;
    static final int MENU_SET_MODE = 2;
    static final int MENU_DEMO = 3;

    private LinkedList<String> mListItems;
    private PullToRefreshListView mPullRefreshListView;
    private ArrayAdapter<String> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pullfresh);
        mPullRefreshListView = (PullToRefreshListView) findViewById(R.id.pull_refresh_list);


        /**
         * 实现 接口  OnRefreshListener2<ListView>  以便与监听  滚动条到顶部和到底部
         */
        mPullRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh( PullToRefreshBase<ListView> refreshView) {
                Toast.makeText(PullRefresh.this, "onPullDownToRefresh", Toast.LENGTH_SHORT).show();
                new GetDataTask().execute();
            }
            @Override
            public void onPullUpToRefresh( PullToRefreshBase<ListView> refreshView) {
                Toast.makeText(PullRefresh.this, "onPullUpToRefresh", Toast.LENGTH_SHORT).show();
                new GetDataTask().execute();
            }
        });



        ListView actualListView = mPullRefreshListView.getRefreshableView();

        // Need to use the Actual ListView when registering for Context Menu
        registerForContextMenu(actualListView);

        mListItems = new LinkedList<String>();
        mListItems.addAll(Arrays.asList(mStrings));

        mAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, mListItems);

        /**
         * Add Sound Event Listener
         */

        /**
         *   设置下拉刷新和上拉加载时的 铃声（可有可无）
         */
        SoundPullEventListener<ListView> soundListener = new SoundPullEventListener<ListView>(this);
        soundListener.addSoundEvent(PullToRefreshBase.State.PULL_TO_REFRESH, R.raw.sound);
        soundListener.addSoundEvent(PullToRefreshBase.State.RESET, R.raw.sound);
        soundListener.addSoundEvent(PullToRefreshBase.State.REFRESHING, R.raw.sound);
        mPullRefreshListView.setOnPullEventListener(soundListener);

        // You can also just use setListAdapter(mAdapter) or
        // mPullRefreshListView.setAdapter(mAdapter)
        actualListView.setAdapter(mAdapter);



    }
    //模拟网络加载数据的   异步请求类
    //
    private class GetDataTask extends AsyncTask<Void, Void, String[]> {

        //子线程请求数据
        @Override
        protected String[] doInBackground(Void... params) {
            // Simulates a background job.
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
            }
            return mStrings;
        }

        //主线程更新UI
        @Override
        protected void onPostExecute(String[] result) {

            //向RefreshListView Item 添加一行数据  并刷新ListView
            //mListItems.addLast("Added after refresh...");
            mListItems.addFirst("Added after refresh...");
            mAdapter.notifyDataSetChanged();

            //通知RefreshListView 我们已经更新完成
            // Call onRefreshComplete when the list has been refreshed.
            mPullRefreshListView.onRefreshComplete();

            super.onPostExecute(result);
        }
    }



    //数据源
    private String[] mStrings = { "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler", "Abbaye de Belloc", "Abbaye du Mont des Cats", "Abertam", "Abondance", "Ackawi",
            "Acorn", "Adelost", "Affidelice au Chablis", "Afuega'l Pitu", "Airag", "Airedale", "Aisy Cendre",
            "Allgauer Emmentaler" };
}