package com.example.homework1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class FavorNewsList extends AppCompatActivity {

    private List<Newssss> newsList = new ArrayList<>();

    private ArrayList<Integer> nums = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favor_news_list);
        initNews();  // 初始化新闻图片和标题
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        NewsFavorAdapter adapter = new NewsFavorAdapter(newsList);
        recyclerView.setAdapter(adapter);

    }

    private void initNews(){
        String src = "";
        nums.add(R.drawable.chenweiting);
        nums.add(R.drawable.book1);
        nums.add(R.drawable.zhengshuang);
        nums.add(R.drawable.nirvana);
        nums.add(R.drawable.war);
        nums.add(R.drawable.book4);
        nums.add(R.drawable.road);
        nums.add(R.drawable.luhan);
        nums.add(R.drawable.dilireba);
        nums.add(R.drawable.book10);
        nums.add(R.drawable.liushishi);

        List<News> allFavorNews = DataSupport.select("title").where("remark = ?", "1").find(News.class);
        int x = 0;
        for (News news: allFavorNews){
            src = news.getPicName();
            Newssss news1 = new Newssss(news.getTitle(), nums.get(x));
            newsList.add(news1);
            x++;
        }

    }

}
