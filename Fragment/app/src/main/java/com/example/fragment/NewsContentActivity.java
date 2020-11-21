package com.example.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class NewsContentActivity extends AppCompatActivity {

    public static void actionStart(Context context, String newsTitle, String
                                   newsContent){
        Intent intent = new Intent(context, NewsContentActivity.class);
        intent.putExtra("new_title", newsTitle);
        intent.putExtra("new_content", newsContent);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_content);
        // 获取传入的新闻标题
        String newsTitle = getIntent().getStringExtra("news_title");
        // 获取传入的新闻内容
        String newsContent = getIntent().getStringExtra("news_content");
        NewsContentFragment newsContentFragment = (NewsContentFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.news_content_fragment);
        // 刷新NewsContent-Fragment界面
        newsContentFragment.refresh(newsTitle, newsContent);
    }
}
