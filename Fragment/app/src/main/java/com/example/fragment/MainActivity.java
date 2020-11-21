package com.example.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//
//        Button button = (Button) findViewById(R.id.button);
//        button.setOnClickListener(this);
//        replaceFragment(new RightFragment());
//        RightFragment rightFragment = (RightFragment) getSupportFragmentManager()
//                .findFragmentById(R.id.right_layout);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button:
                replaceFragment(new AnotherRightFragment());
                break;
            default:
                break;
        }
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
//        transaction.replace(R.id.right_layout, fragment);
        // 添加到返回栈 如不添加点击返回键会退出应用
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
