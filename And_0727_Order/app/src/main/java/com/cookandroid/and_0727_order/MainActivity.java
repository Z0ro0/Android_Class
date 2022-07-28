package com.cookandroid.and_0727_order;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ImageView img;
    RadioGroup rg;
    RadioButton cat, rabbit, dog;
    Button btn;

    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.img);
        rg = findViewById(R.id.rg);
        cat = findViewById(R.id.cat);
        rabbit = findViewById(R.id.rabbit);
        dog = findViewById(R.id.dog);
        btn = findViewById(R.id.btn);

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.cat: img.setImageResource(R.drawable.cat); break;
                    case R.id.rabbit: img.setImageResource(R.drawable.rabbit); break;
                    case R.id.dog: img.setImageResource(R.drawable.dog3);break;
                }
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (rg.getCheckedRadioButtonId()){
                    case R.id.cat: Toast.makeText(getApplicationContext(), "고양이 선택", Toast.LENGTH_SHORT).show();break;
                    case R.id.rabbit: Toast.makeText(getApplicationContext(), "토끼 선택", Toast.LENGTH_SHORT).show();break;
                    case R.id.dog: Toast.makeText(getApplicationContext(), "강아지 선택", Toast.LENGTH_SHORT).show();break;
                }

            }
        });
    }
}