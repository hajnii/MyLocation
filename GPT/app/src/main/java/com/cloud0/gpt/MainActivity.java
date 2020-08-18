package com.cloud0.gpt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import com.cloud0.gpt.calender.Calender;
import com.cloud0.gpt.signUp.SignUpActivity;


public class MainActivity extends AppCompatActivity {

    EditText signIn_editId;
    EditText signIn_editPassword;
    Switch signIn_switch;
    Button signIn_signInBtn;
    TextView signIn_signUpBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signIn_editId = findViewById(R.id.signIn_editId);
        signIn_editPassword = findViewById(R.id.signIn_editPassword);
        //signIn_switch = findViewById(R.id.signIn_switch);
        signIn_signInBtn = findViewById(R.id.signIn_signInBtn);
        signIn_signUpBtn = findViewById(R.id.signIn_signUpBtn);



        // 임시 인텐트
        signIn_signInBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Calender.class);
                startActivity(intent);
            }
        });

        signIn_signUpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}