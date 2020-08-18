package com.test.naverapi;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.test.naverapi.adapter.RecyclerViewAdapter;
import com.test.naverapi.data.DatabaseHandler;
import com.test.naverapi.model.Translation;

import java.util.ArrayList;

public class History extends AppCompatActivity {

    RecyclerViewAdapter recyclerViewAdapter;
    RecyclerView historyRecyclerView;
    TextView allDeleteTxt;
    ArrayList<Translation> translationArrayList = new ArrayList<>();
    AlertDialog alertDialog;
    DatabaseHandler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        allDeleteTxt = findViewById(R.id.allDeleteTxt);
        historyRecyclerView = findViewById(R.id.historyRecyclerView);
        historyRecyclerView.setHasFixedSize(true);
        historyRecyclerView.setLayoutManager(new LinearLayoutManager(History.this));

        handler = new DatabaseHandler(History.this);

        translationArrayList.addAll(handler.getAllTranslation());
        recyclerViewAdapter = new RecyclerViewAdapter(History.this,translationArrayList);
        historyRecyclerView.setAdapter(recyclerViewAdapter);
        if (translationArrayList.size() > 0 ){
            allDeleteTxt.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    customAlert();
                }
            });
        }else {
            Toast.makeText(History.this, "삭제할 데이터가 없습니다.", Toast.LENGTH_SHORT).show();
        }



    }


    public void customAlert(){

        final View alertView = getLayoutInflater().inflate(R.layout.alert_edit,null);
        final AlertDialog.Builder alert = new AlertDialog.Builder(History.this);
        alert.setTitle("전체 삭제");
        alert.setMessage("아래의 문장을 입력후 YES 를 눌러주세요");
        alert.setView(alertView);
        alert.setPositiveButton("YES",null);
        alert.setNegativeButton("NO",null);
        alertDialog = alert.create();
        alertDialog.setCancelable(false);

        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(final DialogInterface dialog) {
                Button positive = alertDialog.getButton(AlertDialog.BUTTON_POSITIVE);
                positive.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        EditText alertEdit = alertView.findViewById(R.id.alertInputEdit);
                        String input = alertEdit.getText().toString().trim();
                        if (input.equals("삭제")){

                            for (int i = 0 ; i < translationArrayList.size(); i++ ){
                                Translation translation = translationArrayList.get(i);
                                handler.deleteTranslation(translation);
                                recreate();
                            }
                            Toast.makeText(History.this, "전체 삭제 완료", Toast.LENGTH_SHORT).show();
                        }else {
                            Toast.makeText(History.this, "틀렸습니다.", Toast.LENGTH_SHORT).show();
                            alertDialog.isShowing();
                        }
                    }
                });
            }
        });
        alertDialog.show();
    }
}
