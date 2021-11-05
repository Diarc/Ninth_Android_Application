package com.example.listaobecnosci_zadanie9;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.LinkedList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "persons.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.initiateDB(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    private void initiateDB(SQLiteDatabase db) {
        db.execSQL(
                "create table persons(" +
                        "id integer primary key autoincrement," +
                        "name text," +
                        "lastName text," +
                        "subject text);" + "");
    }

    public void clearDB() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS persons");
        initiateDB(db);
    }

    public void addMan(Man man) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues content = new ContentValues();
        content.put("name", man.getName());
        content.put("lastName", man.getLastName());
        content.put("subject", man.getSubject());
        db.insertOrThrow("persons", null, content);
    }

    public List<Man> getAllStudents() {
        List<Man> students = new LinkedList<Man>();
        String[] columns = {"id", "name", "lastName", "subject"};
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("persons", columns, null, null, null, null, null);
        while (cursor.moveToNext()) {
            Man man = new Man();
            man.setId(cursor.getLong(0));
            man.setName(cursor.getString(1));
            man.setLastName(cursor.getString(2));
            man.setLastName(cursor.getString(3));
            students.add(man);
        }
        return students;
    }
}