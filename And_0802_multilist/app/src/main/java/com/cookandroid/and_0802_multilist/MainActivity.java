package com.cookandroid.and_0802_multilist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.SparseBooleanArray;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText edtAdd;
    Button btnAdd, btnDelete;
    ListView list;
    
    ArrayList<String> data = new ArrayList<>();
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        edtAdd= findViewById(R.id.edtAdd);
        btnAdd= findViewById(R.id.btnAdd);
        btnDelete= findViewById(R.id.btnDelete);
        list= findViewById(R.id.list);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_multiple_choice, data);
        list.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);//여러개 선택 가능
        list.setAdapter(adapter);
        
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.add(edtAdd.getText().toString());
                adapter.notifyDataSetChanged();//데이터 추가로 새로 고침
                edtAdd.setText(" ");
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SparseBooleanArray sbArray = list.getCheckedItemPositions();
                if(sbArray.size() != 0){
                    for (int i = list.getCount()-1; i>=0; i--){
                        if(sbArray.get(i))data.remove(i);
                    }
                    list.clearChoices();
                    adapter.notifyDataSetChanged();
                }
            }
        });
    }
}