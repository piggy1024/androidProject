package com.example.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class UserResigter extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private RadioGroup radioGroup;
    private CheckBox checkBox;
    private Spinner spinner;
    private TextView textView1;
    private TextView textView2;
    private TextView textView3;
    private TextView textView4;
    private TextView textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_resigter);

        editText1 = (EditText) findViewById(R.id.input_name);
        editText2 = (EditText) findViewById(R.id.input_pwd);
        radioGroup = (RadioGroup) findViewById(R.id.sex_choose);
        checkBox = (CheckBox) findViewById(R.id.yes);
        spinner = (Spinner) findViewById(R.id.city);

        textView1 =(TextView) findViewById(R.id.show_name);
        textView2 =(TextView) findViewById(R.id.show_pwd);
        textView3 =(TextView) findViewById(R.id.show_sex);
        textView4 =(TextView) findViewById(R.id.show_isvip);
        textView5 =(TextView) findViewById(R.id.show_city);

        Button confirm = (Button) findViewById(R.id.confirm);
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editText1.getText().toString();
                String pwd = editText2.getText().toString();
                textView1.setText(name+" ");
                textView2.setText(pwd+" ");

                if (radioGroup.getCheckedRadioButtonId()==R.id.male){
                    textView3.setText("男 ");
                }else {
                    textView3.setText("女 ");
                }

                if (checkBox.isChecked()){
                    textView4.setText("尊贵会员 ");
                }
                else {
                    textView4.setText("非会员 ");
                }

                String whichCity = spinner.getSelectedItem().toString();
                textView5.setText(whichCity);

            }
        });


        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText("UserResigter")
            }
        });

    }
}
