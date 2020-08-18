package com.cloud0.gpt.signUp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.cloud0.gpt.R;
import com.cloud0.gpt.model.SignIn;
import com.cloud0.gpt.util.Util;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class SignUpActivity extends AppCompatActivity {

    private final int TIMER_SECOND = 1000;
    private final int TIMER_MILLIS_TIME = 180000;

    // todo 이메일 발송 인증 번호 작업 해야함
    int temporary = 1234;
    boolean check = false;
    int count = 0;

    EditText signUp_editId;
    EditText signUp_editPassword;
    EditText signUp_editPasswordCheck;
    Spinner signUp_spinner;
    //CheckBox signUp_checkBox;
    Button signUp_btnSignUp;
    TextView signUp_checkEmail;

    CountDownTimer countDownTimer;

    FirebaseFirestore db = FirebaseFirestore.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        signUp_checkEmail = findViewById(R.id.signUp_checkEmail);
        signUp_editId = findViewById(R.id.signUp_editId);
        signUp_editPassword = findViewById(R.id.signUp_editPassword);
        signUp_editPasswordCheck = findViewById(R.id.signUp_editPasswordCheck);
        signUp_spinner = findViewById(R.id.signUp_spinner);
        //signUp_checkBox = findViewById(R.id.signUp_checkBox);
        signUp_btnSignUp = findViewById(R.id.signUp_btnSignUp);


        signUp_checkEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder alert = new AlertDialog.Builder(SignUpActivity.this);
                final View alertView = getLayoutInflater().inflate(R.layout.signup_email_check_alert,null);
                alert.setTitle("이메일 인증");
                alert.setView(alertView);
                final AlertDialog alertDialog = alert.create();
                final EditText signUp_number = alertView.findViewById(R.id.signUp_number);
                Button alertBtn = alertView.findViewById(R.id.signUp_btnCheckEmail);

                alertBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (signUp_number.getText().toString().trim().isEmpty()){
                            Toast.makeText(SignUpActivity.this, "번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                            return;
                        }
                        int number = Integer.parseInt(signUp_number.getText().toString().trim());
                        Log.i("AAA",""+number);

                        if (number == temporary){
                            check = true;
                            count = 0;
                            alertDialog.cancel();
                        }else if (count == 2){
                            check = false;
                            alertDialog.cancel();
                            count = 0;
                            Toast.makeText(SignUpActivity.this, "인증 실패", Toast.LENGTH_SHORT).show();
                        }else {
                            check = false;
                            count = count+ 1;
                            Toast.makeText(SignUpActivity.this, count+"번 인증 실패", Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                });

                countDownTimer = new CountDownTimer(TIMER_MILLIS_TIME, TIMER_SECOND) {
                    @Override
                    public void onTick(long millisUntilFinished) {
                        TextView timeTxt = alertView.findViewById(R.id.signUp_timeTxt);
                        int time = (int) (millisUntilFinished/TIMER_SECOND);
                        int second = time%60;
                        int min = time > 360 ? time/60/360 : time/60;
                        timeTxt.setText(min +":" + second);
                    }

                    @Override
                    public void onFinish() {
                        Toast.makeText(SignUpActivity.this, "인증 시간이 만료 됐습니다.", Toast.LENGTH_SHORT).show();
                        alertDialog.cancel();
                    }
                }.start();
                alertDialog.setCancelable(false);
                alertDialog.show();
            }
        });

        // 회원 가입
        // todo 이메일 인증 약관 체크 여부
        signUp_btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userId = signUp_editId.getText().toString().trim();
                String spinner = signUp_spinner.getSelectedItem().toString().trim();
                String password = signUp_editPassword.getText().toString().trim();
                if (spinner.equals("직접입력")){
                    spinner = "";
                }else {
                    spinner = "@"+spinner;
                }
                userId = userId +spinner;

                if (!check){
                    Toast.makeText(SignUpActivity.this, "email 을 인증해 주세요.", Toast.LENGTH_SHORT).show();
                }else if (!userId.matches("^[a-zA-Z0-9]+@[a-zA-Z0-9]+[.]+[a-zA-Z]+$")){
                    Toast.makeText(SignUpActivity.this, "email 을 입력해 주세요", Toast.LENGTH_SHORT).show();
                    return;
                }else if (!password.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z]).{8,14}$")){
                    Toast.makeText(SignUpActivity.this, "8~14자 영문 대 소문자, 숫자, 특수문자를 사용하세요.", Toast.LENGTH_SHORT).show();
                    return;
                }else if (!password.equals(signUp_editPasswordCheck.getText().toString().trim())){
                    Toast.makeText(SignUpActivity.this, "동일한 비밀번호를 입력해 주세요.", Toast.LENGTH_SHORT).show();
                    return;
                }

//                else if(!signUp_checkBox.isChecked()){
//                    Toast.makeText(SignUpActivity.this, "약관에 동의 하세요", Toast.LENGTH_SHORT).show();
//                    return;
//                }


                SignIn signIn = new SignIn(userId,password);

                db.collection(Util.DATABASE_NAME).add(signIn).addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Toast.makeText(SignUpActivity.this, "회원가입을 축하 합니다.", Toast.LENGTH_SHORT).show();
                    }
                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });

            }
        });


    }

    void countDownTimer(int millisTime){

    }
}