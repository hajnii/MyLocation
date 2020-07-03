package com.hajni.youtube2.adapter;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.hajni.youtube2.R;
import com.hajni.youtube2.SecondActivity;
import com.hajni.youtube2.model.Youtube;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<Youtube> youtubeArrayList;


    public RecyclerViewAdapter(Context context, ArrayList<Youtube> youtubeArrayList) {
        this.context = context;
        this.youtubeArrayList = youtubeArrayList;
    }






    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Youtube youtube = youtubeArrayList.get(position);
        final String videoId = youtube.getVideoId();
        String title = youtube.getTitle();
        String description = youtube.getDescription();
        final String mediumUrl = youtube.getMediumUrl();
        final String highUrl = youtube.getHighUrl();

        holder.txtTitle.setText(title);
        holder.txtDescription.setText(description);



        GlideUrl glideUrl = new GlideUrl(mediumUrl,
                new LazyHeaders.Builder().addHeader("User-Agent","Your-User-Agent").build());


        // Glide 로 받아오기.
        Glide.with(context).load(glideUrl).into(holder.imgYoutube);
        holder.imgYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, SecondActivity.class);
                i.putExtra("highUrl",highUrl);
                context.startActivity(i);
            }
        });


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/watch?v=" + videoId));
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return youtubeArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtTitle;
        public TextView txtDescription;
        public ImageView imgYoutube;
        public CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtDescription = itemView.findViewById(R.id.txtDescription);
            imgYoutube = itemView.findViewById(R.id.imgYoutube);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }


}
