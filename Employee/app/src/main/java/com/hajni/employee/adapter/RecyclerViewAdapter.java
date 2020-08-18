package com.hajni.employee.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hajni.employee.MainActivity;
import com.hajni.employee.R;
import com.hajni.employee.model.Contact;

import java.util.ArrayList;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{
    Context context;
    ArrayList<Contact> contactList;

    public RecyclerViewAdapter(Context context, ArrayList contactList){
        this.context = context;
        this.contactList = contactList;
    }


    // 5. 오버라이딩 함수 구현 - RecyclerViewAdapter.ViewHolder 로 함수 리턴값 변경
    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        // 리턴에, 위에서 생성한 뷰를, 뷰홀더에 담아서 리턴한다.
        return new ViewHolder(view);


    }

    // 6.  RecyclerViewAdapter.ViewHolder 로 함수 파라미터 변경
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        // 어레이 리스트에 저장된 데이터를 화면과 연결 : bind
        Contact contact = contactList.get(position);
        String name = contact.getName();
        int age = contact.getAge();
        int salary = contact.getSalary();
        // 2. 뷰홀더에 있는 텍스트뷰에 문자열을 셋팅한다.
        holder.txtName.setText("" + name);
        holder.txtAge.setText("나이 : "+ + age + "세");
        holder.txtSalary.setText("연봉 : $" + salary);
    }

    // 7. 아이템갯수 리턴하는 메소드 구현
    @Override
    public int getItemCount() {
        return contactList.size();
    }

    // 1. 뷰홀더 클래스 먼저 만든다.
    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView txtName;
        public TextView txtAge;
        public TextView txtSalary;

        public CardView cardView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            txtName = itemView.findViewById(R.id.txtName);
            txtAge = itemView.findViewById(R.id.txtAge);
            txtSalary = itemView.findViewById(R.id.txtSalary);
            cardView = itemView.findViewById(R.id.cardView);

        }
    }
}
