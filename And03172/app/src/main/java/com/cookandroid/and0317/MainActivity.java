package com.cookandroid.and0317;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ResourceType")
    TextView txtName ;
    Button btnOK;

    @SuppressLint("ResourceType")
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtName = findViewById(R.id.txtName);
        btnOK = findViewById(R.id.btn);
        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(txtName.getText().equals("미림"))
                    txtName.setText("과학고");
                else txtName.setText("미림");
                Toast.makeText(getApplicationContext(), "변경: " + txtName.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}