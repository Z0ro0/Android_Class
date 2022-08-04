package com.cookandroid.and_0803_cuslistcar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.graphics.Movie;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView list;
    CarAdapter cAdapter;
    ArrayList<Car> cArray;
    Car cItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer[] poster = {R.drawable.lena256, R.drawable.renoir01, R.drawable.renoir02, R.drawable.renoir03,
                R.drawable.renoir04, R.drawable.renoir05, R.drawable.renoir06, R.drawable.renoir07,
                R.drawable.renoir08, R.drawable.renoir09};

        String[] title = {"그림1", "그림2", "그림3", "그림4", "그림5", "그림6", "그림7", "그림8", "그림9", "그림10"};

        list = findViewById(R.id.list);

        cArray = new ArrayList<>();

        for (int i = 0; i <poster.length; i++){
            cItem = new Car(ContextCompat.getDrawable(this, poster[i]), title[i]);
            cArray.add(cItem);
        }//무비 객체 배열 초기화(ArrayList)에 값으로 생성

        cAdapter = new CarAdapter(this, cArray);
        list.setAdapter(cAdapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Car item = (Car)list.getItemAtPosition(i);
                customToast(item);
            }
        });
    }

    public void customToast(Car item){
        View layout = getLayoutInflater().inflate(R.layout.car_toast, null);//car_toast 불러오기
        ImageView img = layout.findViewById(R.id.toast_img);
        TextView txt = layout.findViewById(R.id.toast_txt);
        img.setImageDrawable(item.getImage());
        txt.setText(item.getTitle());

        Toast t = new Toast(getApplicationContext());
        t.setView(layout);
        t.setGravity(Gravity.CENTER_VERTICAL, 0, 0);

        t.show();
    }
}