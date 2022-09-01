package com.cookandroid.and0830_loginsql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtId, edtPw;
    Button btnLogin, btnSign;
    SQLiteDatabase sqlDB;
    MyDBHelper myHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtId = findViewById(R.id.edtId);
        edtPw = findViewById(R.id.edtPw);
        btnLogin = findViewById(R.id.btnLogin);
        btnSign = findViewById(R.id.btnSign);
        myHelper = new MyDBHelper(this);

        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent in = new Intent(MainActivity.this, RegisterActivity.class);
                startActivity(in);
            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userID = edtId.getText().toString().trim();
                String userPass = edtPw.getText().toString().trim();
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor;
                cursor = sqlDB.rawQuery("SELECT userID, userPass FROM user where userID='"+userID+"' and userPass='"+userPass+"';", null);
                
                if(cursor.moveToFirst()){
                    Intent in = new Intent(MainActivity.this, LoginOKActivity.class);
                    in.putExtra("userID", userID);
                    in.putExtra("userPass", userPass);
                    startActivity(in);
                }else{
                    Toast.makeText(getApplicationContext(), "로그인 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}