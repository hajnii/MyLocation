package com.test.naverapi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
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
import com.test.naverapi.data.DatabaseHandler;
import com.test.naverapi.model.Translation;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    RequestQueue requestQueue;
    String baseUrl = "https://openapi.naver.com/v1/papago/n2mt";

    RadioGroup radioGroup;
    RadioButton englishRadio;
    RadioButton simplifiedChineseRadio;
    RadioButton traditionalChineseRadio;
    RadioButton thaiRadio;
    EditText inputEdit;
    TextView translationTxt;
    Button translationBtn;
    ImageView historyImg;

    String target ="";
    String inputTxt = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        englishRadio = findViewById(R.id.englishRadio);
        simplifiedChineseRadio = findViewById(R.id.simplifiedChineseRadio);
        traditionalChineseRadio = findViewById(R.id.traditionalChineseRadio);
        thaiRadio = findViewById(R.id.thaiRadio);
        inputEdit = findViewById(R.id.inputEdit);
        translationTxt = findViewById(R.id.translationTxt);
        translationBtn = findViewById(R.id.translationBtn);
        historyImg = findViewById(R.id.historyImg);

        englishRadio.setChecked(true);

        historyImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,History.class);
                startActivity(intent);
            }
        });

        translationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int btnId = radioGroup.getCheckedRadioButtonId();

                inputTxt = inputEdit.getText().toString().trim();

                if (btnId == englishRadio.getId()){
                    target = "en";
                }else if(btnId == simplifiedChineseRadio.getId()){
                    target ="zh-CN";
                }else if(btnId == traditionalChineseRadio.getId()){
                    target ="zh-TW";
                }else if(btnId == thaiRadio.getId()){
                    target ="th";
                }

                Log.i("AAA",target);
                getTranslation("ko",target,inputTxt);



            }
        });


    }

    void getTranslation(final String source, final String target, final String text){
        requestQueue = Volley.newRequestQueue(MainActivity.this);

        // JSONObjectRequest ,JSONArrayRequest, StringRequest( 새로운 방법 ) : String 으로 JSON 을 받아오는 Class
        // 헤더에 데이터를 넣어서 요청하는 방법
        StringRequest request = new StringRequest(Request.Method.POST, baseUrl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.i("AAA",response);
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    Log.i("AAA",""+jsonObject);
                    // translatedText  항목을 뽑아 올수 있습니다.
                    JSONObject messageJSON = jsonObject.getJSONObject("message");
                    JSONObject resultJSON = messageJSON.getJSONObject("result");
                    String src = resultJSON.getString("srcLangType");
                    String tar = resultJSON.getString("tarLangType");
                    String translated = resultJSON.getString("translatedText");

                    Log.i("AAA",src);
                    Translation translation = new Translation(src,tar,translated,inputTxt);

                    DatabaseHandler handler = new DatabaseHandler(MainActivity.this);
                    handler.addTranslation(translation);

                    translationTxt.setText(translated);

                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.i("AAA",error.toString());
            }
        }){
            @Override
            public Map<String, String> getHeaders() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("Content-Type","application/x-www-form-urlencoded; charset=UTF-8");
                params.put("X-Naver-Client-Id","QXv6PsWMVwNKZulAU4dL");
                params.put("X-Naver-Client-Secret","sA3zGOSzKj");
                return params;
            }
            //  네이버에 요청할 Parameter 를 셋팅한다.
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> params = new HashMap<String, String>();
                params.put("source",source);
                params.put("target",target);
                params.put("text",text);
                return params;

            }
        };
        requestQueue.add(request);
    }

}
