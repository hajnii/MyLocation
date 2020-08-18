package com.hajni.parsing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;


import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.hajni.parsing.R;

import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {

    String url = "https://jsonplaceholder.typicode.com/todos/1";
    // volley 라이브러리를 이용해서, 위의 url 로 api 호출하여, 결과인 json을, 로그에 남깁니다.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final RequestQueue requestQueue  = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                Log.i("Parsing1111",response.toString());
                try {
                    int userId = response.getInt("userId");
                    int id = response.getInt("id");
                    String title = response.getString("title");
                    boolean completed = response.getBoolean("completed");
                    Log.i("Parsing","userID : "+userId);
                    Log.i("Parsing","userID : "+id);
                    Log.i("Parsing","userID : "+title);
                    Log.i("Parsing","userID : "+completed);
                }catch (JSONException e){

                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("Parsing","error : " + error.toString());
            }
        });
        requestQueue.add(jsonObjectRequest);



    }
}