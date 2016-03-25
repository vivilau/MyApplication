package com.example.vivid.myapplication;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class OrderOk extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_ok);
        Button bt_yes =(Button)findViewById(R.id.comp);
        Button bt_no =(Button)findViewById(R.id.cancel);
        final TextView ph= (TextView)findViewById(R.id.phone);
        bt_yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderOk.this, Comment.class);
                startActivity(intent);
            }
        });
        bt_no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderOk.this, MainActivity.class);
                startActivity(intent);
            }
        });
        ph.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//调用系统的拨号服务实现电话拨打功能
                String phone_number = ph.getText().toString();

                phone_number = phone_number.trim();//删除字符串首部和尾部的空格

                if(phone_number != null && !phone_number.equals(""))
                {
                    if ( ContextCompat.checkSelfPermission(OrderOk.this, android.Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED ) {

                        ActivityCompat.requestPermissions(OrderOk.this, new String[]{android.Manifest.permission.ACCESS_COARSE_LOCATION},
                                LOCATION_SERVICE.hashCode());
                    }


                    //调用系统的拨号服务实现电话拨打功能
                    //封装一个拨打电话的intent，并且将电话号码包装成一个Uri对象传入
                    Intent intent=new Intent(Intent.ACTION_CALL,Uri.parse("tel:"+phone_number));

                    startActivity(intent);
                }
            }
        });
    }
}
