package com.hajni.memo.adapter;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.hajni.memo.R;
import com.hajni.memo.UpdateMemo;
import com.hajni.memo.data.DatabaseHandler;
import com.hajni.memo.model.Contact;

import java.util.ArrayList;

// 마지막으로, 어댑터에, 우리가 만든 뷰홀더를 연결합니다.
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    //멤버변수 셋팅
    Context context;
    ArrayList<Contact> contactList;


    // 1. 생성자 만들기
    public RecyclerViewAdapter(Context context, ArrayList contactList){
        this.context = context;
        this.contactList = contactList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 첫번째 파라미터인, parent 로 부터 뷰를 생성한다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        // 리턴에, 위에서 생성한 뷰를, 뷰홀더에 담아서 리턴한다.
        return new ViewHolder(view);
    }

    // 리스트에 있는 데이터와, 화면에 있는 뷰 (텍스트뷰, 이미지뷰...)에 표시하는 메소드
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        // 1. 해당 포지션의 데이터 가져와서
        Contact contact = contactList.get(position);
        String title = contact.getTitle();
        String contents = contact.getContents();
        // 2. 뷰홀더에 있는 텍스트뷰에 문자열을 셋팅한다.
        holder.txtTitle.setText(title);
        holder.txtContent.setText(contents);
    }

    // 리스트에 있는 데이터의 갯수를 리턴해줘야한다.
    @Override
    public int getItemCount() {
        return contactList.size();
    }

    // 하나의 셀 xml 화면에 있는 구성요소(텍스트뷰, 이미지뷰 ...)를 여기서 연결한다.
    public class ViewHolder extends RecyclerView.ViewHolder{
        // 멤버변수
        public TextView txtTitle;
        public TextView txtContent;
        public ImageView imgDelete;

        // 카드뷰 클릭하면 화면 넘어갈 수 있도록, 멤버 변수 셋팅
        public CardView cardView;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            // 2. 생성자 안에서, 멤버변수 연결
            txtTitle = itemView.findViewById(R.id.txtTitle);
            txtContent = itemView.findViewById(R.id.txtContents);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            cardView = itemView.findViewById(R.id.cardView);

            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 수정 액티비티

                    // 수정 액티비티로 넘어가는 코드 작성.
                    Intent i = new Intent(context, UpdateMemo.class);


                    int index = getAdapterPosition();
                    Contact contact = contactList.get(index);
                    int id = contact.getId();
                    String title = contact.getTitle();
                    String contents = contact.getContents();
                    // 업데이트
                    i.putExtra("id",id);
                    i.putExtra("title",title);
                    i.putExtra("contents",contents); // 이름을정해서 보낸다

                    // 새로운 화면을 띄우는 startActivity 함수는, 액티비티 클래스의 메소드 이므로,
                    // context.startActivity 해야 함. 왜냐면, context == MainActivity.this
                    context.startActivity(i);



                    Toast.makeText(context,"이 셀은" + getAdapterPosition() + "번째 셀입니다.",Toast.LENGTH_SHORT).show();
                    //getAdapterPosition() 함수는, 현재 내가 클릭한 부분이 몇번째 셀인지 알려준다.
                }
            });

            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder deletelAlert = new AlertDialog.Builder(context);
                    deletelAlert.setTitle("연락처 삭제");
                    deletelAlert.setMessage("삭제하시겠습니까?");
                    deletelAlert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 데이터베이스에서 삭제
                            int index = getAdapterPosition();
                            Contact contact = contactList.get(index);
                            final DatabaseHandler dh = new DatabaseHandler(context);
                            dh.deleteContact(contact);
                            // 데이터셋이 바꼈다는것을 알려주는 메소드
                            contactList = dh.getAllContacts();
//                            2. 방법 ((MainActivity)context).refresh();
                            notifyDataSetChanged();
//                            3. 방법 notifyItemChanged(index);

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