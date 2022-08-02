package com.cookandroid.and_0801_hobbyintent;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class Input_activity extends AppCompatActivity {
    Button bt2;
    TextView txtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        bt2 = findViewById(R.id.bt2);
        txtContent = findViewById(R.id.txtContent);
        Intent in = getIntent();
        String name = in.getStringExtra("name");
        int age = in.getIntExtra("age",0);
        ArrayList<String> hobby = in.getStringArrayListExtra("hobby");

        txtContent.setText("이름"+name+"\n 나이:"+age+"\n 취미");
        for (String h:hobby){
            txtContent.setText(txtContent.getText().toString()+h+" ");
        }
        bt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}