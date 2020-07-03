package com.hajni.customalert.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.hajni.customalert.R;
import com.hajni.customalert.model.CustomAlert;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<CustomAlert> customAlertArrayList;

    public RecyclerViewAdapter(Context context,ArrayList contactList){
        this.context = context;
        this.customAlertArrayList = contactList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        CustomAlert customAlert = customAlertArrayList.get(position);
        String title = customAlert.getTitle();
        String body = customAlert.getBody();

        holder.txtTitle.setText(title);
        holder.txtBody.setText(body);

    }

    @Override
    public int getItemCount() {
        return customAlertArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtTitle;
        public TextView txtBody;
        public ImageView imgDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtBody = itemView.findViewById(R.id.txtBody);
            imgDelete = itemView.findViewById(R.id.imgDelete);

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder deletelAlert = new AlertDialog.Builder(context);
                    deletelAlert.setTitle("삭제");
                    deletelAlert.setMessage("삭제하시겠습니까?");
                    deletelAlert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            notifyItemRemoved(getAdapterPosition());
                        }
                    });
                    deletelAlert.setNegativeButton("NO", null);
                    deletelAlert.setCancelable(false);
                    deletelAlert.show();
                }
            });

        }
    }
}
