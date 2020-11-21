package com.example.homework2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;


public class PersonInfo extends AppCompatActivity {


     private TextView textView;
    private TextView textView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_info);


        textView = (TextView) findViewById(R.id.text_view);
        textView1 = (TextView) findViewById(R.id.text_view1);
        Intent intent = getIntent();
        String phone = intent.getStringExtra("phone");
        String message = intent.getStringExtra("message");
        Log.d("PersonInfo",phone);
        Log.d("PersonInfo", message);
        textView.setText("用户手机号码为:"+phone);
        textView1.setText("用户发送的短信内容为:"+message);

    }
}
