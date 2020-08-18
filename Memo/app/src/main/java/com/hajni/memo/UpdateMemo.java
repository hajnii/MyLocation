package com.hajni.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hajni.memo.data.DatabaseHandler;
import com.hajni.memo.model.Contact;

public class UpdateMemo extends AppCompatActivity {

    EditText updateTitle;
    EditText updateContents;
    Button btnUpdate;
    int id;
    DatabaseHandler db = new DatabaseHandler(UpdateMemo.this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_memo);

        updateTitle = findViewById(R.id.updateTitle);
        updateContents = findViewById(R.id.updateContents);
        btnUpdate = findViewById(R.id.btnUpdate);

        id = getIntent().getIntExtra("id",-1);
        String title = getIntent().getStringExtra("title");
        String contents = getIntent().getStringExtra("contents");

        updateTitle.setText(title);
        updateContents.setText(contents);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fixtitle = updateTitle.getText().toString().trim();
                String fixcontents = updateContents.getText().toString().trim();

                Contact contact = new Contact(id,fixtitle,fixcontents);
                db.updateContact(contact);
                if(fixtitle.isEmpty() || fixcontents.isEmpty()){
                    Toast.makeText(UpdateMemo.this,"데이터를 넣어주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                Log.i("name","아이디 2번 데이터 : " + contact.getId() +", "+ contact.getTitle()+", " + contact.getContents());
                Toast.makeText(UpdateMemo.this,"수정되었습니다.",Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}
