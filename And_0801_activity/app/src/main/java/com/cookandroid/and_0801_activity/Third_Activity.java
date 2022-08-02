package com.cookandroid.and_0801_activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Third_Activity extends AppCompatActivity {
    Button Main;
    TextView txtContent3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Main = findViewById(R.id.Main);
        txtContent3 = findViewById(R.id.txtContent3);

        Intent in = getIntent();
        String str = in.getStringExtra("content");
        txtContent3.setText(str);

        Main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}