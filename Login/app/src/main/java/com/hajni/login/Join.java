package com.hajni.login;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Join extends AppCompatActivity {

    TextView txtId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join);

        txtId = findViewById(R.id.txtId);

        String emailView = getIntent().getStringExtra("email");
        txtId.setText(emailView + "님 회원가입을 환영합니다.");
    }
}
