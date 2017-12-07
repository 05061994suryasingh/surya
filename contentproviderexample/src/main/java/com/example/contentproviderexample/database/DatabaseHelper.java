package com.example.contentproviderexample.database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static com.example.contentproviderexample.database.DbConstant.DATABASE_NAME;
import static com.example.contentproviderexample.database.DbConstant.DATABASE_VERSION;

/**
 * Created by admin on 12/5/2017.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    static final String STUDENTS_TABLE_NAME = "students";
    static final String CREATE_DB_TABLE =
            " CREATE TABLE " + STUDENTS_TABLE_NAME +
                    " (_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    " name TEXT NOT NULL, " +
                    " grade TEXT NOT NULL);";

    public DatabaseHelper(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_DB_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +  STUDENTS_TABLE_NAME);
        onCreate(db);
    }
}
