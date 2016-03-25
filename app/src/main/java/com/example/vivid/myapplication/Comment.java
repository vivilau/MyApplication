package com.example.vivid.myapplication;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Comment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        Button com =(Button)findViewById(R.id.comm);
        com.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v,"评价成功！",Snackbar.LENGTH_LONG)
                        .setAction(null,null).show();
                Intent intent = new Intent(Comment.this, OrderComp.class);
                startActivity(intent);


            }
        });
    }
}
