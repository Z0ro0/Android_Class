package com.cookandroid.and_0802_act_twoway;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;

public class Second extends AppCompatActivity {

    Button btn2;
    int sum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn2 = findViewById(R.id.btn2);

        Intent in = getIntent();
        int x = in.getIntExtra("Num1", 0);
        int y = in.getIntExtra("Num2", 0);
        int s = in.getCharExtra("sign", (char) 0);


        switch (s){
            case '+': sum = x + y; break;
            case '-': sum = x - y;break;
            case '*': sum = x * y;break;
            case '/': sum = x / y;break;
        }

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent out = new Intent(getApplicationContext(), MainActivity.class);
                out.putExtra("sum", sum);
                setResult(RESULT_OK, out);
                finish();
            }
        });
    }
}