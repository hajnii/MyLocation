package com.hajni.employee;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.Movie;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.hajni.employee.adapter.RecyclerViewAdapter;
import com.hajni.employee.model.Contact;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    public static final String URL = "http://dummy.restapiexample.com/api/v1/employees";
    ArrayList<Contact> contactList;
    RecyclerView recyclerView;  // 메인화면에 있는 리사이클러 뷰
    RecyclerViewAdapter recyclerViewAdapter;    // 우리가 만든, 하나의 셀을 연결시키는 어댑터



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactList = new ArrayList<>();

        recyclerView = findViewById(R.id.recylerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        try{
                            JSONArray jArray3 = response.getJSONArray("data");
                            for (int i = 0; i<jArray3.length();i++) {
                                JSONObject object3 = jArray3.getJSONObject(i);
                                int id = object3.getInt("id");
                                String employee_name = object3.getString("employee_name");
                                int employee_age = object3.getInt("employee_age");
                                int employee_salary = object3.getInt("employee_salary");
                                Contact contact = new Contact();

                                contact.setId(id);
                                contact.setName(employee_name);
                                contact.setAge(employee_age);
                                contact.setSalary(employee_salary);
                                contactList.add(contact);

                                Log.i("AAA","name" + employee_name);

                                recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,contactList);
                                recyclerView.setAdapter(recyclerViewAdapter);
                            }
                            // for 루프가 끝나야, 모든 데이ㅓ가 다 어레이리스트에 들어있다.
                            // 이렇게 어레이리스트에 데이터가 다 들어있는 후에,
                            // 리사이클러뷰를 표시.
                        }catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("AAA","error : " + error);

                    }
                });
        requestQueue.add(jsonObjectRequest);
        // 네트워크 갔다와서, 어레이리스트에 데이터가 쌓여있는 상태 X => ndml
        // 요 아래에다가 어댑터 연결하는 코드 넣으면 절대 안됩니다.



    }
}
