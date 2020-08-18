package com.hajni.memo.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;


import com.hajni.memo.model.Contact;
import com.hajni.memo.util.Util;

import java.util.ArrayList;

public class DatabaseHandler extends SQLiteOpenHelper {


    public DatabaseHandler(@Nullable Context context) {
        super(context, Util.DATABASE_NAME, null, Util.DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACT_TABLE = "create table " + Util.TABLE_NAME +
                "("+Util.KEY_ID + " integer not null primary key autoincrement ," +
                Util.KEY_TITLE + " text, " +
                Util.KEY_CONTENTS + " text ) ";

        db.execSQL(CREATE_CONTACT_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DROP_TABLE = "drop table " + Util.TABLE_NAME;
        db.execSQL(DROP_TABLE);

        onCreate(db);
    }

    public void addMemo(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Util.KEY_TITLE,contact.getTitle());
        values.put(Util.KEY_CONTENTS,contact.getContents());

        db.insert(Util.TABLE_NAME,null,values);
        db.close();

    }
    public Contact getContact(int id){
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(Util.TABLE_NAME,
                new String[]{Util.KEY_ID,Util.KEY_TITLE,Util.KEY_CONTENTS},
                Util.KEY_ID + " = ?", new String[]{String.valueOf(id)},
                null,null,null);
        if (cursor != null){
            cursor.moveToFirst();
        }
        int selectedId = Integer.parseInt(cursor.getString(0));
        String selectedTitle = cursor.getString(1);
        String selectedContents = cursor.getString(2);


        Contact contact = new Contact();
        contact.setId(selectedId);
        contact.setTitle(selectedTitle);
        contact.setContents(selectedContents);


        return contact;
    }

    public ArrayList<Contact> getAllContacts(){
        // 1. 비어 있는 어레이 리스트를 먼저 한개 만든다.
        ArrayList<Contact> contactList = new ArrayList<>();
        // 2. 데이터베이스에 select(조회) 해서,
        String selectAll = "select * from " + Util.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectAll,null);
        // 3.여러개의 데이터를 루프 돌면서, Contact 클래스에 정보를 하나씩 담고
        if(cursor.moveToFirst()){
            do{
                int selectedId = Integer.parseInt(cursor.getString(0));
                String selectedTitle = cursor.getString(1);
                String selectedContents = cursor.getString(2);
                Contact contact = new Contact();
                contact.setId(selectedId);
                contact.setTitle(selectedTitle);
                contact.setContents(selectedContents);

                // 4. 위의 빈 어레이 리스트에 하나씩 추가를 시킨다.
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }




    public ArrayList<Contact> getAllContacts(String contents){
        // 1. 비어 있는 어레이 리스트를 먼저 한개 만든다.
        ArrayList<Contact> contactList = new ArrayList<>();
        // 2. 데이터베이스에 select(조회) 해서,
        String selectAll = "select * from " + Util.TABLE_NAME + " where contents like '%"+ contents+"%'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectAll,null);
        // 3.여러개의 데이터를 루프 돌면서, Contact 클래스에 정보를 하나씩 담고
        if(cursor.moveToFirst()){
            do{
                int selectedId = Integer.parseInt(cursor.getString(0));
                String selectedTitle = cursor.getString(1);
                String selectedContents = cursor.getString(2);
                Contact contact = new Contact();
                contact.setId(selectedId);
                contact.setTitle(selectedTitle);
                contact.setContents(selectedContents);

                // 4. 위의 빈 어레이 리스트에 하나씩 추가를 시킨다.
                contactList.add(contact);
            }while(cursor.moveToNext());
        }
        return contactList;
    }


    // 데이터를 업데이트 하는 메서드.
    public int updateContact(Contact contact){
        SQLiteDatabase db = this.getReadableDatabase();

        ContentValues values = new ContentValues();
        values.put(Util.KEY_TITLE,contact.getTitle());
        values.put(Util.KEY_CONTENTS,contact.getContents());

        // 데이터베이스 테이블 업데이트.
        // update contacts set name = "홍길동, phone = "010-3333-3333" where id = 3;
        int ret = db.update(Util.TABLE_NAME, // 테이블명
                values, // 업데이트할 값
                Util.KEY_ID + " = ?", // where
                new String[]{String.valueOf(contact.getId())}); // ? 에 들어갈 값
        return ret;
    }

    // 데이터 삭제 메서드
    public void deleteContact(Contact contact){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Util.TABLE_NAME, // 테이블 명
                Util.KEY_ID + " = ?", // where id = ?
                new String[]{String.valueOf(contact.getId())}); // ? 에 해당하는 값
        db.close();
    }

    // 테이블에 저장된 주소록 데이터의 전체 갯수를 리턴하는 메소드.
    public int getCount(){
        // select count(*) from contacts;
        String countQuery = "select * from " + Util.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery,null);
        int count = cursor.getCount();
        db.close();
        return count;
    }





}