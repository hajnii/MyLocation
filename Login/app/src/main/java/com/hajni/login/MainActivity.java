package com.hajni.login;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText txtEmail;
    EditText txtPass;
    EditText txtPassW;
    Button btnJoin;
    Button btnLogin;
    EditText editEmail;
    EditText editPass;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtEmail = findViewById(R.id.txtEmail);
        txtPass = findViewById(R.id.txtPass);
        txtPassW = findViewById(R.id.txtPassW);
        btnJoin = findViewById(R.id.btnJoin);
        btnLogin = findViewById(R.id.btnLogin);


        btnJoin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String email = txtEmail.getText().toString().trim();
                String pass = txtPass.getText().toString().trim();
                String passW = txtPassW.getText().toString().trim();

                if (email.indexOf("@") != -1){

                }else {
                    Toast.makeText(MainActivity.this,"이메일을 바르게 입력하세요.",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pass.length() >= 6 && pass.length() <= 12){

                }else {
                    Toast.makeText(MainActivity.this,"비밀번호는 6자리 이상, 12자리 이하입니다.",Toast.LENGTH_SHORT).show();
                    return;
                }

                if (pass.equals(passW)){
                    Intent i = new Intent(MainActivity.this,Join.class);
                    i.putExtra("email",email);
                    startActivity(i);
                    finish();

                }else {
                    Toast.makeText(MainActivity.this,"비밀번호를 일치하여 주십시오.",Toast.LENGTH_SHORT).show();
                    return;
                }
            }
        });
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                createPopupDialog();
            }

            public void createPopupDialog(){
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                View alertView = getLayoutInflater().inflate(R.layout.alert,null);

                editEmail = alertView.findViewById(R.id.editEmail);
                editPass = alertView.findViewById(R.id.editPass);

                alert.setView(alertView);
                alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String title = editEmail.getText().toString().trim();
                        String body = editPass.getText().toString().trim();

                        if(title.isEmpty()||body.isEmpty()){
                            Toast.makeText(MainActivity.this, "이메일이나 비번을 입력하세요.", Toast.LENGTH_SHORT).show();
                            return;
                        }

                    }
                });
                alert.setNegativeButton("No",null);
                alert.setCancelable(false);

                dialog = alert.create();
                dialog.show();
            }

        });

    }
}
