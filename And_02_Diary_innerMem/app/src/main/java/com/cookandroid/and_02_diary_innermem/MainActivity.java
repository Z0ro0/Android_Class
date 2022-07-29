package com.cookandroid.and_02_diary_innermem;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.icu.util.Output;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    DatePicker datePicker1;
    EditText edtDiary;
    Button btnWrite;
    String fileName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        datePicker1 = findViewById(R.id.datePicker1);
        edtDiary = findViewById(R.id.edtDiary);
        btnWrite = findViewById(R.id.btnWrite);
        setTitle("일기장");

        Calendar cal = Calendar.getInstance();//날짜 가져오기
        int year = cal.get(Calendar.YEAR);//연도 가져와서 year 넣기
        int month = cal.get(Calendar.MONTH);//달 가져와서 month(0부터 시작함)에 넣기
        int day = cal.get(Calendar.DAY_OF_MONTH);//일 가져와서 day에 넣기

        fileName = year +"_" + "_"+(month+1)+"_"+day+".txt";//파일 이름 년_월_일.txt

        String str = readDiary(fileName);//일기 읽기 완성

        edtDiary.setText(str);
        btnWrite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    FileOutputStream outFs = openFileOutput(fileName, Context.MODE_PRIVATE);
                    String str = edtDiary.getText().toString();
                    outFs.write(str.getBytes());
                    outFs.close();
                    Toast.makeText(getApplicationContext(), fileName+"저장됨", Toast.LENGTH_SHORT).show();
                }catch (Exception e){

                }
            }
        });

        datePicker1.init(year, month, day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int y, int d, int m) {
                fileName = y +"_" + "_"+(m+1)+"_"+d+".txt";
                String str = readDiary(fileName);//일기 있으면 읽어오기
                edtDiary.setText(str);
            }
        });

        //오늘 날짜의 일기가 있으면 읽어서 editDiary에 setText하기

    }
    //파일 읽기 함수 따로 정의
    String readDiary(String fname){
        String diaryData = null;//일기 내용 저장하는 변수
        try {
            FileInputStream inFs = openFileInput(fname);
            byte[] in = new byte[500];
            inFs.read(in);
            diaryData = (new String(in)).trim();
            btnWrite.setText("수정하기");
            inFs.close();
        }catch (Exception e){
            btnWrite.setText("새로저장");
        }
        return diaryData;
    }
}