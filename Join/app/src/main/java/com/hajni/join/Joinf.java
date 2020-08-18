package com.hajni.join;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Joinf extends AppCompatActivity {

    TextView txtRecv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joinf);

        txtRecv = findViewById(R.id.txtRecv);

        String emailview = getIntent().getStringExtra("email");
        String passwd = getIntent().getStringExtra("passwd");
        txtRecv.setText(emailview +" 님의 회원가입을 축하드립니다.");

        // 이메일과 패스워드를, 쉐어드 프리퍼런스에 저장한다.
        SharedPreferences sp = getSharedPreferences("Join_pref",MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("email",emailview);
        editor.putString("passwd",passwd);
        editor.apply();

    }
}