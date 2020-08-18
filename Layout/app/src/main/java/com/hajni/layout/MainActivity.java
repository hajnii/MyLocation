package com.hajni.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView imageCat;
    EditText textAge;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        imageCat = findViewById(R.id.imageCat);
        textAge = findViewById(R.id.textAge);

        Button click = findViewById(R.id.btnClick);
        btnClick.setImageResource(R.drawable.imageCat);

    }
}
