package com.hajni.fingerspeed;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    // 상수선언
    public static final int TAB_COUNT = 100;

    TextView txtTimer;
    TextView txtCount;
    TextView cheat;
    Button btnTap;
    int remainingTime;

    int tap = TAB_COUNT;

    int initCountMillis = 10000;
    int timerInterval = 1000;

    CountDownTimer countDownTimer;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        txtTimer = findViewById(R.id.txtTimer);
        txtCount = findViewById(R.id.txtCount);
        btnTap = findViewById(R.id.btnTap);
        cheat = findViewById(R.id.cheat);


        countDownTimer = new CountDownTimer(initCountMillis,timerInterval){
            @Override
            public void onTick(long millisUntilFinished) {
                // txtTimer.setText("Time :"+ millisUntilFinished / 1000);
                remainingTime = (int)millisUntilFinished / 1000;
                txtTimer.setText(remainingTime + " 초");

                cheat.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (remainingTime == 0){
                            return;
                        }
                        if(tap <= 0){
                            return;
                        }
                        tap = tap - 10;
                        txtCount.setText(""+tap);
                        if (tap <= 0){
                            countDownTimer.cancel();
                            txtCount.setText("" + 0);
                            Toast.makeText(MainActivity.this,"성공하셨습니다.",Toast.LENGTH_SHORT).show();

                            String message = "기록은 " + (initCountMillis/1000 - remainingTime)+"초 입니다. 다시도전하시겠습니까?";
                            showMyAlery("성공" , message);
                        }
                    }
                });

                btnTap.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // 1. 타이머 남은 시간이 0인지 체크해서, 0이면 아래 실행 안하면 된다.
                        // 2. 탭수가 0인지 체크해서, 0이면 아래로 실행 안하면 된다.
                        // 3. 숫자 감소시키고
                        // 4. 감소된 숫자를 화면에 표시
                        if (remainingTime == 0){
                            return;
                        }
                        if(tap == 0){
                            return;
                        }
                        tap = tap - 1;
                        txtCount.setText(""+tap);

                        if (tap == 0){

                            countDownTimer.cancel();

                            Toast.makeText(MainActivity.this,"성공하셨습니다.",Toast.LENGTH_SHORT).show();

                            String message = "기록은 " + (initCountMillis/1000 - remainingTime)+"초 입니다. 다시도전하시겠습니까?";
                            showMyAlery("성공" , message);
                        }
                    }

                });
            }

            @Override
            public void onFinish() {
                Toast.makeText(MainActivity.this,"시간이 종료 되었습니다.",Toast.LENGTH_SHORT).show();
                txtTimer.setText("done!");
                if ( tap > 0){
                    showMyAlery("실패","다시도전하시겠습니까?");
                }
            }
        };
        countDownTimer.start();
        txtCount.setText(""+tap);

    }

    void showMyAlery(String title, String message){
        AlertDialog.Builder failAlert = new AlertDialog.Builder(MainActivity.this);
        failAlert.setTitle(title);
        failAlert.setMessage(message);
        failAlert.setPositiveButton("예", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                tap = TAB_COUNT;
                txtCount.setText("" + tap);
                countDownTimer.start();
            }
        });
        failAlert.setNegativeButton("아니오", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        failAlert.setCancelable(false);
        failAlert.show();
    }


}
