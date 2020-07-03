package com.hajni.todos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.hajni.todos.adapter.RecyclerViewAdapter;
import com.hajni.todos.model.Todo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    public static final String URL = "https://jsonplaceholder.typicode.com/todos";
    ArrayList<Todo> todoArrayList = new ArrayList<>();
    RecyclerView recyclerView;  // 메인화면에 있는 리사이클러 뷰
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        todoArrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        Log.i("dd","result : " + response.toString());

                        for (int i = 0; i<response.length();i++){
                            try {
                                JSONObject object = response.getJSONObject(i);
                                int userId = object.getInt("userId");
                                int id = object.getInt("id");
                                String title = object.getString("title");
                                boolean completed = object.getBoolean("completed");
                                Todo todo = new Todo(userId,id,title,completed);


                                todoArrayList.add(todo);

                                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,todoArrayList);
                                recyclerView.setAdapter(recyclerViewAdapter);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("dd","error : " +error);
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}
