package com.cookandroid.daum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtID, edtPW;
    Button btnLogin;
    TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtID = findViewById(R.id.edtID);
        edtPW =findViewById(R.id.edtPW);
        btnLogin = findViewById(R.id.btnLogin);
        txtResult = findViewById(R.id.txtResult);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String str = edtID.getText().toString();
                Toast.makeText(getApplicationContext(), str + "님 로그인 되었습니다", Toast.LENGTH_SHORT).show();


                String str1 = edtID.getText().toString();
                String str2 = edtPW.getText().toString();

                txtResult.setText("입력 결과: "+ "Id: " + str1 + " PW: " +str2);
            }
        });
    }

    }