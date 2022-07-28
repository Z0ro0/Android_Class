package com.cookandroid.and_0727_framelayout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText edtX, edtY;
    Spinner op;
    Button btn;
    TextView txtResult;
    int result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtX = findViewById(R.id.edtX);
        edtY = findViewById(R.id.edtY);
        op = findViewById(R.id.op);
        btn = findViewById(R.id.btn);
        txtResult = findViewById(R.id.txtResult);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int x = Integer.parseInt(edtX.getText().toString());
                int y = Integer.parseInt(edtY.getText().toString());
                int i = op.getSelectedItemPosition();

                if(i == 0){
                    result = x+y;
                }else if(i == 1){
                    result = x-y;
                }else if(i == 2){
                    result = x*y;
                }else{
                    result = x/y;
                }

                txtResult.setText(""+result);
            }
        });
    }
}