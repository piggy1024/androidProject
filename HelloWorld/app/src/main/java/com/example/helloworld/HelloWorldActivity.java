package com.example.helloworld;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class HelloWorldActivity extends AppCompatActivity {

    private TextView textView;
    private EditText editText;
    private ImageView imageView;
    private ProgressBar progressBar;
    private RadioGroup genderGroup;
    private CheckBox beijing;
    private CheckBox shanghai;
    private CheckBox guangzhou;
    private Spinner city;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.hello_world_layout);

        final Button button = (Button) findViewById(R.id.button);
        editText = (EditText) findViewById(R.id.edit_text);
        textView = (TextView) findViewById(R.id.text_view);
        imageView = (ImageView) findViewById(R.id.image_view) ;
        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        genderGroup = (RadioGroup) findViewById(R.id.gender_group);
        textView = (TextView) findViewById(R.id.text_gender);
        beijing = (CheckBox) findViewById(R.id.beijing) ;
        shanghai = (CheckBox) findViewById(R.id.shanghai);
        guangzhou = (CheckBox) findViewById(R.id.guangzhou);
        city = (Spinner) findViewById(R.id.city_Spinner);


        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                // 改变文本颜色
                textView.setTextColor(Color.BLUE);
                // 获取输入的字符
                String inputText = editText.getText().toString();
                Toast.makeText(HelloWorldActivity.this, inputText,
                        Toast.LENGTH_SHORT).show();
                // 点击按钮换图片
                imageView.setImageResource(R.drawable.ktv);
                // 显示进度条  点击增加进度
                int progress = progressBar.getProgress();
                progress = progress + 10;
                progressBar.setProgress(progress);
                // 弹框
//                AlertDialog.Builder dialog = new AlertDialog.Builder (HelloWorldActivity.this);
//                dialog.setTitle("This is Dialog");
//                dialog.setMessage("Something important.");
//                dialog.setCancelable(false);
//                dialog.setPositiveButton("OK",new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialog ,int which){
//                    }
//                });
//                dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener(){
//                    @Override
//                    public void onClick(DialogInterface dialog ,int which){
//                    }
//                });
//                dialog.show();

                // 进度弹框
//                ProgressDialog progressDialog = new ProgressDialog(HelloWorldActivity.this);
//                progressDialog.setTitle("This is ProgressDialog");
//                progressDialog.setMessage("Loading......");
//                progressDialog.setCancelable(true);
//                progressDialog.show();

                if (genderGroup.getCheckedRadioButtonId() == R.id.male){
                    textView.setText("男");
                }else {
                    textView.setText("女");
                }

                CompoundButton.OnCheckedChangeListener myListener
                        = new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                        if (isChecked){
                            Toast.makeText(HelloWorldActivity.this,
                                    "你选择了"+buttonView.getText(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                };
                beijing.setOnCheckedChangeListener(myListener);
                shanghai.setOnCheckedChangeListener(myListener);
                guangzhou.setOnCheckedChangeListener(myListener);

                Toast.makeText(HelloWorldActivity.this, ""+city.getSelectedItem(),
                Toast.LENGTH_SHORT).show();

            }
        });

    }
}
