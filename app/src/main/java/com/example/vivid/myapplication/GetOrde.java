package com.example.vivid.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

public class GetOrde extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_orde);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        ImageView img=(ImageView)findViewById(R.id.imageView2);
        TextView t1=(TextView)findViewById(R.id.textView2);
        Switch s=(Switch)findViewById(R.id.switch1);
        setSupportActionBar(toolbar);

        final TextView tv =(TextView)findViewById(R.id.tip);
        final Button btn =(Button)findViewById(R.id.cancel_order);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fab.setVisibility(View.INVISIBLE);
                btn.setVisibility(View.VISIBLE);
                tv.setVisibility(View.VISIBLE);

            }
        });

        btn.setOnClickListener(new Button.OnClickListener(){//创建监听
            public void onClick(View v) {
//                GetOrde.this.finish();
                Intent intent = new Intent(GetOrde.this, OrderOk.class);
                startActivity(intent);
            }

        });
    }
}
