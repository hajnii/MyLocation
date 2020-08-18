package com.test.mylocation;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.test.mylocation.adapter.RecyclerViewAdapter;
import com.test.mylocation.data.Store;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    public static String URL = "https://maps.googleapis.com/maps/api/place/nearbysearch/json?language=ko&radius=20000&type=restaurant&key=AIzaSyD3KC2ug6UrcFciDoqR8LrWd98rn59mit0";
    ArrayList<Store> storeArrayList = new ArrayList<>();

    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    String nextPageToken = "";
    String pageToken = "";
    String searchUrl = "";
    LocationManager locationManager;
    LocationListener locationListener;
    TextView txtsearch;
    Button btnsearch;

    double lat;
    double lng;
    boolean isFirst = true;

    String keyword="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtsearch = findViewById(R.id.txtsearch);
        btnsearch = findViewById(R.id.btnsearch);

        recyclerView = findViewById(R.id.recyclerView);
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        // 위치기반 서비스를 위해서, 안드로이드 시스템에 위치기반서비스 요청.
        locationManager = (LocationManager) this.getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
                Log.i("AAA", location.toString());
                lat = location.getLatitude();
                lng = location.getLongitude();
                // 네트워크로 구글 플레이스 api 호출.
                if(isFirst){
                    isFirst = false;
                    getNetworkData(lat, lng);
                }

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {

            }
        };

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(MainActivity.this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                            Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 0, locationListener);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                int lastPosition = ((LinearLayoutManager) recyclerView.getLayoutManager()).findLastCompletelyVisibleItemPosition();
                int totalCount = recyclerView.getAdapter().getItemCount();
                // lastPosition index 값으로 시작하기때문에

                if (lastPosition + 1 == totalCount) {
                    //아이템 추가 ! 입맛에 맞게 설정하시면됩니다.
                    Log.i("BBB", "맨 마지막 도착");

                    if (nextPageToken.compareTo(pageToken) != 0) {
                        pageToken = nextPageToken;

                        addNetworkData();

                    }

                }
            }
        });
        requestQueue = Volley.newRequestQueue(MainActivity.this);
        getNetworkData(lat, lng);


        btnsearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyword = txtsearch.getText().toString().trim();
                storeArrayList.clear();
                getNetworkData(lat,lng);


            }
        });
    }

    void addNetworkData() {
        String url="";
        if(keyword.isEmpty()){
            url = URL+"&location="+lat+","+lng+"&pagetoken="+nextPageToken;
        }else {
            url = URL+"&location="+lat+","+lng+"&keyword="+keyword+"&pagetoken="+nextPageToken;
        }
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray results = response.getJSONArray("results");
                    nextPageToken = response.getString("next_page_token");
                    Log.i("BBB", nextPageToken);
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject jsonArray = results.getJSONObject(i);
                        JSONObject geometry = jsonArray.getJSONObject("geometry");
                        JSONObject location = geometry.getJSONObject("location");
                        double lat = location.getDouble("lat");
                        double lng = location.getDouble("lng");
                        Log.i("AAA", lat + "," + lng);
                        String id = jsonArray.getString("id");
                        String name = jsonArray.getString("name");
                        String vicinity = jsonArray.getString("vicinity");

                        Log.i("AAA", id + "," + name + "," + vicinity);

                        Store store = new Store(lat, lng, id, name, vicinity);
                        storeArrayList.add(store);


                    }
                    recyclerViewAdapter.notifyDataSetChanged();

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }


    void getNetworkData(double lat, double lng) {
        String url="";
        if(keyword.isEmpty()){
             url = URL+"&location="+lat+","+lng;
        }else {
             url = URL+"&location="+lat+","+lng+"&keyword="+keyword;
        }


        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {

                    JSONArray results = response.getJSONArray("results");
                    nextPageToken = response.getString("next_page_token");
                    Log.i("BBB", nextPageToken);
                    for (int i = 0; i < results.length(); i++) {
                        JSONObject jsonArray = results.getJSONObject(i);
                        JSONObject geometry = jsonArray.getJSONObject("geometry");
                        JSONObject location = geometry.getJSONObject("location");
                        double lat = location.getDouble("lat");
                        double lng = location.getDouble("lng");
                        Log.i("AAA", lat + "," + lng);
                        String id = jsonArray.getString("id");
                        String name = jsonArray.getString("name");
                        String vicinity = jsonArray.getString("vicinity");

                        Log.i("AAA", id + "," + name + "," + vicinity);

                        Store store = new Store(lat, lng, id, name, vicinity);
                        storeArrayList.add(store);


                    }
                        recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this, storeArrayList);
                        recyclerView.setAdapter(recyclerViewAdapter);

                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        requestQueue.add(jsonObjectRequest);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 0) {
            if (ActivityCompat.checkSelfPermission(MainActivity.this,
                    Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED &&
                    ActivityCompat.checkSelfPermission(MainActivity.this,
                            Manifest.permission.ACCESS_CHECKIN_PROPERTIES) != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(MainActivity.this,
                        new String[]{Manifest.permission.ACCESS_FINE_LOCATION,
                                Manifest.permission.ACCESS_COARSE_LOCATION}, 0);
                return;
            }
            locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER,
                    5000,   // 밀리세컨드, 1000 : 1초
                    0,  // 미터  10m
                    locationListener);
        }


    }



}