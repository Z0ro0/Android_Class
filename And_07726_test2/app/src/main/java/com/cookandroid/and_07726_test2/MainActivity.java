package com.cookandroid.and_07726_test2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup rg;
    RadioButton woozoo, bts, seven;
    Button btn_vote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg = findViewById(R.id.rg);
        woozoo = findViewById(R.id.woozoo);
        bts = findViewById(R.id.bts);
        seven = findViewById(R.id.seven);
        btn_vote = findViewById(R.id.btn_vote);
        
        btn_vote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (rg.getCheckedRadioButtonId()){
                    case R.id.woozoo:
                        Toast.makeText(getApplicationContext(), "우주소녀", Toast.LENGTH_SHORT).show();break;
                    case R.id.bts:
                        Toast.makeText(getApplicationContext(), "방탄소년단", Toast.LENGTH_SHORT).show();break;
                    case R.id.seven:
                        Toast.makeText(getApplicationContext(), "세븐틴", Toast.LENGTH_SHORT).show();break;
                }
            }
        });
        
    }
}