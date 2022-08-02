package com.cookandroid.and_0801_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Second_activity extends AppCompatActivity {
    TextView txtContent2;
    Button Main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Main = findViewById(R.id.Main);
        txtContent2 = findViewById(R.id.txtContent2);
        Intent in = getIntent();
        String str = in.getStringExtra("Content");
        txtContent2.setText(str);


        Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}