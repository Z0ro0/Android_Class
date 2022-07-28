package com.cookandroid.and_0728_02_menutest2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btngender, btnjoin;
    EditText edtpn, edtgender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnjoin = findViewById(R.id.btnjoin);
        btngender = findViewById(R.id.btngender);
        edtpn = findViewById(R.id.edtpn);
        edtgender = findViewById(R.id.edtgender);

        btngender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(edtpn.getText().toString());

                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.popup_menu, p.getMenu());

                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.popup_man:
                                edtgender.setText("남자");
                                return true;
                            case R.id.popup_woman:
                                edtgender.setText("여자");
                                return true;
                            default:
                                Toast.makeText(getApplicationContext(), "선택 안 됨", Toast.LENGTH_SHORT).show();
                                return false;
                        }
                    }
                });
                p.show();

            }
        });

        btnjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("가입정보확인");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                dlg.setMessage("전화번호: " + edtpn.getText().toString() + "\n" + edtgender.getText().toString());
                dlg.setPositiveButton("확인", null);
                dlg.show();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);

        MenuInflater minflater = getMenuInflater();
        minflater.inflate(R.menu.menu_option, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.option_reset:
                Toast.makeText(getApplicationContext(), "초기화", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option_off:
                Toast.makeText(getApplicationContext(), "종료", Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택 안 됨", Toast.LENGTH_SHORT).show();
                return false;
        }
    }


}