package com.cookandroid.and_0725_04_test6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edt_st, edt_end;
    Button btn_plus, btn_point;
    TextView res, res2;

    int result = 0;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_st = findViewById(R.id.edt_st);
        edt_end = findViewById(R.id.edt_end);
        btn_plus = findViewById(R.id.btn_plus);
        btn_point = findViewById(R.id.btn_point);
        res = findViewById(R.id.res);
        res2 = findViewById(R.id.res2);

        btn_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int st = Integer.parseInt(edt_st.getText().toString());
                int ed = Integer.parseInt(edt_end.getText().toString());

                for(int i = st; i <= ed; i++){
                    if(i % 2 == 0) {
                        result += i;
                    }
                }

                total = result;

                res.setText(st+"에서" +ed+"까지의 짝수의 합은" +total);
            }
        });

        btn_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int st = Integer.parseInt(edt_st.getText().toString());
                int ed = Integer.parseInt(edt_end.getText().toString());

                int result2 = ed/st*st;
                res2.setText("사용할 수 있는 포인트: " + result2);
            }
        });
    }
}