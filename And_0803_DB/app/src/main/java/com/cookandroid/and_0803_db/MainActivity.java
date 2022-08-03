package com.cookandroid.and_0803_db;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtName, edtNum;
    Button reset, input, search;
    TextView edtNameResult, edtNumberResult;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtNum = findViewById(R.id.edtNum);
        edtNameResult = findViewById(R.id.edtNameResult);
        edtNumberResult = findViewById(R.id.edtNumberResult);
        reset = findViewById(R.id.reset);
        input = findViewById(R.id.input);
        search = findViewById(R.id.search);

        myHelper = new MyDBHelper(this);
        
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {//db의 테이블 삭제 후 다시 생성
                sqlDB = myHelper.getWritableDatabase();//수정모드 오픈
                myHelper.onUpgrade(sqlDB, 1,2);//숫자는 버전ㅇ을 의미하니 아무거나
                sqlDB.close();
            }
        });

        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = edtName.getText().toString();
                    int num = Integer.parseInt(edtNum.getText().toString().trim());
                    if (name.isEmpty()){
                        Toast.makeText(getApplicationContext(), "이름 입력 필수", Toast.LENGTH_SHORT).show();
                        sqlDB.close();

                    }else{
                        sqlDB = myHelper.getWritableDatabase();
                        sqlDB.execSQL("insert into groupTBL(gName, gNumber) values('"+name+"',"+num+");");
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(),"입력성공", Toast.LENGTH_SHORT).show();
                        edtNum.setText("");
                        edtName.setText("");
                        search.callOnClick();
                    }
                }catch (Exception e){
                    Toast.makeText(getApplicationContext(), "입력실패", Toast.LENGTH_SHORT).show();
                }
            }
        });
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("select * from groupTBL;", null);
                String strNames = "그룹이름\r\n"+"-------------\r\n";
                String strNums = "인원수\r\n"+"-------------\r\n";

                while (cursor.moveToNext()){
                    strNames += cursor.getString(0)+"\n";
                    strNums += cursor.getInt(1)+"\n";
                }
                edtNameResult.setText(strNames);
                edtNumberResult.setText(strNums);
                cursor.close();
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회 성공", Toast.LENGTH_SHORT).show();
            }
        });
    }
}