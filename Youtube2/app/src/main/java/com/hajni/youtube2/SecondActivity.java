package com.hajni.youtube2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

public class SecondActivity extends AppCompatActivity {

    ImageView secondImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        secondImg = findViewById(R.id.secondImg);

        Intent i = getIntent();
        String imgUrl = i.getStringExtra("highUrl");

        GlideUrl glideUrl = new GlideUrl(imgUrl,
                new LazyHeaders.Builder().addHeader("User-Agent","Your-User-Agent").build());


        // Glide 로 받아오기.
        Glide.with(SecondActivity.this).load(glideUrl).into(secondImg);
    }

}
