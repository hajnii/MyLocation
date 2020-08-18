package com.hajni.contactmanager;

import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.hajni.contactmanager.adapter.RecyclerViewAdapter;
import com.hajni.contactmanager.data.DatabaseHandler;
import com.hajni.contactmanager.model.Contact;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnAdd;
    RecyclerView recyclerView;  // 메인화면에 있는 리사이클러 뷰
    RecyclerViewAdapter recyclerViewAdapter;    // 우리가 만든, 하나의 셀을 연결시키는 어댑터
    ArrayList<Contact> contactsArrayList;   // 데이터베이스에서 읽어온 주소록 정보를 저장할 리스트

    DatabaseHandler db = new DatabaseHandler(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = findViewById(R.id.btnAdd);
        // 리사이클러뷰 연결하고, 기본적인 셋팅.
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));


        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 새로운 엑티비티실행
                Intent i = new Intent(MainActivity.this,AddContact.class);
                startActivity(i);


            }
        });
//        DatabaseHandler db = new  DatabaseHandler(MainActivity.this);
//        //디비 테이블에 저장된 데이터 갯수 가져오는 메소드 호출.
//        int count = db.getCount();
//        Log.i("myDB","countacts 테이블에 저장된 데이터 갯수 : "+ count);

//
//        Contact contact = db.getContact(1);
//        Log.i("myDB","아이디 3번 데이터" + contact.getId()+", "+
//                contact.getName()+", "+ contact.getPhoneNumber());
//        // 삭제 테스트
//        db.deleteContact(contact);

        // 업데이트 테스트
//        Contact contact = db.getContact(2);
//        Log.i("myDB","저장된 주소록의 데이터 ID : " + contact.getId() + "이름은 : " + contact.getName() + " 전화번호는 : " + contact.getPhoneNumber());
//
//        contact.setName("김하진");
//        // 업데이트 메소드 실행.
//        db.updateContact(contact);
    }



    protected void onResume() {
        super.onResume();
        // 데이터베이스에서 테이블 저장된 데이터 읽어서, 어레이리스트에 저장
        DatabaseHandler db = new  DatabaseHandler(MainActivity.this);
        contactsArrayList = db.getAllContacts();

        // 우리가만든 하나의 셀 표시하는 어댑터를, 리사이클러뷰에 연결
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactsArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
    // 메인액티비티에, refresh 메소드 우리가 하나 만듬. 데이터베이스에서 정보 가져와서, 화면 갱신
    public void refresh() {
        DatabaseHandler db = new  DatabaseHandler(MainActivity.this);
        contactsArrayList = db.getAllContacts();
        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactsArrayList);
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerViewAdapter.notifyDataSetChanged();
    }
}
