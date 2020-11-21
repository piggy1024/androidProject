package com.example.homework2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class SimpleCalculaor extends AppCompatActivity {

    private EditText editText1;
    private EditText editText2;
    private EditText editText3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_calculaor);

        editText1 = (EditText) findViewById(R.id.first_number);
        editText2 = (EditText) findViewById(R.id.second_number);
        editText3 = (EditText) findViewById(R.id.result);

        final Button equals = (Button) findViewById(R.id.equals);
        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String first = editText1.getText().toString();
                String second = editText2.getText().toString();
//                Log.d("SimpleCalculaor",first);
                int result = Integer.parseInt(first) + Integer.parseInt(second);
                String rq = String.valueOf(result);
                editText3.setText(rq);

            }
        });

    }
}
