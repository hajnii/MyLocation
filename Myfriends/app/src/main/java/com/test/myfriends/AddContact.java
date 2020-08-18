package com.test.myfriends;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.test.myfriends.model.Data;

import java.util.ArrayList;

public class AddContact extends AppCompatActivity {

    EditText editName;
    EditText editPhone;
    Button btnSave;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    ArrayList<Data> dataArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_add_contact);
        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        btnSave = findViewById(R.id.btnSave);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = editName.getText().toString().trim();
                String phone = editPhone.getText().toString().trim();

                if (name.isEmpty()||phone.isEmpty()){
                    Toast.makeText(AddContact.this,"이름 또는 전화번호 입력은 필수 입ㄴ디ㅏ.",Toast.LENGTH_SHORT).show();
                }
                Log.i("AAA",name+"/"+phone);

                Data data = new Data(name,phone);
                db.collection("Data")
                        .add(data)
                        .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                            @Override
                            public void onSuccess(DocumentReference documentReference) {
                                Toast.makeText(AddContact.this, "저장되었습니다.", Toast.LENGTH_SHORT).show();
                                finish();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.i("AAA",e.toString());
                            }
                        });
            }
        });
    }
}
