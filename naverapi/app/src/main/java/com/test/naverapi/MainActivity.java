package com.test.naverapi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.test.naverapi.adepter.RecyclerViewAdapter;
import com.test.naverapi.model.Naver;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText txtTitle;
    Button btnTrans;
    RadioGroup radioGroup;
    String language = "en";
    TextView txtBody;


    RequestQueue requestQueue;
    String baseUrl = "https://openapi.naver.com/v1/papago/n2mt";

    ArrayList<Naver> naverArrayList = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnTrans = findViewById(R.id.btnTrans);
        txtTitle = findViewById(R.id.txtTitle);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        // JSONObjectRequest , JSONArrayRequest 이것은 전에 사용해 봤다.
        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.btnEng) {
                    language = "en";
                } else if (checkedId == R.id.btnCn) {
                    language = "zh-CN";
                } else if (checkedId == R.id.btnTw) {
                    language = "zh-TW";
                } else if (checkedId == R.id.btnTha) {
                    language = "th";
                }
                Log.i("AAA", language);
            }
        });

        btnTrans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                translate();
            }
        });
    }

    public void translate() {
        StringRequest request = new StringRequest(
                Request.Method.POST, baseUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("AAA", response);
                try {
                    JSONObject jsonObject = new JSONObject(response);

                    JSONObject message = jsonObject.getJSONObject("message");
                    JSONObject result = message.getJSONObject("result");
                    String Type = result.getString("srcLangType");
                    String target = result.getString("tarLangType");
                    String text = result.getString("translatedText");
                    String title = txtTitle.getText().toString().trim();
                    Log.i("CCC", "translatedText : " + title + text);


                    Naver naver = new Naver(title,text);
                    naverArrayList.add(0,naver);

                    recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,naverArrayList);
                    recyclerView.setAdapter(recyclerViewAdapter);
                    // translatedText 항목을 뽑아 올 수 있습니다.
                } catch (JSONException e) {
                    e.printStackTrace();
                    Log.i("AAA", e.toString());
                }
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.i("AAA", error.toString());
                    }
                }
        ) {
            // 네이버 API의 헤더 셋팅 부부을 여기에 작성한다.
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
                params.put("X-Naver-Client-Id", "Fy1ixWwbFBOfA8DKwp3U");
                params.put("X-Naver-Client-Secret", "xfa6fFoMQA");
                return params;
            }

            //네이버에 요청할 파라미터를 셋팅한다.
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();

                String title = txtTitle.getText().toString();

                params.put("source", "ko");
                params.put("target", language);
                params.put("text", title);
                return params;
            }
        };

        // 실제로 네트워크로 API 호출(요청)
        requestQueue.add(request);
    }


    //문자열로 JSON을 받아오는 클래스 : StringRequest

    //헤더에 데이터를 넣어서 요청하는 방법

}