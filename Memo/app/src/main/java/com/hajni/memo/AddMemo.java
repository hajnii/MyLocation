package com.hajni.memo;

import androidx.appcompat.app.AppCompatActivity;

import android.database.DatabaseErrorHandler;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.hajni.memo.data.DatabaseHandler;
import com.hajni.memo.model.Contact;

public class AddMemo extends AppCompatActivity {

    EditText editTitle;
    EditText editContents;
    Button btnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_memo);

        editTitle = findViewById(R.id.editTitle);
        editContents = findViewById(R.id.editContents);
        btnAdd = findViewById(R.id.btnAdd);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString().trim();
                String contents = editContents.getText().toString().trim();

                if (title.isEmpty()||contents.isEmpty()){
                    Toast.makeText(AddMemo.this,"제목과 내용을 입력해주세요",Toast.LENGTH_SHORT).show();
                }

                DatabaseHandler dh = new DatabaseHandler(AddMemo.this);
                Contact new_contact = new Contact();
                new_contact.setTitle(title);
                new_contact.setContents(contents);

                dh.addMemo(new_contact);

                Toast.makeText(AddMemo.this,"저장되었습니다.",Toast.LENGTH_SHORT).show();

                finish();
            }
        });

    }
}
