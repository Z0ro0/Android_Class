package com.cookandroid.and_0801_hobbyintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button bt;
    EditText ed1,ed2;
    CheckBox ch1,ch2,ch3;
    String name;
    int age;
    ArrayList<String> hobby = new ArrayList<String >();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bt = findViewById(R.id.bt);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        ch1 = findViewById(R.id.ch1);
        ch2 = findViewById(R.id.ch2);
        ch3 = findViewById(R.id.ch3);

        ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    hobby.add(ch1.getText().toString());
                }else {
                    hobby.remove(hobby.indexOf(ch1.getText().toString()));
                }
            }
        });
        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    hobby.add(ch2.getText().toString());
                }else {
                    hobby.remove(hobby.indexOf(ch2.getText().toString()));
                }
            }
        });
        ch3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    hobby.add(ch3.getText().toString());
                }else {
                    hobby.remove(hobby.indexOf(ch3.getText().toString()));
                }
            }
        });
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                name = ed1.getText().toString();
                try {
                    age = Integer.parseInt(ed2.getText().toString());
                }catch (Exception e){

                }
                Intent in = new Intent(getApplicationContext(),Input_activity.class);
                in.putExtra("name",name);
                in.putExtra("age",age);
                in.putExtra("hobby",hobby);
                startActivity(in);
            }
        });
    }
}