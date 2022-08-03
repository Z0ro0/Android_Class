package com.cookandroid.and_0802_carlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    MovieAdapter mAdapter;
    ArrayList<Movie> mArray;
    Movie mItem;


    Integer[] poster = {R.drawable.mov01,R.drawable.mov02,R.drawable.mov03,R.drawable.mov04,
            R.drawable.mov05,R.drawable.mov06,R.drawable.mov07,R.drawable.mov08,
            R.drawable.mov09,R.drawable.mov10};

    String[] title = {"토이", "호빗", "제이스본", "반지의 제왕", "정직한 후보","나쁜 녀석들", "겨울왕국", "알라딘", "극한직업", "스파이더맨"};

    String [] genre = {"DRAMA", "DRAMA", "HORROR", "MOVIE", "FANTAST","DRAMA", "DRAMA", "HORROR", "MOVIE", "FANTAST",};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = findViewById(R.id.list);

        mArray = new ArrayList<>();

        for (int i = 0; i <poster.length; i++){
            mItem = new Movie(ContextCompat.getDrawable(this, poster[i]), title[i], genre[i]);
            mArray.add(mItem);
        }//무비 객체 배열 초기화(ArrayList)에 값으로 생성

        mAdapter = new MovieAdapter(this, mArray);
        list.setAdapter(mAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Movie item = (Movie)list.getItemAtPosition(i);
                String t = item.getTitle();
                Toast.makeText(getApplicationContext(), "선택: "+ t, Toast.LENGTH_SHORT).show();
            }
        });
    }
}