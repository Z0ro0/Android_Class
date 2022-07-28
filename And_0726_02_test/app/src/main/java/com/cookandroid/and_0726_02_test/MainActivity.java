package com.cookandroid.and_0726_02_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton rose, pen, wf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rg);
        rose = findViewById(R.id.rose);
        pen = findViewById(R.id.pen);
        wf = findViewById(R.id.wf);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rose:
                        Toast.makeText(getApplicationContext(), "장미", Toast.LENGTH_SHORT).show();break;
                    case R.id.pen:
                        Toast.makeText(getApplicationContext(), "팬지", Toast.LENGTH_SHORT).show();break;
                    case R.id.wf:
                        Toast.makeText(getApplicationContext(), "백합", Toast.LENGTH_SHORT).show();break;
                }
            }
        });
    }
}