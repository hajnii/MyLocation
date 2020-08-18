package com.cloud0.firebasecontact.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.cloud0.firebasecontact.MainActivity;
import com.cloud0.firebasecontact.R;
import com.cloud0.firebasecontact.UpdateContact;
import com.cloud0.firebasecontact.model.Contact;
import com.cloud0.firebasecontact.util.Util;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;


import java.util.ArrayList;

// 마지막으로, 어댑터에, 우리가 만든 뷰홀더를 연결합니다.
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    // member variable setting
    Context context;
    ArrayList<Contact> contactList;
    int id;


    //1. create constructor                     생성자에 Context 가 있어서  mainActivity 가  입력됨
    public RecyclerViewAdapter(Context context, ArrayList<Contact> contactsList){
            this.context = context;
            this.contactList = contactsList;
    }

    @NonNull
    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 첫번째 파라미터인 , parent 로 부터 뷰(화면:하나의 셀)를 생성한다.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contact_row,parent,false);
        // 리턴에, 위에서 생성한 뷰를 , 뷰홀더에 담아서 리턴한다.
        return new ViewHolder(view);

    }

    // 리스트에 있는 데이터를 화면에 있는 뷰(텍스트뷰, 이미지뷰....)에 표시하는 메소드
    @Override
    public void onBindViewHolder(@NonNull RecyclerViewAdapter.ViewHolder holder, int position) {
        // 1. 해당 포지션의 데이터 가져와서
        Contact contact = contactList.get(position);
        String name = contact.getName();
        String phone = contact.getPhoneNumber();
        // 2. 뷰홀더에 있는 텍스트뷰에 문자열을 셋팅한다.
        ((ViewHolder)holder).txtName.setText(name);
        holder.txtPhone.setText(phone);

    }

    // 리스트에 있는 데이터의 갯수를 리턴해줘야 한다.
    @Override
    public int getItemCount() {
        return contactList.size();
    }

    // 하나의 셀  xml 화면에 있는 구성요소(텍스트부, 이미지뷰 .... ) 를 여기서 연결한다.
    public class ViewHolder extends RecyclerView.ViewHolder{
        // member variable
        public TextView txtName;
        public TextView txtPhone;
        public ImageView imgDelete;
        public CardView cardView;
        int index;
        // cardView member variable setting
        public ViewHolder(@NonNull final View itemView) {
            super(itemView);

            //2. 생성자 안에서, 멤버변수 연결
            txtName = itemView.findViewById(R.id.txtName);
            txtPhone = itemView.findViewById(R.id.txtPhone);
            imgDelete = itemView.findViewById(R.id.imgDelete);
            cardView = itemView.findViewById(R.id.cardView);
            // ViewHolder 안에서 event 처리
            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 수정 엑티비티로 넘어가는 코드 작성
                    Intent intent = new Intent(context, UpdateContact.class);
                    // 유저가 클릭한 셀의 인데스를 자져온다. 이 인덱스만 알면, 어레이 리스트에서 데이터 꺼내올수 있다.
                    index = getAdapterPosition();
                    Contact contact = contactList.get(index);
                    intent.putExtra("Contact",contact);

                    // 새로운 화면을 뛰우는 startActivity 함수는, 엑티비티 클래스의 메소드 이므로,
                    // context.startActivity 해야함. 왜냐면, context == MainActivity.this
                    context.startActivity(intent);
                }
            });

            // X 버튼 처리
            imgDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    AlertDialog.Builder alert = new AlertDialog.Builder(context);
                    alert.setTitle("주소록 삭제");
                    alert.setMessage("정말 삭제하시겠습니까?");
                    alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // 데이터베이스에서 삭제.
                            Contact contact = contactList.get(getAdapterPosition());
                            String id = contact.getId();
                            FirebaseFirestore db = FirebaseFirestore.getInstance();
                            db.collection(Util.TABLE_NAME)
                                    .document(id)
                                    .delete().addOnSuccessListener(new OnSuccessListener<Void>() {
                                @Override
                                public void onSuccess(Void aVoid) {

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {

                                }
                            });
                            ((MainActivity)context).recreate();
                        }
                    });
                    alert.setNegativeButton("NO", null);
                    alert.setCancelable(false);
                    alert.show();
                    return;
                }
            });

        }
    }
}
