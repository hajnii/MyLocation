package com.cloud0.firebasecontact;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.cloud0.firebasecontact.model.Contact;
import com.cloud0.firebasecontact.util.Util;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class UpdateContact extends AppCompatActivity {

    EditText updateNameEdit;
    EditText updatePhoneEdit;
    Button updateBtn;
    String id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        updateNameEdit = findViewById(R.id.updateNameEdit);
        updatePhoneEdit = findViewById(R.id.updatePhoneEdit);
        updateBtn = findViewById(R.id.updateBtn);

        Contact contact = (Contact) getIntent().getSerializableExtra("Contact");
        id = contact.getId();
        String name = contact.getName();
        String phone = contact.getPhoneNumber();

        updateNameEdit.setText(name);
        updatePhoneEdit.setText(phone);

        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String updateName = updateNameEdit.getText().toString().trim();
                String updatePhone = updatePhoneEdit.getText().toString().trim();

                Contact contact = new Contact(updateName,updatePhone);
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection(Util.TABLE_NAME).document(id).set(contact).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(UpdateContact.this, "수정 되었습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });
            }
        });

    }
}