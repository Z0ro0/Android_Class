package com.cookandroid.and_0725_06_imgchange;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    Button btn_ch, btn_invisible;
    ImageView img1;

    int i = 1; // 1==dog2, 2==dog3
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_ch= findViewById(R.id.btn_ch);
        btn_invisible= findViewById(R.id.btn_invisible);
        img1= findViewById(R.id.img1);


        btn_ch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(i == 1){
                    img1.setImageResource(R.drawable.dog2);
                    i=2;

                }else{
                    img1.setImageResource(R.drawable.dog3); i = 1;
                }
            }
        });
        btn_invisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(img1.getVisibility()==View.VISIBLE){
                    img1.setVisibility(View.INVISIBLE); btn_invisible.setText("숨기기");
                }else{
                    img1.setVisibility(View.VISIBLE); btn_invisible.setText("보이기");
                }
            }
        });

    }
}