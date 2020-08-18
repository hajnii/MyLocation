package com.hajni.intent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.AlarmClock;
import android.provider.ContactsContract;

import static android.provider.AlarmClock.EXTRA_HOUR;
import static android.provider.AlarmClock.EXTRA_MINUTES;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        creatAlarm("일해라",11,45);
//        composeMmsMessage("안녕하세요",null);
//        openWebPage("http://namer.com");

        composeEmail(new String[]{"ksb12213@naver.com"},"안녕하세요");
    }

    // 연락처 선택
    public void selectContact(){
        Intent i = new Intent(Intent.ACTION_PICK);
        i.setType(ContactsContract.Contacts.CONTENT_TYPE);
        if (i.resolveActivity(getPackageManager()) != null){
            startActivityForResult(i,1);
        }
    }

    public void composeMmsMessage(String message, Uri attachment){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setData(Uri.parse("smsto : 012-345-6789"));
        i.putExtra("sns_body",message);
        i.putExtra(Intent.EXTRA_STREAM,attachment);
        if (i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }
    }

    public void openWebPage(String url){
        Uri webpage = Uri.parse(url);
        Intent i = new Intent(Intent.ACTION_VIEW,webpage);
        if (i.resolveActivity(getPackageManager()) != null){
            startActivityForResult(i,1);
        }
    }

    // 원하는 시간:분 에 알람 메세지 나오도록 하는 코드
    public void creatAlarm(String message, int hour, int minutes){
        Intent i = new Intent(AlarmClock.ACTION_SET_ALARM)
                .putExtra(AlarmClock.EXTRA_MESSAGE,message)
                .putExtra(AlarmClock.EXTRA_HOUR,hour)
                .putExtra(AlarmClock.EXTRA_MINUTES,minutes);
        if (i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }
    }

    public void composeEmail(String[] addressed, String subject){
        Intent i = new Intent(Intent.ACTION_SENDTO);
        i.setData(Uri.parse("mailto : "));
        i.putExtra(Intent.EXTRA_EMAIL,addressed);
        i.putExtra(Intent.EXTRA_SUBJECT,subject);
        if (i.resolveActivity(getPackageManager()) != null){
            startActivity(i);
        }

    }

}
