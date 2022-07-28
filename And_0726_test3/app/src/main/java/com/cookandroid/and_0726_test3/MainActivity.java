package com.cookandroid.and_0726_test3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edt_txt;
    Button write,hp;
    RadioGroup rg;
    RadioButton rb1, rb2;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_txt = findViewById(R.id.edt_txt);
        write = findViewById(R.id.write);
        hp = findViewById(R.id.hp);
        rg = findViewById(R.id.rg);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        img = findViewById(R.id.img);

        hp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent urlOpen = new Intent(Intent.ACTION_VIEW, Uri.parse("https://m.daum.net"));
                startActivity(urlOpen);
            }
        });


        write.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), edt_txt.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb1: img.setImageResource(R.drawable.lollipop); break;
                    case R.id.rb2: img.setImageResource(R.drawable.kitkat); break;
                }
            }
        });
    }
}