package com.hajni.todos.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hajni.todos.R;
import com.hajni.todos.model.Todo;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    Context context;
    ArrayList<Todo> todoArrayList;

    public RecyclerViewAdapter(Context context, ArrayList contactList){
        this.context = context;
        this.todoArrayList = contactList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        return new ViewHolder(view);


    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Todo todo = todoArrayList.get(position);
        String title = todo.getTitle();
        int userId = todo.getUserId();
        boolean completed = todo.isCompleted();
        // 2. 뷰홀더에 있는 텍스트뷰에 문자열을 셋팅한다.
        holder.txtTitle.setText(title);
        holder.txtId.setText("user Id : " + userId);

        if(completed == true){
            holder.txtCompleted.setText("성공");
        }else {
            holder.txtCompleted.setText("실패");
        }

    }

    @Override
    public int getItemCount() {
        return todoArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtId;
        public TextView txtTitle;
        public TextView txtCompleted;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtId = itemView.findViewById(R.id.txtId);
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtCompleted = itemView.findViewById(R.id.txtCompleted);
        }
    }
}
