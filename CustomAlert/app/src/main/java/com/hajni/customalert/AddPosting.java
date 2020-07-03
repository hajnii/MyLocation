package com.hajni.customalert;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.Toolbar;

import com.hajni.customalert.adapter.RecyclerViewAdapter;
import com.hajni.customalert.model.CustomAlert;

import java.util.ArrayList;

public class AddPosting extends AppCompatActivity {

    EditText addTitle;
    EditText addBody;
    Button btnSave;
    Toolbar toolbar;
    ArrayList<CustomAlert> CustomArrayList = new ArrayList<>();
    RecyclerView recyclerView;  // 메인화면에 있는 리사이클러 뷰
    RecyclerViewAdapter recyclerViewAdapter;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_posting);

        addTitle = findViewById(R.id.addTitle);
        addBody = findViewById(R.id.addBody);
        btnSave = findViewById(R.id.btnSave);

        recyclerView = findViewById(R.id.recylerView);


        androidx.appcompat.widget.Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String title = addTitle.getText().toString().trim();
                String body =  addBody.getText().toString().trim();

                Log.i("AAA"," : "+title+body);

                if (title.isEmpty()||body.isEmpty()){
                    Toast.makeText(AddPosting.this,"입력해주세요",Toast.LENGTH_SHORT).show();
                    return;
                }
                CustomAlert customAlert = new CustomAlert(0,0,title,body);
                // 위의 객체를, 새로운 액티비티에 전달.
                Intent i = new Intent(AddPosting.this,MainActivity.class);
                i.putExtra("customClass",customAlert);
                setResult(RESULT_OK,i);
                Log.i("AAA",""+ customAlert);
                finish();

            }
        });



    }




    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        //noinspection SimplifiableIfStatement

        switch(item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;



        }
        return super.onOptionsItemSelected(item);
    }


}
