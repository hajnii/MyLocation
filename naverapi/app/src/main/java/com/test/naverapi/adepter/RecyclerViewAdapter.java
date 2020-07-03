package com.test.naverapi.adepter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.naverapi.R;
import com.test.naverapi.model.Naver;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<Naver> naverArrayList;

    public RecyclerViewAdapter(Context context, ArrayList<Naver> naverArrayList) {
        this.context = context;
        this.naverArrayList = naverArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {

        Naver naver = naverArrayList.get(position);
        String title = naver.getTitle;
        String body = naver.getData;

        holder.editTitle.setText("" + title);
        holder.txtBody.setText("" + body);
    }


    @Override
    public int getItemCount() {
        return naverArrayList.size();
    }
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView editTitle;
        public TextView txtBody;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            editTitle = itemView.findViewById(R.id.editTitle);
            txtBody = itemView.findViewById(R.id.txtBody);
        }
    }
}
