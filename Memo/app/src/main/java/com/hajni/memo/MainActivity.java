package com.hajni.memo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hajni.memo.adapter.RecyclerViewAdapter;
import com.hajni.memo.data.DatabaseHandler;
import com.hajni.memo.model.Contact;
import com.hajni.memo.util.Util;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button btnNewmemo;
    RecyclerView recyclerView;  // 메인화면에 있는 리사이클러 뷰
    RecyclerViewAdapter recyclerViewAdapter;    // 우리가 만든, 하나의 셀을 연결시키는 어댑터
    ArrayList<Contact> contactsArrayList;
    EditText txtSearch;
    Button btnSearch;
    Button btnNo;

    DatabaseHandler db = new DatabaseHandler(MainActivity.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnNewmemo = findViewById(R.id.btnNewmemo);
        txtSearch = findViewById(R.id.txtSearch);
        btnSearch = findViewById(R.id.btnSearch);
        btnNo = findViewById(R.id.btnNo);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        contactsArrayList = db.getAllContacts();

        txtSearch.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String search = txtSearch.getText().toString();
                DatabaseHandler db = new  DatabaseHandler(MainActivity.this);
                contactsArrayList = db.getAllContacts(search);

                // 우리가만든 하나의 셀 표시하는 어댑터를, 리사이클러뷰에 연결
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactsArrayList);
                recyclerView.setAdapter(recyclerViewAdapter);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = txtSearch.getText().toString();
                DatabaseHandler db = new  DatabaseHandler(MainActivity.this);
                contactsArrayList = db.getAllContacts(txt);

                // 우리가만든 하나의 셀 표시하는 어댑터를, 리사이클러뷰에 연결
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactsArrayList);
                recyclerView.setAdapter(recyclerViewAdapter);

            }
        });

        btnNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtSearch.setText("");
                DatabaseHandler db = new  DatabaseHandler(MainActivity.this);
                contactsArrayList = db.getAllContacts();

                // 우리가만든 하나의 셀 표시하는 어댑터를, 리사이클러뷰에 연결
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactsArrayList);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        });




        btnNewmemo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this,AddMemo.class);
                startActivity(i);
            }
        });
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
}
