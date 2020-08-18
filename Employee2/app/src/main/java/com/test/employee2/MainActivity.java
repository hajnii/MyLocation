package com.test.employee2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.test.employee2.adapter.RecyclerViewAdapter;
import com.test.employee2.model.Data;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Date;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    String URL = "http://dummy.restapiexample.com/api/v1/employees";
    ArrayList<Data> dataArrayList;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dataArrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("AAA",response.toString());
                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            for (int i = 0; i<jsonArray.length();i++){
                                JSONObject object = jsonArray.getJSONObject(i);
                                int id = object.getInt("id");
                                String name = object.getString("employee_name");
                                int age = object.getInt("employee_age");
                                int salary = object.getInt("employee_salary");

                                Data data = new Data(id,name,age,salary);

                                dataArrayList.add(data);

                                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,dataArrayList);
                                recyclerView.setAdapter(recyclerViewAdapter);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("AAA","error : " + error);
            }
        });
        requestQueue.add(jsonObjectRequest);
    }
}
