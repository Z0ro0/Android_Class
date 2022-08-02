package com.cookandroid.and_0802_act_twoway;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText num1, num2;
    Button btn;
    RadioGroup rg;
    RadioButton plus, minus, multiply, divide;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        btn = findViewById(R.id.btn);
        rg = findViewById(R.id.rg);
        plus = findViewById(R.id.plus);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        divide = findViewById(R.id.divide);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(getApplicationContext(), Second.class);
                in.putExtra("Num1", Integer.parseInt(num1.getText().toString()));
                in.putExtra("Num2", Integer.parseInt(num2.getText().toString()));

                switch (rg.getCheckedRadioButtonId()){
                    case R.id.plus: in.putExtra("sign", '+'); break;
                    case R.id.minus: in.putExtra("sign", '-'); break;
                    case R.id.multiply: in.putExtra("sign", '*');break;
                    case R.id.divide: in.putExtra("sign", '/');break;
                }
                startActivityForResult(in, 0);//requestCode는 second 번호
                //second한테 return값이 있을 때 사용(second에서 putExtra() 사용하여 되돌려 받는 경우)

            }
        });
    }
    //메서드로 onActivityResult()함수 구현

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            int sum =data.getIntExtra("sum", 0);
            Toast.makeText(getApplicationContext(), "결과"+sum, Toast.LENGTH_SHORT).show();
        }
    }
}