package com.test.employee2.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.test.employee2.R;
import com.test.employee2.model.Data;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
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
        int id = data.getId();
        String name = data.getName();
        int age = data.getAge();
        int salary = data.getSalary();

        holder.employee_name.setText(name);
        holder.employee_age.setText("나이 : "+ + age + "세");
        holder.employee_salary.setText("연봉 : $" + salary);
    }

    @Override
    public int getItemCount() {
        return dataArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView employee_name;
        TextView employee_age;
        TextView employee_salary;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            employee_name = itemView.findViewById(R.id.employee_name);
            employee_age = itemView.findViewById(R.id.employee_age);
            employee_salary = itemView.findViewById(R.id.employee_salary);

        }
    }
}
