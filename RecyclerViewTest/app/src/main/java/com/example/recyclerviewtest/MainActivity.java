package com.example.recyclerviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPersons();
        RecyclerView recyclerView =(RecyclerView) findViewById(R.id.recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        PersonAdapter adapter = new PersonAdapter(personList);
        recyclerView.setAdapter(adapter);

    }

    private void  initPersons(){
        for (int i = 0; i < 2; i++){
            Person apple = new Person("陈伟霆" , R.drawable.chenweiting);
            personList.add(apple);
            Person banana = new Person("邓超 " , R.drawable.dengchao);
            personList.add(banana);
            Person orange = new Person("蒋依依" , R.drawable.jiangyiyi);
            personList.add(orange);
            Person watermelon = new Person("刘诗诗" , R.drawable.liushishi);
            personList.add(watermelon);
            Person pear = new Person("鹿晗 " , R.drawable.luhan);
            personList.add(pear);
            Person garpe = new Person("孙俪 " , R.drawable.sunli);
            personList.add(garpe);
            Person pineapple = new Person("薛之谦" , R.drawable.xuezhiqian);
            personList.add(pineapple);
            Person strawberry = new Person("张雪莹" , R.drawable.zhangxueying);
            personList.add(strawberry);
            Person cherry = new Person("郑爽 " , R.drawable.zhengshuang);
            personList.add(cherry);
            Person mango = new Person("迪丽热巴" , R.drawable.dilireba);
            personList.add(mango);
        }
    }
}
