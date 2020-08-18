package com.test.mylocation.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.test.mylocation.MainActivity;
import com.test.mylocation.MapsActivity;
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
        final double lat = store.getLat();
        final double lng = store.getLng();
        String id = store.getId();
        final String name = store.getName();
        String vicinity = store.getVicinity();

        holder.txtlat.setText(""+lat);
        holder.txtlng.setText(""+lng);
        holder.txtname.setText(name);
        holder.txtvicinity.setText(vicinity);

//        holder.cardView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(context, MapsActivity.class);
//                i.putExtra("lat", lat);
//                i.putExtra("lng", lng);
//                i.putExtra("name", name);
//                context.startActivity(i);
//            }
//        });

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
        CardView cardView;


        public ViewHolder(@NonNull View itemView){
            super(itemView);
            txtlat = itemView.findViewById(R.id.txtlat);
            txtlng = itemView.findViewById(R.id.txtlng);
            txtname = itemView.findViewById(R.id.txtname);
            txtvicinity = itemView.findViewById(R.id.txtvicinity);
            cardView = itemView.findViewById(R.id.cardView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int index = getAdapterPosition();
                    Store store = storeArrayList.get(index);
                    Intent i = new Intent(context,MapsActivity.class);
                    i.putExtra("store",store);
                    context.startActivity(i);
                }
            });
        }
    }

}
