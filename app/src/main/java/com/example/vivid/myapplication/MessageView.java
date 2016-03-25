package com.example.vivid.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MessageView extends AppCompatActivity {
    private ListView msglist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_view);
//        msglist=(ListView)findViewById(R.id.msglist);
//        msglist.setAdapter(new ArrayAdapter<String>
//                (this, R.layout.item_msg, getData()));
//        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
//        LinearLayout parent = (LinearLayout) inflater.inflate(R.layout.activity_message_view, null);
//        parent.removeView(msglist);
//        setContentView(msglist);
    }
    private List<String> getData(){
        List<String> data = new ArrayList<String>();
        return data;
        }
}
