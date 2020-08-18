package com.hajni.mytest;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView txtTitle;
    EditText editName;
    EditText editPhone;
    ImageView imgCenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitle = findViewById(R.id.txtTitle);
        editName = findViewById(R.id.editName);
        editPhone = findViewById(R.id.editPhone);
        imgCenter = findViewById(R.id.imgCenter);

        // 버튼을 클릭하면, 로그에 "버튼 클릭 됨" 을 찍도록 코드 작성
        Button click = findViewById(R.id.btnclick);
        click.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Log.i("MyTest","버튼 클릭 됨");
                String text = txtTitle.getText().toString();
                Log.i("MyTest","get text : " + text);
                // txtTitle.setText("버튼 클릭 됨");

                String name = editName.getText().toString();
                String phone = editPhone.getText().toString();


                txtTitle.setText(name + "\n" +phone);

                Toast.makeText(MainActivity.this, name+"\n"+phone,
                        Toast.LENGTH_SHORT).show();

                imgCenter.setImageResource(R.drawable.orange);
            }
        });

    }
}