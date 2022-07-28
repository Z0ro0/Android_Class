package com.cookandroid.andproject_0614;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.PopupMenu;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup RadioGp;
    RadioButton Grade2, Grade3;
    Button btnInsert,btnCancel, btnbt;
    CheckBox checkvis;

    String grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGp = findViewById(R.id.RadioGp);
        Grade2 = findViewById(R.id.Grade2);
        Grade3 = findViewById(R.id.Grade3);
        btnInsert = findViewById(R.id.btnInsert);
        btnCancel = findViewById(R.id.btnCancel);
        btnbt = findViewById(R.id.btnbt);
        checkvis = findViewById(R.id.checkvis);

        checkvis.setChecked(true);
        checkvis.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) btnbt.setEnabled(true);
                else btnbt.setEnabled(false);
            }
        });


        RadioGp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if(i==0)grade="2학년";
                else grade="3학년";

                if(radioGroup.getCheckedRadioButtonId()==R.id.Grade2)
                    grade=Grade2.getText().toString();
                else grade=Grade3.getText().toString();

            }
        });
        
        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "선택한 학년: "+grade, Toast.LENGTH_SHORT).show();
                
            }
        });
        
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RadioGp.clearCheck();
                Toast.makeText(getApplicationContext(), "선택 취소함", Toast.LENGTH_SHORT).show();
            }
        });
    }
}



















