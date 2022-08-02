package com.cookandroid.and_0801_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    RadioButton SecondActivity, ThirdActivity;
    Button btnOpen;
    RadioGroup rg;
    EditText edtContent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("최가을 첫번째 화면");

        btnOpen = findViewById(R.id.btnOpen);
        SecondActivity = findViewById(R.id.SecondActivity);
        ThirdActivity = findViewById(R.id.ThirdActivity);
        rg = findViewById(R.id.rg);
        edtContent = findViewById(R.id.edtContent);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String str = edtContent.getText().toString();

                switch (rg.getCheckedRadioButtonId()){
                    case R.id.SecondActivity:
                        Intent in = new Intent(getApplicationContext(), Second_activity.class);
                        in.putExtra("Content", str);
                        startActivity(in);//SecondActivity화면에 띄우기
                        break;
                    case R.id.ThirdActivity:
                        in = new Intent(getApplicationContext(), Third_Activity.class);
                        in.putExtra("Content", str);
                        startActivity(in);
                        break;
                }


            }
        });
    }
}