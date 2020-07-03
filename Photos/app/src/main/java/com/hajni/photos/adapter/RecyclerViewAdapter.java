package com.hajni.photos.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.bumptech.glide.load.model.LazyHeaders;
import com.hajni.photos.R;
import com.hajni.photos.ImgActivity;
import com.hajni.photos.model.Photos;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHoler> {

    Context context;
    ArrayList<Photos> photosArrayList;



    public RecyclerViewAdapter(Context context, ArrayList contactList){
        this.context = context;
        this.photosArrayList = contactList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHoler onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        return new ViewHoler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHoler holder, int position) {

        Photos photos = photosArrayList.get(position);
        String title = photos.getTitle();
        final int userId = photos.getId();
        int albumId = photos.getAlbumld();
        String thumbnailUrl = photos.getThumbnailUrl();
        final String url = photos.getUrl();

        GlideUrl glideUrl = new GlideUrl(thumbnailUrl,
                new LazyHeaders.Builder().addHeader("User-Agent","Your-User-Agent").build());


        // Glide 로 받아오기.
        Glide.with(context).load(glideUrl).into(holder.imageView);


        holder.txtTitle.setText(title);
        holder.txtUserId.setText("userId : " + userId);
        holder.txtAlbumId.setText("albumId : " + albumId);

        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ImgActivity.class);
                i.putExtra("url" ,url);
                context.startActivity(i);
            }
        });

    }

    @Override
    public int getItemCount() {
        return photosArrayList.size();
    }

    public class ViewHoler extends RecyclerView.ViewHolder {

        public TextView txtTitle;
        public TextView txtUserId;
        public TextView txtAlbumId;
        public ImageView imageView;

        public ViewHoler(@NonNull View itemView) {
            super(itemView);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtUserId = itemView.findViewById(R.id.txtUserId);
            txtAlbumId = itemView.findViewById(R.id.txtAlbumId);
            imageView = itemView.findViewById(R.id.imageView);


        }
    }
}
