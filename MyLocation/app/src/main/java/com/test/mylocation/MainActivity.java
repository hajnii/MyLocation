package com.test.mylocation;

import androidx.annotation.NonNull;
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
import com.test.mylocation.adapter.RecyclerViewAdapter;
import com.test.mylocation.data.Store;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    String nextPageToken;
    RequestQueue requestQueue;
    public static final String URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?language=ko&location=37.544147,126.8357822&radius=2000&type=restaurant&key=AIzaSyBBBFuxUwd-sBV7_CctINnmAzKNOcdoH00";
    RecyclerView recyclerView;
    ArrayList<Store> storeArrayList = new ArrayList<>();

    RecyclerViewAdapter recyclerViewAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, URL, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("AAA","ddg : "+response);
                        try {
                            nextPageToken = response.getString("next_page_token");
                            Log.i("AAA","next : " + nextPageToken);
                            JSONArray results = response.getJSONArray("results");
                            for (int i = 0; i < results.length(); i++){
                                JSONObject jsonObject = results.getJSONObject(i);
                                JSONObject geometry = jsonObject.getJSONObject("geometry");
                                JSONObject location = geometry.getJSONObject("location");
                                String lat = location.getString("lat");
                                String lng = location.getString("lng");
                                String name = jsonObject.getString("name");
                                String vicinity = jsonObject.getString("vicinity");
                                Log.i("AAA",vicinity);

                                Store store = new Store(lat,lng,name,vicinity);
                                storeArrayList.add(store);

                            }
                            recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,storeArrayList);
                            recyclerView.setAdapter(recyclerViewAdapter);
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
