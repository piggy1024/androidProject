package com.example.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddNews extends AppCompatActivity {

    private EditText title;
    private EditText author;
    private EditText content;
    private EditText picName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_news);
        // 对应组件中editText
        title = (EditText) findViewById(R.id.news_title);
        author = (EditText) findViewById(R.id.news_author);
        content = (EditText) findViewById(R.id.news_content);
        picName = (EditText) findViewById(R.id.news_picName);



        // 确认添加按钮
        Button add_confirm = (Button) findViewById(R.id.add_confirm);
        add_confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 取出editText中的内容
                String data_title  = title.getText().toString();
                String data_author = author.getText().toString();
                String data_content = content.getText().toString();
                String data_picName = picName.getText().toString();
                News news = new News();
                // 设置即将添加到数据库的新闻字段内容
                news.setTitle(data_title);
                news.setAuthor(data_author);
                news.setContent(data_content);
                news.setPicName(data_picName);
                // 保存到数据库中
                news.save();
                Toast.makeText(v.getContext(),"添加成功!" ,Toast.LENGTH_SHORT).show();
            }
        });


    }
}
