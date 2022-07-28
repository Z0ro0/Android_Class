package com.cookandroid.and_0726_test4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    CheckBox[] chkList = new CheckBox[4];
    Integer[] chkText = {R.id.straw, R.id.grape, R.id.kiwi, R.id.orange};

    TextView txt;
    String str="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);

        for (int i = 0; i < chkList.length; i++) {
            chkList[i] = findViewById(chkText[i]);
        }

            btn_sel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i < chkList.length; i++){
                        if(chkList[i].isChecked()==true){
                            str[i] = chkList[i];
                        }

                    }
                    txt.setText("좋아하는 과일: "+chkList[i].getText());
                }
            });


        }
    }