package com.test.firestore;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCanceledListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;
import com.test.firestore.model.Journal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    EditText editTitle;
    EditText editThought;
    Button btnSave;

    public static final String KEY_TITLE = "title";
    public static final String KEY_THOUGHT = "thought";
    FirebaseFirestore db = FirebaseFirestore.getInstance();

    TextView txtTitle;
    TextView txtThought;
    Button btnLoad;
    Button btnDelete;

    ArrayList<Journal> journalArrayList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTitle = findViewById(R.id.editTitle);
        editThought = findViewById(R.id.editThought);
        btnSave = findViewById(R.id.btnSave);


        txtTitle = findViewById(R.id.txtTitle);
        txtThought = findViewById(R.id.txtThought);
        btnLoad = findViewById(R.id.btnLoad);
        btnDelete = findViewById(R.id.btnDelete);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTitle.getText().toString().trim();
                String thought = editThought.getText().toString().trim();

                Journal journal = new Journal(title,thought);
                db.collection("Journal").add(journal)
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        editTitle.setText("");
                        editThought.setText("");
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

//                Map<String, Object> data = new HashMap<>();
//                data.put(KEY_TITLE,title);
//                data.put(KEY_THOUGHT,thought);
                // db에 데이터 저장
//                db.collection("Journal")
//                        .document("First Thoughts")
//                        .set(journal)
//                        .addOnSuccessListener(new OnSuccessListener<Void>() {
//                            @Override
//                            public void onSuccess(Void aVoid) {
//                                Toast.makeText(MainActivity.this,"잘 저장되었습니다.",Toast.LENGTH_LONG).show();
//                                editTitle.setText("");
//                                editThought.setText("");
//                            }
//                        }).addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        Log.i("AAA",e.toString());
//                    }
//                });
            }
        });

        btnLoad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("Journal").get()
                        .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                            @Override
                            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                                for (QueryDocumentSnapshot snapshots : queryDocumentSnapshots){
                                    String id = snapshots.getId();
                                    Log.i("AAA",id);
                                    Journal journal = snapshots.toObject(Journal.class);
                                    journalArrayList.add(journal);
                                }
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {

                            }
                        });
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db.collection("Journal")
                        .document("Q4OtYUhiopMJEfdEPF4O")
                        .delete()
                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                            @Override
                            public void onSuccess(Void aVoid) {
                                Toast.makeText(MainActivity.this,"김하진 바보",Toast.LENGTH_SHORT).show();
                            }
                        })
                        .addOnFailureListener(new OnFailureListener() {
                            @Override
                            public void onFailure(@NonNull Exception e) {
                                Log.i("AAA",e.toString());
                            }
                        });

            }
        });

    }
}
