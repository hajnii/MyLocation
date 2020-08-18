package com.hajni.contactmanager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hajni.contactmanager.data.DatabaseHandler;
import com.hajni.contactmanager.model.Contact;

public class UpdateContact extends AppCompatActivity {

    EditText updateName;
    EditText updatePhone;
    Button btnUpdate;
    int id;
    DatabaseHandler db = new DatabaseHandler(UpdateContact.this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_contact);

        updateName = findViewById(R.id.updateName);
        updatePhone = findViewById(R.id.updatePhone);
        btnUpdate = findViewById(R.id.btnUpdate);

        id = getIntent().getIntExtra("id",-1);
        String name = getIntent().getStringExtra("name");
        String phone = getIntent().getStringExtra("phone");

        updateName.setText(name);
        updatePhone.setText(phone);


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fixname = updateName.getText().toString().trim();
                String fixphone = updatePhone.getText().toString().trim();
                //업데이트 테스트
                Contact contact = new Contact(id,fixname,fixphone);
                db.updateContact(contact);
                if(fixname.isEmpty() || fixphone.isEmpty()){
                    Toast.makeText(UpdateContact.this,"데이터를 넣어주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.i("name","아이디 2번 데이터 : " + contact.getId() +", "+ contact.getName()+", " + contact.getPhoneNumber());
                Toast.makeText(UpdateContact.this,"수정되었습니다.",Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}