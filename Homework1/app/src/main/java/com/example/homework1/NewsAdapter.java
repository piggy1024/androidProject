package com.example.homework1;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.crud.DataSupport;

import java.util.List;

/**
 * Created by 朱秉文 on 2020/5/26.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    private List<Newssss> mNewsList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        View newsView;
        ImageView newsImage;
        TextView newsTitle;
        Button newsDetail;
        Button newsFavor;
        Button newsDelete;

        public ViewHolder(View view){
            super(view);
            newsView = view;
            newsImage = (ImageView) view.findViewById(R.id.newsItem_image);
            newsTitle = (TextView) view.findViewById(R.id.newsItem_title);
            newsDetail = (Button) view.findViewById(R.id.newsDetail_button);
            newsFavor = (Button) view.findViewById(R.id.favor_button);
            newsDelete = (Button) view.findViewById(R.id.delete_button);
        }
    }

    public NewsAdapter(List<Newssss> newsList){
        mNewsList = newsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.news_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        // 点击图片
        holder.newsImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Newssss news = mNewsList.get(position);
                Toast.makeText(v.getContext(),"Loading News Detail......" + news.getTitle(),Toast.LENGTH_SHORT).show();
                // 跳转到新闻详情页
                Intent intent = new Intent("android.intent.action.ACTION_NEWSDETAIL");
                // 传递新闻标题到详情(NewsDetail)页面去数据库查询
                intent.putExtra("title",news.getTitle());
                parent.getContext().startActivity(intent);
            }
        });
        // 点击详情按钮
        holder.newsDetail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Newssss news = mNewsList.get(position);
                Toast.makeText(v.getContext(),"Loading News Detail......",Toast.LENGTH_SHORT).show();
                // 跳转到新闻详情页
                Intent intent = new Intent("android.intent.action.ACTION_NEWSDETAIL");
                // 传递新闻标题到详情(NewsDetail)页面去数据库查询
                intent.putExtra("title",news.getTitle());
                parent.getContext().startActivity(intent);
            }


        });
        // 点击收藏按钮
        holder.newsFavor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Newssss news = mNewsList.get(position);
                News newItem =new News();
                newItem.setRemark(true);
                newItem.updateAll("title = ?", news.getTitle());
                Toast.makeText(v.getContext(),"已收藏该新闻!" ,Toast.LENGTH_SHORT).show();

            }
        });
        // 点击删除按钮
        holder.newsDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Newssss news = mNewsList.get(position);
                DataSupport.deleteAll(News.class, "title = ?", news.getTitle());
//                 news.getTitle();
                Toast.makeText(v.getContext(),"已删除该新闻!" ,Toast.LENGTH_SHORT).show();
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Newssss news =mNewsList.get(position);
        holder.newsImage.setImageResource(news.getImageId());
        holder.newsTitle.setText(news.getTitle());
    }

    @Override
    public int getItemCount() {
        return mNewsList.size();
    }
}
