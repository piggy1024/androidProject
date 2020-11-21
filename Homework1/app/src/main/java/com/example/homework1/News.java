package com.example.homework1;

import org.litepal.crud.DataSupport;

/**
 * Created by 朱秉文 on 2020/5/24.
 */

public class News extends DataSupport {
    private String title;

    private String author;

    public boolean isRemark() {
        return remark;
    }

    public void setRemark(boolean remark) {
        this.remark = remark;
    }

    private String content;

    private String picName;

    private boolean remark;



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPicName() {
        return picName;
    }

    public void setPicName(String picName) {
        this.picName = picName;
    }
}
