package com.cookandroid.frametest;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button [] btns = new Button[3];
    Integer [] btnIds = {R.id.btn1,R.id.btn2,R.id.btn3};
    TextView [] txts = new TextView[3];
    Integer [] txtIds = {R.id.txt1,R.id.txt2,R.id.txt3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("이름");
        for(int i = 0; i<btns.length; i++){
            btns[i] = findViewById(btnIds[i]);
            txts[i] = findViewById(txtIds[i]);
        }
        txts[1].setVisibility(View.INVISIBLE);
    }
}