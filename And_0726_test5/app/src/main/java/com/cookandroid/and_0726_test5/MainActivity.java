package com.cookandroid.and_0726_test5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    CheckBox start;
    TextView txtfavor;
    RadioGroup rg;

    RadioButton ko, ch, bo, ya;

    int i = 1;
    Button reset;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start = findViewById(R.id.start);
        txtfavor = findViewById(R.id.txtfavor);
        rg = findViewById(R.id.rg);
        reset = findViewById(R.id.reset);
        img = findViewById(R.id.img);
        ko = findViewById(R.id.ko);
        ch = findViewById(R.id.ch);
        bo = findViewById(R.id.bo);
        ya = findViewById(R.id.ya);



        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(start.isChecked()==true){
                    rg.setVisibility(View.VISIBLE);
                    txtfavor.setVisibility(View.VISIBLE);
                    reset.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }else{
                    rg.setVisibility(View.INVISIBLE);
                }
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rg.clearCheck();
                img.setVisibility(View.INVISIBLE);
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.ko: img.setImageResource(R.drawable.donut); break;
                    case R.id.ch: img.setImageResource(R.drawable.eclair); break;
                    case R.id.bo: img.setImageResource(R.drawable.froyo);break;
                    case R.id.ya: img.setImageResource(R.drawable.gingerbread);break;
                }
            }
        });


    }
}