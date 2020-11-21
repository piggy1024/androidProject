package com.example.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PersonalInfo extends AppCompatActivity {

    private TextView textView1;
    private TextView textView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_personal_info);

        textView1 = (TextView) findViewById(R.id.show_english) ;
        textView2 = (TextView) findViewById(R.id.show_chinese);
        Button next = (Button) findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String next_english = "Good Good Study!Day Day Up!";
                String next_chinese = "好好学习!天天向上!";
                textView1.setText(next_english);
                textView2.setText(next_chinese);

            }
        });
    }
}
