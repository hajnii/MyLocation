package com.test.mylocation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.mylocation.R;
import com.test.mylocation.data.Store;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    Context context;
    ArrayList<Store> storeArrayList;

    public RecyclerViewAdapter(Context context, ArrayList<Store> storeArrayList) {
        this.context = context;
        this.storeArrayList = storeArrayList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        Store store = storeArrayList.get(position);
        double lat = store.getLat();
        double lng = store.getLng();
        String id = store.getId();
        String name = store.getName();
        String vicinity = store.getVicinity();

        holder.txtlat.setText(""+lat);
        holder.txtlng.setText(""+lng);
        holder.txtname.setText(name);
        holder.txtvicinity.setText(vicinity);

    }

    @Override
    public int getItemCount() {
        return storeArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtlat;
        TextView txtlng;
        TextView txtname;
        TextView txtvicinity;


        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txtlat = itemView.findViewById(R.id.txtlat);
            txtlng = itemView.findViewById(R.id.txtlng);
            txtname = itemView.findViewById(R.id.txtname);
            txtvicinity = itemView.findViewById(R.id.txtvicinity);
        }
    }

}
