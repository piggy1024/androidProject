package com.example.homework1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

public class NewsDetail extends AppCompatActivity {

    private TextView detailTitle;
    private TextView detailAuthor;
    private TextView detailContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        // 注册对应活动中对应组件
        detailTitle = (TextView) findViewById(R.id.detail_title);
        detailAuthor = (TextView) findViewById(R.id.detail_author);
        detailContent = (TextView) findViewById(R.id.detail_content);

        // 接收传递过来的新闻标题
        Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        // 使用标题到数据库查询数据
        List<News> newsGet = DataSupport.select("title","author","content").where("title = ?",title).find(News.class);
        for (News news:newsGet){
            // 将查询到数据放到新闻列表
            detailTitle.setText(news.getTitle());
            detailAuthor.setText("作者:"+news.getAuthor());
            detailContent.setText("  "+news.getContent());
        }

    }
}
