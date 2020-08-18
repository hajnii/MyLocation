package com.hajni.join;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText join_email;
    EditText join_pass;
    EditText join_passW;
    Button btnjoin;
    Button btnlogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        join_email = findViewById(R.id.join_email);
        join_pass = findViewById(R.id.join_pass);
        join_passW = findViewById(R.id.join_passW);
        btnjoin = findViewById(R.id.btnjoin);
        btnlogin = findViewById(R.id.btnlogin);


        btnjoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = join_email.getText().toString().trim();
                String pass = join_pass.getText().toString().trim();
                String passW = join_passW.getText().toString().trim();


                if (email.indexOf("@") != -1) {
                    if (pass.length() >= 6 && pass.length() <= 12) {
                        if (pass.equals(passW)) {
                            Intent i = new Intent(MainActivity.this, Mainphoto.class);
                            i.putExtra("email", email);
                            i.putExtra("passwd",pass);
                            startActivity(i);
                            finish();

                        } else {
                            Toast.makeText(MainActivity.this, "비번틀림", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        Toast.makeText(MainActivity.this, "비번갯수", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "이메일ㄴㄴ", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });
    }
}
