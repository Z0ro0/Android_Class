package com.cookandroid.and_0725_02_test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText ed_num;
    Button btn_plus;
    TextView txtTotal;

    int result =0;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ed_num = findViewById(R.id.ed_num);
        btn_plus = findViewById(R.id.btn_plus);
        txtTotal = findViewById(R.id.txtTotal);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int j = Integer.parseInt(ed_num.getText().toString());
                for(int i = 0; i <= j; i++){
                    result += i;
                }

                total = result;

                txtTotal.setText("1~"+j+"까지의 합은"+total);
            }
        });
    }

}