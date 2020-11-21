package com.example.homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.tablemanager.Connector;

public class JumpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
        // 个人中心按钮
        Button person_info = (Button) findViewById(R.id.person_info);
        person_info.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.ACTION_PERSONINFO");
                startActivity(intent);
            }
        });
        // 所有新闻列表按钮
        Button all_news = (Button) findViewById(R.id.all_news);
        all_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.ACTION_ALLNEWS");
                startActivity(intent);
            }
        });
        // 收藏新闻列表按钮
        Button favor_news = (Button) findViewById(R.id.favor_news);
        favor_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.ACTION_FAVORNEWS");
                startActivity(intent);
            }
        });

        // 添加新闻按钮
        Button add_news = (Button) findViewById(R.id.add_news);
        add_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent("android.intent.action.ACTION_ADDNEWS");
                startActivity(intent);
            }
        });

        // 创建数据库按钮
//        Button create_database = (Button) findViewById(R.id.create_database);
//        create_database.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Connector.getDatabase();
//            }
//        });

    }
}
