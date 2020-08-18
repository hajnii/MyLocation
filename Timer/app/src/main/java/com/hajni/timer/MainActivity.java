package com.hajni.timer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int remainingTime;

    ImageView imgTime;
    TextView txtTime;
    EditText TimeStting;
    Button btnfinish;
    Button btnstart;

    int sec;
    long millisec;

    CountDownTimer timer;

//    int initCountMillis ;
//    int timerInterval = 1000;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTime = findViewById(R.id.txtTime);
        TimeStting = findViewById(R.id.TimeStting);
        btnfinish = findViewById(R.id.btnfinish);
        btnstart = findViewById(R.id.btnstart);

        btnstart.setOnClickListener(new View.OnClickListener() {
            String secStr = TimeStting.getText().toString().trim();
            sec = Integer.parseInt(secStr);
            timer = new CountDownTimer(50000,1000){

            }
            @Override
            public void onClick(View v) {

            }
        });

        btnfinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                timer.cancel();
                TimeStting.setText(""+sec);
            }
        });
    }
}
