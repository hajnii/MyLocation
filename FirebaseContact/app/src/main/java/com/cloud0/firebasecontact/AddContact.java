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

public class AddContact extends AppCompatActivity {

    EditText nameEdit;
    EditText phoneEdit;
    Button saveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_contact);

        nameEdit = findViewById(R.id.nameEdit);
        phoneEdit = findViewById(R.id.phoneEdit);
        saveBtn = findViewById(R.id.saveBtn);

        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = nameEdit.getText().toString().trim();
                String phone = phoneEdit.getText().toString().trim();
                if (name.isEmpty()){
                    Toast.makeText(AddContact.this, "이름을 입력해 주세요", Toast.LENGTH_SHORT).show();
                    return;
                }

                Contact contact = new Contact(name,phone);
                FirebaseFirestore db = FirebaseFirestore.getInstance();
                db.collection(Util.TABLE_NAME).add(contact).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(AddContact.this, "저장 되었습니다.", Toast.LENGTH_SHORT).show();
                        finish();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Log.i("AAA","error : "+e);
                    }
                });
            }
        });

    }
}