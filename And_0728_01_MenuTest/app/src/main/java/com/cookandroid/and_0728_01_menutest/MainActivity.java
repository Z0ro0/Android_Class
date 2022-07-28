package com.cookandroid.and_0728_01_menutest;

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
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnContext, btnOption;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메뉴실습 최가을");

        btnContext = findViewById(R.id.btnContext);
        btnOption = findViewById(R.id.btnOption);

        registerForContextMenu(btnContext);//컨텍스트 메뉴로 사용되는 위젯은 반드시 등록register하기


        btnOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu p = new PopupMenu(getApplicationContext(), view);
                getMenuInflater().inflate(R.menu.menu_popup, p.getMenu());

                p.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem menuItem) {
                        switch (menuItem.getItemId()){
                            case R.id.popup_1:
                                Toast.makeText(getApplicationContext(), "1학년 선택", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.popup_2:
                                Toast.makeText(getApplicationContext(), "2학년 선택", Toast.LENGTH_SHORT).show();
                                return true;
                            case R.id.popup_3:
                                Toast.makeText(getApplicationContext(), "3학년 선택", Toast.LENGTH_SHORT).show();
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
    }
    //옵션메뉴, 컨텍스트 메뉴 생성하고 item 선택 처리 구현

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
            case R.id.option_login: 
                Toast.makeText(getApplicationContext(), "로그인 선택", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.option_loginOut:
                Toast.makeText(getApplicationContext(), "로그아웃 선택", Toast.LENGTH_SHORT).show();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택 안 됨", Toast.LENGTH_SHORT).show();
                return false;
        }
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        MenuInflater menuInflater = getMenuInflater();

        if(v==btnContext){
            menu.setHeaderTitle("성별 선택");
            menuInflater.inflate(R.menu.menu_context,menu);
        }
    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
         super.onContextItemSelected(item);
         
        switch (item.getItemId()){
            case R.id.context_man:
                Toast.makeText(getApplicationContext(), "남자 선택", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.context_woman:
                AlertDialog.Builder dlg = new AlertDialog.Builder(MainActivity.this);
                dlg.setTitle("성별선택확인");
                dlg.setIcon(R.mipmap.ic_launcher_round);
                dlg.setMessage("여자를 선택하였습니다.");
                dlg.setPositiveButton("확인", null);
                dlg.show();
                return true;
            default:
                Toast.makeText(getApplicationContext(), "선택 안 됨", Toast.LENGTH_SHORT).show();
                return false;
        }
    }
}