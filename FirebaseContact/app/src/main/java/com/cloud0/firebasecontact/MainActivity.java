package com.cloud0.firebasecontact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.cloud0.firebasecontact.adapter.RecyclerViewAdapter;
import com.cloud0.firebasecontact.model.Contact;
import com.cloud0.firebasecontact.util.Util;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    Button contactBtn;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    ArrayList<Contact> contactArrayList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contactBtn = findViewById(R.id.contactBtn);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        contactBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,AddContact.class);
                startActivity(intent);
            }
        });




    }

    @Override
    protected void onResume() {
        super.onResume();
        FirebaseFirestore db = FirebaseFirestore.getInstance();

        db.collection(Util.TABLE_NAME).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                contactArrayList.clear();
                for (QueryDocumentSnapshot snapshot :queryDocumentSnapshots) {
                    String id = snapshot.getId();
                    Log.i("AAA", "ID : " + id);
                    // set 한 모델클래스랑 동실시 저장을 해줌
                    Contact contact = snapshot.toObject(Contact.class);
                    contact.setId(id);
                    contactArrayList.add(contact);
                }
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactArrayList);
                recyclerView.setAdapter(recyclerViewAdapter);
            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.i("AAA","error : "+e);
            }
        });
    }
}