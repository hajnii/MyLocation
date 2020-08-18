package com.hajni.join;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;


public class Mainphoto extends AppCompatActivity {
    ImageView joinimg;
    Button btn1;
    Button btn2;
    Button btn3;

    String email;
    String passwd;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.photo);


        joinimg = findViewById(R.id.joinimg);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);

        // 이메일 넘겨받는 코드
        email = getIntent().getStringExtra("email");
        // 비밀번호도 넘겨 받아야함
        passwd = getIntent().getStringExtra("passwd");



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinimg.setImageResource(R.drawable.bunny);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                joinimg.setImageResource(R.drawable.turtle);
            }
        });

                btn3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        showMyAlery("회원가입완료" , "가입하시겠습니까?");
                    }
                });
            }
            void showMyAlery(String title, String message){
                AlertDialog.Builder failAlert = new AlertDialog.Builder(Mainphoto.this);
                failAlert.setTitle(title);
                failAlert.setMessage(message);
                failAlert.setPositiveButton("예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(Mainphoto.this,Joinf.class);

                i.putExtra("email",email);
                i.putExtra("passwd",passwd);
                startActivity(i);
                finish();
            }
        });
        failAlert.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//               moveTaskToBack(true); // 전에 있던 창이 있더라도 무시하고 종료

            }
        });
        failAlert.setCancelable(false);
        failAlert.show();
    }

}
