package com.cookandroid.and_0727_bank;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button money, sendmoney, outmoney, plusmoney, minusmoney;

    LinearLayout frame1, frame2, frame3;

    EditText x, y;

    TextView jan;

    int my_money = 10000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        money = findViewById(R.id.money);
        sendmoney = findViewById(R.id.sendmoney);
        outmoney = findViewById(R.id.outmoney);
        plusmoney = findViewById(R.id.plusmoney);
        minusmoney = findViewById(R.id.minusmoney);
        frame1 = findViewById(R.id.frame1);
        frame2 = findViewById(R.id.frame2);
        frame3 = findViewById(R.id.frame3);
        x = findViewById(R.id.x);
        y = findViewById(R.id.y);
        jan = findViewById(R.id.jan);


        money.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frame1.setVisibility(View.VISIBLE);
                frame2.setVisibility(View.INVISIBLE);
                frame3.setVisibility(View.INVISIBLE);
                jan.setText("잔액: "+my_money);
                money.setBackgroundColor(Color.parseColor("#F4F47F"));
                sendmoney.setBackgroundColor(Color.parseColor("#979797"));
                outmoney.setBackgroundColor(Color.parseColor("#979797"));
            }
        });


        sendmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frame1.setVisibility(View.INVISIBLE);
                frame2.setVisibility(View.VISIBLE);
                frame3.setVisibility(View.INVISIBLE);
                money.setBackgroundColor(Color.parseColor("#979797"));
                sendmoney.setBackgroundColor(Color.parseColor("#F4F47F"));
                outmoney.setBackgroundColor(Color.parseColor("#979797"));
            }
        });



        outmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                frame1.setVisibility(View.INVISIBLE);
                frame2.setVisibility(View.INVISIBLE);
                frame3.setVisibility(View.VISIBLE);
                money.setBackgroundColor(Color.parseColor("#979797"));
                sendmoney.setBackgroundColor(Color.parseColor("#979797"));
                outmoney.setBackgroundColor(Color.parseColor("#F4F47F"));
            }
        });

        plusmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int plus = Integer.parseInt(x.getText().toString());
                my_money += plus;
                Toast.makeText(getApplicationContext(), "입금 되었습니다", Toast.LENGTH_SHORT).show();
                jan.setText(" "+my_money);
                x.setText(" ");
            }
        });

        minusmoney.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int minus = Integer.parseInt(y.getText().toString());
                
                if(my_money>=minus) {
                    my_money -= minus;
                    Toast.makeText(getApplicationContext(), "출금 완료", Toast.LENGTH_SHORT).show();
                    jan.setText("잔액: "+my_money);
                    y.setText(" ");
                }else{
                    Toast.makeText(getApplicationContext(), "잔액 부족", Toast.LENGTH_SHORT).show();
                    jan.setText("잔액: "+my_money);
                }
                
            }
        });
    }
}