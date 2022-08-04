package com.cookandroid.and_0803_db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MyDBHelper extends SQLiteOpenHelper {
    public MyDBHelper(@Nullable Context context) {
        super(context,"groupDB.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        // 테이블 생성
        String str = "create table groupTBL(gName char(20) primary key, gNumber integer);";
        sqLiteDatabase.execSQL(str);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        // 테이블 삭제
        sqLiteDatabase.execSQL("drop table if exists groupTBL;");
        onCreate(sqLiteDatabase);
    }
}
