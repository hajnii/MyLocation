package com.hajni.customalert;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.hajni.customalert.adapter.RecyclerViewAdapter;
import com.hajni.customalert.model.CustomAlert;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editBody;
    Button btnYes;
    Button btnNo;
    private AlertDialog dialog;

    RequestQueue requestQueue;
    public static final String URL = "https://jsonplaceholder.typicode.com/posts";
    ArrayList<CustomAlert> CustomArrayList = new ArrayList<>();
    RecyclerView recyclerView;  // 메인화면에 있는 리사이클러 뷰
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);





        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        // 그리드레이아웃 매니저를 이용하면, 하나의행에, 여러개으이 셀을 표시할 수 있다.
        recyclerView.setLayoutManager(
                new GridLayoutManager(MainActivity.this,1)
        );


        requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                for (int i = 0; i < response.length(); i++) {
                    try {
                        JSONObject object = response.getJSONObject(i);
                        int userId = object.getInt("userId");
                        int id = object.getInt("id");
                        String title = object.getString("title");
                        String body = object.getString("body");
                        CustomAlert customAlert = new CustomAlert(userId, id, title, body);

                        Log.i("AAA", "id : " + userId);

                        CustomArrayList.add(customAlert);

                        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, CustomArrayList);
                        recyclerView.setAdapter(recyclerViewAdapter);


                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("AAA", "error : " + error);
            }
        });
        requestQueue.add(jsonArrayRequest);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                createPopupDialog();
            }
        });
    }

    public void createPopupDialog() {
        AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
        View alertView = getLayoutInflater().inflate(R.layout.post_add,null);

        editTitle = alertView.findViewById(R.id.editTitle);
        editBody = alertView.findViewById(R.id.editBody);

        alert.setView(alertView);
        alert.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String title = editTitle.getText().toString().trim();
                String body = editBody.getText().toString().trim();

                if(title.isEmpty()||body.isEmpty()){
                    Toast.makeText(MainActivity.this, "제목과 내용을 입력해주세요", Toast.LENGTH_SHORT).show();
                    return;
                }
                CustomAlert customAlert = new CustomAlert(1,1,title,body);
                CustomArrayList.add(0,customAlert);
                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,CustomArrayList);
                recyclerView.setAdapter(recyclerViewAdapter);

            }
        });
        alert.setNegativeButton("No",null);
        alert.setCancelable(false);

        dialog = alert.create();
        dialog.show();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 0 && resultCode == RESULT_OK) {
            CustomAlert customAlert = (CustomAlert) data.getSerializableExtra("customClass");


            CustomArrayList.add(customAlert);

            recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,CustomArrayList);
            recyclerView.setAdapter(recyclerViewAdapter);

        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.menu_add) {
            Intent i = new Intent(MainActivity.this, AddPosting.class);
//            startActivity(i);
            startActivityForResult(i,0);
        }
        return super.onOptionsItemSelected(item);
    }

}
