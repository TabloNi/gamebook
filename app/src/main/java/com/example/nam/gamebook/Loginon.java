package com.example.nam.gamebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Loginon extends AppCompatActivity {
    private Button btnLogout,item,diary,map,memo;
    private Session session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loginon);


        session = new Session(this);
        if(!session.loggedin()){
            logout();
        }
        btnLogout = (Button)findViewById(R.id.btnLogout);


        //왜인지는 모르겠는데 인텐트써서 간단하게 스위치 케이스로 옮길려고했더니 오류나서 코드가 너무더럽...죄송합니다ㅠㅠ

        item = (Button)findViewById(R.id.item);
        item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Loginon.this,item.class));
            }
        });

        memo = (Button)findViewById(R.id.memo);
        memo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Loginon.this,memo.class));
            }
        });

        diary = (Button)findViewById(R.id.diary);
        diary.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Loginon.this,diary.class));
            }
        });

        map = (Button)findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Loginon.this,map.class));
            }
        });

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logout();
            }
        });
    }


    private void logout(){
        session.setLoggedin(false);
        finish();
        startActivity(new Intent(Loginon.this,Login.class));
    }


}
