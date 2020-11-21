package com.example.homework1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private SharedPreferences pref;

    private SharedPreferences.Editor editor;

    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private CheckBox rememberPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        pref = PreferenceManager.getDefaultSharedPreferences(this);
        accountEdit = (EditText) findViewById(R.id.name);
        passwordEdit = (EditText) findViewById(R.id.pwd);
        rememberPass = (CheckBox) findViewById(R.id.remember_pass);
        login = (Button) findViewById(R.id.login);
        boolean isRemember = pref.getBoolean("remember_password", false);
        if(isRemember){
            // 将账号密码都设置到文本框中
            String account = pref.getString("account", "");
            String password = pref.getString("password", "");
            accountEdit.setText(account);
            passwordEdit.setText(password);
            rememberPass.setChecked(true);

        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String account = accountEdit.getText().toString();
                String password = passwordEdit.getText().toString();
                // 如果密码是123且密码是123,登陆成功
                if(account.equals("123") && password.equals("123")){
                    Toast.makeText(MainActivity.this, "登陆成功!",Toast.LENGTH_SHORT).show();
                    editor = pref.edit();
                    if(rememberPass.isChecked()){
                        // 检查复选框是否点击
                        editor.putBoolean("remember_password",true);
                        editor.putString("account", account);
                        editor.putString("password", password);
                    }else {
                        editor.clear();
                    }
                    editor.apply();
                    // 跳转到菜单栏页面
                    Intent intent = new Intent("android.intent.action.ACTION_JUMP");
                    startActivity(intent);
                    finish();
                }else {
                    Toast.makeText(MainActivity.this, "账号或者密码错误!请重新输入!",Toast.LENGTH_SHORT).show();
                }


            }
        });

    }

//    @Override
//    protected void onStart() {
//        super.onStart();
//        Log.d("MainActivity", "onStart");
//    }
//
//    @Override
//    protected void onStop() {
//        super.onStop();
//        Log.d("MainActivity", "onStop");
//    }
//    @Override
//    protected void onResume(){
//        super.onResume();
//        Log.d("MainActivity", "onResume");
//    }
//    @Override
//    protected void onPause(){
//        super.onPause();
//        Log.d("MainActivity", "onPause");
//    }
//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//        Log.d("MainActivity", "onDestroy");
//
//    }
//    @Override
//    protected void onRestart(){
//        super.onRestart();
//        Log.d("MainActivity", "onRestart");
//    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.hello_item:
                Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
                break;
            case R.id.bye_item:
                Toast.makeText(this, "ByeBye", Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }
}
