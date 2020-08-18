package com.hajni.cat;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.hajni.cat.R;

import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText txt;
    TextView catbirth;
    Button btnClick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt = findViewById(R.id.txt);
        catbirth = findViewById(R.id.catbirth);
        btnClick = findViewById(R.id.btnClick);

        btnClick.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // 버튼 눌렸을때 해야 될 일을 여기에 작성
                // 1. 에디트텍스트에 적혀있는 글자 가져오기.
                String birth = txt.getText().toString();
                Log.i("cat","유저가 입력한 값 " + birth);

                // 2. 이번년도에서 가지고온 년도를 뺀다.
                int birthsum = Integer.parseInt(birth);
                int age = 2020 - birthsum + 1;

                // 3. 텍스트뷰에 표시해야겠다.
                catbirth.setText("" + age);

                // 4. 에디트텍스트에서 유저가 쓴 글자 지운다.
                txt.setText(null);


            }
        });
    }
}