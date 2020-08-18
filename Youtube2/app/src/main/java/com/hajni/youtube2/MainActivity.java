package com.hajni.youtube2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.hajni.youtube2.adapter.RecyclerViewAdapter;
import com.hajni.youtube2.model.Youtube;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    public static final String URL = "https://www.googleapis.com/youtube/v3/search?part=snippet&key=AIzaSyBeNBYWoD8CLAdsMGuD8lUfuW8CxiYrRdU&maxResults=10&order=date&type=video&regionCode=KR";
    ArrayList<Youtube> youtubeArrayList = new ArrayList<>();
    RecyclerView recyclerView;

    RecyclerViewAdapter recyclerViewAdapter;

    EditText editSearch;
    Button btnSearch;

    String nextPageToken;
    String pageToken = "";

    String searchUrl = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        editSearch = findViewById(R.id.editSearch);
        btnSearch = findViewById(R.id.btnSearch);

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

                if(lastPosition +1 == totalCount){
                    //아이템 추가 ! 입맛에 맞게 설정하시면됩니다.
                    Log.i("NNN","URL : " + lastPosition +"/" +totalCount);
                    if (nextPageToken.compareTo(pageToken) != 0){
                        pageToken = nextPageToken;

                        String url = "";
                        if(searchUrl.isEmpty()){
                            url = URL + "&pageToken=" + pageToken;
                        }else {
                            url = searchUrl + "&pageToken=" + pageToken;
                        }
                        // 이 URL 로 네트워크 데이터 요청.
                        Log.i("CCC",url);
                        addNetworkData(url);
                    }
                }
            }
        });


        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String search = editSearch.getText().toString();

                if (search.isEmpty()){
                    searchUrl = URL;
                }else {
                    searchUrl = URL + "&q=" + search;
                }
                Log.i("BBB","URL : " + searchUrl);
                // 새로 바뀐 검색어로 데이터를 가져오기 위해서, 원래 들어있던 어레이리스트의
                // 데이터를 모두 지우고, 새로 받아온다.
                youtubeArrayList.clear();
                getNetworkData(searchUrl);
            }
        });
        requestQueue = Volley.newRequestQueue(MainActivity.this);

        getNetworkData(URL);
    }

    public void getNetworkData(String url){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("AAA","result : "+ response.toString());
                        try {
                            JSONArray itemArray = response.getJSONArray("items");
                            nextPageToken = response.getString("nextPageToken");
                            Log.i("AAA","로그" + itemArray);

                            for (int i = 0; i< itemArray.length(); i++){
                                JSONObject jsonObject = itemArray.getJSONObject(i);
                                JSONObject snippet = jsonObject.getJSONObject("snippet");
                                String title = snippet.getString("title");
                                String description = snippet.getString("description");
                                Log.i("AAA","title : " + title);
                                Log.i("AAA","description : " + description);

                                JSONObject thumbnails = snippet.getJSONObject("thumbnails");
                                JSONObject medium = thumbnails.getJSONObject("medium");
                                String mediumUrl = medium.getString("url");
                                JSONObject high = thumbnails.getJSONObject("high");
                                String highUrl = high.getString("url");
                                Log.i("AAA","highUrl : " + highUrl);

                                JSONObject id = jsonObject.getJSONObject("id");
                                String videoId = id.getString("videoId");
                                Log.i("AAA","videoId : " + videoId);


                                Youtube youtube = new Youtube(title,description,mediumUrl,highUrl,videoId);
                                youtubeArrayList.add(youtube);

                            }
                            recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,youtubeArrayList);
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

    public void addNetworkData(String url){

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("AAA","result : "+ response.toString());
                        try {
                            JSONArray itemArray = response.getJSONArray("items");
                            nextPageToken = response.getString("nextPageToken");
                            Log.i("AAA","로그" + itemArray);

                            for (int i = 0; i< itemArray.length(); i++){
                                JSONObject jsonObject = itemArray.getJSONObject(i);
                                JSONObject snippet = jsonObject.getJSONObject("snippet");
                                String title = snippet.getString("title");
                                String description = snippet.getString("description");
                                Log.i("AAA","title : " + title);
                                Log.i("AAA","description : " + description);

                                JSONObject thumbnails = snippet.getJSONObject("thumbnails");
                                JSONObject medium = thumbnails.getJSONObject("medium");
                                String mediumUrl = medium.getString("url");
                                JSONObject high = thumbnails.getJSONObject("high");
                                String highUrl = high.getString("url");
                                Log.i("AAA","highUrl : " + highUrl);

                                JSONObject id = jsonObject.getJSONObject("id");
                                String videoId = id.getString("videoId");
                                Log.i("AAA","videoId : " + videoId);


                                Youtube youtube = new Youtube(title,description,mediumUrl,highUrl,videoId);
                                youtubeArrayList.add(youtube);

                            }
                            recyclerViewAdapter.notifyDataSetChanged();

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