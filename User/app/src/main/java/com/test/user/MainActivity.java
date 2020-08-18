package com.test.user;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.test.user.Login;
import com.test.user.model.Data;
import com.test.user.util.Util;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText editEmail;
    EditText editPass;
    EditText editPassW;
    Button btnJoin;
    Button btnLogin;
    ArrayList<Data> dataArrayList = new ArrayList<>();
    String email="";
    String pwd="";
    String pwdd="";
    String db_email="";

    FirebaseFirestore db = FirebaseFirestore.getInstance();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editEmail = findViewById(R.id.editEmail);
        editPass = findViewById(R.id.editPass);
        editPassW = findViewById(R.id.editPassW);
        btnJoin = findViewById(R.id.btnJoin);
        btnLogin = findViewById(R.id.btnLogin);

        btnJoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = editEmail.getText().toString().trim();
                pwd = editPass.getText().toString().trim();
                pwdd = editPassW.getText().toString().trim();

                if(email.isEmpty() || pwd.isEmpty()){
                    Toast.makeText(MainActivity.this,"모두 입력해야 합니다.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(email.contains("@")){

                }else {
                    Toast.makeText(MainActivity.this,"올바른 이메일 형식을 입력해 주세요.",Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pwd.equals(pwdd)){

                }else {
                    Toast.makeText(MainActivity.this,"비밀번호가 같아야 합니다.",Toast.LENGTH_SHORT).show();
                    return;
                }

                db.collection(Util.TABLE_NAME).get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {

                        for(QueryDocumentSnapshot snapshot : queryDocumentSnapshots){
                            db_email = snapshot.getString("email");
                            Log.i("CCC",""+email);
                            if(db_email.equals(email)){
                                Toast.makeText(MainActivity.this, "중복되었습니다.", Toast.LENGTH_SHORT).show();
                                editEmail.setText("");
                                return;
                            }


                        }

                        Data data = new Data(email,pwd);
                        db.collection(Util.TABLE_NAME)
                                .add(data)
                                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                                    @Override
                                    public void onSuccess(DocumentReference documentReference) {
                                        Toast.makeText(MainActivity.this, "회원가입이 완료되었습니다.", Toast.LENGTH_SHORT).show();
                                        editEmail.setText("");
                                        editPass.setText("");
                                        editPassW.setText("");
                                    }
                                })
                                .addOnFailureListener(new OnFailureListener() {
                                    @Override
                                    public void onFailure(@NonNull Exception e) {
                                        Log.i("AAA",e.toString());
                                    }
                                });
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });









            }
        });

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, Login.class);
                startActivity(i);
            }
        });

    }
}