package com.hajni.showguess;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ShowGuess extends AppCompatActivity {

    TextView txtRecv;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_guess);

        txtRecv = findViewById(R.id.txtRecv);

        Intent i = getIntent();
        String guess = i.getStringExtra("key");
        int number = i.getIntExtra("number",0);
        String myStr = i.getStringExtra("str");
        boolean myboo = i.getBooleanExtra("boo",false);

        String all = guess + " " + number + " " + myStr + " " + myboo;

        txtRecv.setText(all);
    }
}
