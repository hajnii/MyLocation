package com.test.naverapi.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.test.naverapi.model.Translation;
import com.test.naverapi.util.Util;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {
    public DatabaseHandler(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {



        String CREATE_MEMO_TABLE= "create table " +
                Util.TABLE_NAME +
                "("+Util.KEY_ID + " integer not null primary key autoincrement,"+
                Util.KEY_INPUT_TEXT + " text," +
                Util.KEY_SRC_LANG_TYPE + " text," +
                Util.KEY_TAR_LANG_TYPE + " text," +
                Util.KEY_TRANSLATED_TEXT + " text)";
        db.execSQL(CREATE_MEMO_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String DROP_TABLE = "drop table " + Util.TABLE_NAME;
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void addTranslation(Translation translation){
        // 1. 저장하기 위해서, writable db 를 가져온다.
        Log.i("AAA","database Add");
        SQLiteDatabase db = this.getWritableDatabase();
        // 2. db에 저장하기 위해서는, ContentValues 를 이용한다.
        ContentValues values = new ContentValues();
        values.put(Util.KEY_INPUT_TEXT, translation.getInputTxt());
        values.put(Util.KEY_SRC_LANG_TYPE,translation.getSrcLangType());
        values.put(Util.KEY_TAR_LANG_TYPE,translation.getTarLangType());
        values.put(Util.KEY_TRANSLATED_TEXT,translation.getTranslatedText());
        // 3. db에 실제로 저장한다.
        db.insert(Util.TABLE_NAME, null, values);
        db.close();

    }

    // 메모1개 불러오는 메소드
    public Translation getTranslation(int id){
        // 1. 데이터베이스 가져온다. 조회니까, readable 한 db로 가져온다.
        SQLiteDatabase db = this.getReadableDatabase();

        // select id, title, content from Employee where id = 2;
        // 2. 데이터를 셀렉트(조회) 할때는, Cursor 를 이용해야 한다.
        Cursor cursor = db.query(Util.TABLE_NAME,
                new String[] {Util.KEY_ID, Util.KEY_INPUT_TEXT, Util.KEY_SRC_LANG_TYPE,Util.KEY_TAR_LANG_TYPE,Util.KEY_TRANSLATED_TEXT},
                Util.KEY_ID + " = ? ",
                new String[]{String.valueOf(id)},
                null, null, null);

        if(cursor != null){
            cursor.moveToFirst();
        }

        int selectedId = Integer.parseInt(cursor.getString(0));
        String selectedInput = cursor.getString(1);
        String selectedSrc = cursor.getString(2);
        String selectedTar =  cursor.getString(3);
        String selectedTranslation =cursor.getString(4);
        // db에서 읽어온 데이터를, 자바 클래스로 처리한다.
        Translation translation = new Translation(selectedId,selectedSrc,selectedTar,selectedTranslation,selectedInput);

        return translation;
    }

    // 전체 저장된 데이터 모두 가져오기.
    public ArrayList<Translation> getAllTranslation(){
        // 1. 비어 있는 어레이 리스트를 먼저 한개 만든다.
        ArrayList<Translation> translationList = new ArrayList<>();

        // 2. 데이터베이스에 select (조회) 해서,
        String selectAll = "select * from " + Util.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectAll, null);

        // 3. 여러개의 데이터를 루프 돌면서, Contact 클래스에 정보를 하나씩 담고
        if(cursor.moveToFirst()){
            do {


                int selectedId = Integer.parseInt(cursor.getString(0));
                String selectedInput = cursor.getString(1);
                String selectedSrc = cursor.getString(2);
                String selectedTar =  cursor.getString(3);
                String selectedTranslation =cursor.getString(4);
                // db에서 읽어온 데이터를, 자바 클래스로 처리한다.
                Translation translation = new Translation(selectedId,selectedSrc,selectedTar,selectedTranslation,selectedInput);

                // 4. 위의 빈 어레이리스트에 하나씩 추가를 시킨다.
                translationList.add(translation);

            }while(cursor.moveToNext());
        }
        return translationList;
    }
    // 데이터 삭제 메서드
    public void deleteTranslation(Translation translation){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME,  // 테이블 명
                Util.KEY_ID + " = ?",   // where id = ?
                new String[]{String.valueOf(translation.getId())});  // ? 에 해당하는 값.
        db.close();
    }
}
