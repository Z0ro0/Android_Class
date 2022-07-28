package com.cookandroid.project0616;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNum,edtNum1;
    Button btnminus, btnmulti,btnplus;
    TextView result;

    Button[] btnNums = new Button[10];
    Integer[] ids = {R.id.btn0,R.id. btn1, R.id.btn2, R.id.btn3, R.id.btn4, R.id.btn5,
            R.id.btn6, R.id.btn7, R.id.btn8, R.id.btn9};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        for(int i = 0; i<btnNums.length; i++){
            btnNums[i]=findViewById(ids[i]);

            final int index = i;

            btnNums[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(edtNum.isFocused()) {
                        String s = edtNum.getText().toString() + index;
                        edtNum.setText(s);

                    }else if(edtNum1.isFocused()){
                        String s = edtNum1.getText().toString() + index;
                        edtNum1.setText(s);
                    }else{
                        Toast.makeText(getApplicationContext(), "에디터부터 선택하세요 ",
                                Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }

        edtNum = findViewById(R.id.edtNum);
        edtNum1 = findViewById(R.id.edtNum1);


        btnplus = findViewById(R.id.btnplus);
        result = findViewById(R.id.result);
        btnminus = findViewById(R.id.btnminus);
        btnmulti = findViewById(R.id.btnmulti);

        btnplus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edtNum.getText().toString()) +
                        Integer.parseInt(edtNum1.getText().toString());

                result.setText("계산결과"+ x);
            }
        });

        btnminus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int y = Integer.parseInt(edtNum.getText().toString()) -
                        Integer.parseInt(edtNum1.getText().toString());

                result.setText("계산결과"+ y);
            }
        });

        btnmulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int z = Integer.parseInt(edtNum.getText().toString()) *
                        Integer.parseInt(edtNum1.getText().toString());

                result.setText("계산결과"+ z);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.option,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int x = Integer.parseInt(edtNum.getText().toString());
        int y = Integer.parseInt(edtNum1.getText().toString());

        switch (item.getItemId()){
            case R.id.itemAdd:

                result.setText("계산결과"+ (x+y));
                break;


            case R.id.itemMul:
                result.setText("계산결과"+ (x*y));
                break;


            case R.id.itemExit:
                finish();

        }


        return true;
    }
}














