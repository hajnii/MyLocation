package com.hajni.join;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText login_id;
    EditText login_pw;
    Button btnLogin;
    CheckBox autologin;

    String savedEmail;
    String savedPassed;
    // 쉐어드 프리퍼런스를 멤버변수로 뺸다.
    SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        login_id = findViewById(R.id.login_id);
        login_pw = findViewById(R.id.login_pw);
        btnLogin = findViewById(R.id.btnLogin);
        autologin = findViewById(R.id.autologin);
        autologin = findViewById(R.id.autologin);


        sp = getSharedPreferences("Join_pref",MODE_PRIVATE);
        savedEmail = sp.getString("email",null);
        savedPassed = sp.getString("passwd",null);
        // 자동로그인 정보를 가져온다. 체크박스에서가져온다. 체크 되었는지, 안되었는지.
        if (autologin.isChecked()){
            Log.i("my_login","체크박스 쳌 되어있습.");
        }else {
            Log.i("my_login","체크박스 쳌 ㄴㄴ.");
        }

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 에디트 텍스트에 유저가 입력한 이메일과 비번을 가져와서
                // 쉐어드프리퍼런스에 저장되어있던, 저장된 이메일과 비번을 서로 비교.
                String email = login_id.getText().toString().trim();
                String passwd = login_pw.getText().toString().trim();

                if (savedEmail != null && savedPassed != null && savedEmail.equals(email) && savedPassed.equals(passwd)){
                    // 로그인 와료 화면 만드렁서, 이메일 정보를 전달해 준다.
                    if (autologin.isChecked()){
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putBoolean("auto_login",true);
                        editor.apply();
                    }else{
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putBoolean("auto_login",false);
                        editor.apply();
                    }


                    Intent i = new Intent(Login.this,AfterLogin.class);
                    i.putExtra("email",email);
                    startActivity(i);
                }else {
                    Toast.makeText(Login.this,"ㄴㄴ",Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.i("email",savedEmail);
            }
        });

        // 1. 자동로그인이, 쉐어드프리퍼런스에 저장되어 있는지 정보를 가져온다.
        boolean loginAuto = sp.getBoolean("auto_login",false);
        // 2. 자동로그인이 true 로 되어있으면, 이메일과 비밀번호를 에디트텍스트에 표시
        // 3. 체크박스에도, 체크표시를 합니다.
        if (loginAuto == true){
            login_id.setText(savedEmail);
            login_pw.setText(savedPassed);
            autologin.setChecked(true);
        }
    }
}
