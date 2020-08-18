package com.test.myfriends.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.test.myfriends.MainActivity;
import com.test.myfriends.R;
import com.test.myfriends.model.Data;

import java.util.ArrayList;
import java.util.Date;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<Data> dataArrayList;

    public RecyclerViewAdapter(Context context, ArrayList<Data> dataArrayList) {
        this.context = context;
        this.dataArrayList = dataArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Data data = dataArrayList.get(position);
        String name = data.getName();
        String phone = data.getPhone();

        holder.txtName.setText(name);
        holder.txtPhone.setText(phone);
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView txtName;
        TextView txtPhone;
        ImageView btnDelete;
        CardView cardView;

        FirebaseFirestore db = FirebaseFirestore.getInstance();

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            btnDelete = itemView.findViewById(R.id.btnDelete);
            cardView = itemView.findViewById(R.id.cardView);

            btnDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getAdapterPosition();
                    Data data = dataArrayList.get(index);
                    final String id = data.getId();

                    db.collection("Data")
                            .document(id)
                            .delete()
                            .addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {
                                    Toast.makeText(context,"김하진 바보",Toast.LENGTH_SHORT).show();
                                    ((MainActivity)context).recreate();
                                }
                            })
                            .addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Log.i("AAA",e.toString());
                                }
                            });

                }
            });
        }
    }
}
