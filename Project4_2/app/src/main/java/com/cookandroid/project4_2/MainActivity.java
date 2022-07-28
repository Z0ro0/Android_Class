package com.cookandroid.project4_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView txtPat;
    CheckBox chk;
    RadioGroup rg;
    Button btnOK;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("임재연");
        chk=findViewById(R.id.chk);
        txtPat=findViewById(R.id.txtPet);
        rg=findViewById(R.id.rg);
        btnOK=findViewById(R.id.btnOK);
        img=findViewById(R.id.img);
        chk.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (chk.isChecked()){//true
                    txtPat.setVisibility(View.VISIBLE);
                    rg.setVisibility(View.VISIBLE);
                    btnOK.setVisibility(View.VISIBLE);
                    img.setVisibility(View.VISIBLE);
                }
                else {
                    txtPat.setVisibility(View.INVISIBLE);
                    rg.setVisibility(View.INVISIBLE);
                    btnOK.setVisibility(View.INVISIBLE);
                    img.setVisibility(View.INVISIBLE);
                    rg.clearCheck();
                    img.setImageDrawable(null);
                }
            }
        });
    }
}
