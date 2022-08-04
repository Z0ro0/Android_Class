package com.cookandroid.and_0803_db;


import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ed1, ed2;
    TextView tv1, tv2;
    Button btn1, btn2, btn3, btn4, btn5;
    MyDBHelper myHelper;
    SQLiteDatabase sqlDB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ed1 = findViewById(R.id.ed1);
        ed2 = findViewById(R.id.ed2);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);

        myHelper = new MyDBHelper(this);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {            // 디비의 테이블 삭제 후 다시 생성
                sqlDB = myHelper.getWritableDatabase(); // 수정모드 오픈
                myHelper.onUpgrade(sqlDB, 1, 2);  // 숫자는 버전의미로 아무거나
                sqlDB.close();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String name = ed1.getText().toString().trim();
                    int num = Integer.parseInt(ed2.getText().toString().trim());

                    if (name.isEmpty()) {
                        Toast.makeText(getApplicationContext(), "그룹명을 입력해주세요", Toast.LENGTH_SHORT).show();
                    } else {
                        sqlDB = myHelper.getWritableDatabase();
                        sqlDB.execSQL("insert into groupTBL(gName, gNumber) values('" + name + "', " + num + ");");
                        sqlDB.close();
                        Toast.makeText(getApplicationContext(), "입력 성공", Toast.LENGTH_SHORT).show();
                        ed1.setText("");
                        ed2.setText("");
                        btn3.callOnClick(); // btn3() 함수 호출
                    }
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "입력 실패", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sqlDB = myHelper.getReadableDatabase();
                Cursor cursor = sqlDB.rawQuery("select * from groupTBL;", null);
                String strNames = "그 룹 명\r\n" + "---------------\r\n";
                String strNums = "인 원 수\r\n" + "---------------\r\n";
                while (cursor.moveToNext()) {
                    strNames += cursor.getString(0) + "\n";
                    strNums += cursor.getInt(1) + "명\n";
                }
                tv1.setText(strNames);
                tv2.setText(strNums);
                cursor.close();
                sqlDB.close();
                Toast.makeText(getApplicationContext(), "조회 성공", Toast.LENGTH_SHORT).show();
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(),R.layout.update,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 정보 수정"); dlg.setView(v);
                final EditText edUpdate1 = v.findViewById(R.id.edUpdate1);
                final EditText edUpdate2 = v.findViewById(R.id.edUpdate2);
                dlg.setPositiveButton("수정", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edUpdate1.getText().toString().trim();
                            String number = edUpdate2.getText().toString().trim();
                            if (!name.isEmpty() && !number.isEmpty()){
                                String sql ="UPDATE groupTBL SET gNumber= "+ number +" WHERE gName = '"+name+"'";
                                sqlDB.execSQL(sql); sqlDB.close();
                                Toast.makeText(getApplicationContext(),"수정됨",Toast.LENGTH_SHORT).show();
                                btn3.callOnClick();
                            }else Toast.makeText(getApplicationContext(),"이름과 인원을 입력해야 합니다.",Toast.LENGTH_SHORT).show();
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"수정실패",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소",null); dlg.show();
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                View v = View.inflate(getApplicationContext(),R.layout.delete,null);
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("그룹 삭제"); dlg.setView(v);
                final EditText edDelet = v.findViewById(R.id.edDelet);
                dlg.setPositiveButton("삭제", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            sqlDB = myHelper.getWritableDatabase();
                            String name = edDelet.getText().toString().trim();
                            if (!name.isEmpty()){
                                sqlDB.execSQL("DELETE FROM groupTBL WHERE gName='"+name+"';");
                                sqlDB.close();
                                Toast.makeText(getApplicationContext(),name+"삭제됨",Toast.LENGTH_SHORT).show();
                                btn3.callOnClick();
                            }else Toast.makeText(getApplicationContext(),"이름을 입력하세요.",Toast.LENGTH_SHORT).show();
                        }catch (Exception e){
                            Toast.makeText(getApplicationContext(),"삭제실패",Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                dlg.setNegativeButton("취소",null); dlg.show();
            }
        });
    }
}