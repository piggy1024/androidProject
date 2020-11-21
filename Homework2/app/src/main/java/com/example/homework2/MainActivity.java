package com.example.homework2;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private EditText editText1;
    // 启动这个活动需要传出去的数据
    public static void actionStart(Context context, String data_phone, String data_message){
        Intent intent = new Intent(context, MainActivity.class);
        intent.putExtra("phone",data_phone);
        intent.putExtra("message",data_message);
        context.startActivity(intent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.phone_number) ;
        editText1 =(EditText) findViewById(R.id.message);

        Button send = (Button) findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.ACTION_START");

                String data_phone = editText.getText().toString();
                String data_message = editText1.getText().toString();
                Log.d("MainActivity",data_message);
//                MainActivity.actionStart(PersonInfo.class, "data_phone","data_message");
                intent.putExtra("phone",data_phone);
                intent.putExtra("message",data_message);

            }
        });

        Button resigter = (Button) findViewById(R.id.resigter);
        resigter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.ACTION_RE");
                startActivity(intent);
            }
        });

        Button calculator = (Button) findViewById(R.id.calculator);
        calculator.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.ACTION_CA");
                startActivity(intent);
            }
        });

        Button show = (Button) findViewById(R.id.show_personalInfo);
        show.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.ACTION_PE");
                startActivity(intent);
            }
        });
    }
}
