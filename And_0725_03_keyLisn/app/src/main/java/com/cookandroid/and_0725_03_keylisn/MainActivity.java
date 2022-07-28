package com.cookandroid.and_0725_03_keylisn;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        in = findViewById(R.id.in);

        in.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if(keyEvent.getAction()==KeyEvent.ACTION_UP){
                    Toast.makeText(getApplicationContext(), in.getText().toString() , Toast.LENGTH_SHORT).show();
                }
                return false;
            }
        });

    }
}