package com.hajni.photos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;

public class ImgActivity extends AppCompatActivity {

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_img);

        image = findViewById(R.id.image);


        Intent i = getIntent();
        String img = i.getStringExtra("url");

        GlideUrl glideUrl = new GlideUrl(img,
                new LazyHeaders.Builder().addHeader("User-Agent","Your-User-Agent").build());


        // Glide 로 받아오기.
        Glide.with(ImgActivity.this).load(glideUrl).into(image);


    }
}
