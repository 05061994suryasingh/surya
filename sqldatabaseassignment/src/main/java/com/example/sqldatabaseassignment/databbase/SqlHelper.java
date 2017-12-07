package com.example.sqldatabaseassignment.databbase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.sqldatabaseassignment.utils.Utils;

/**
 * Created by admin on 12/6/2017.
 */

public class SqlHelper extends SQLiteOpenHelper {

    private  Context context ;
    private String TAG = this.getClass().getSimpleName();

    public SqlHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
        this.context = context ;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Utils.printLog(TAG ,"inside onCreate ()");
        db.execSQL(EmployeeDbOperation.CREATE_TABLE);
        db.execSQL(EmployeeDbOperation.CREATE_TABLE1);
        Utils.showToast(context ,"table created");
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        if (!db.isReadOnly()) {
            // Enable foreign key constraints
            db.setForeignKeyConstraintsEnabled(true);
        }
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + EmployeeDbOperation.TABLENAME);
        db.execSQL("DROP TABLE IF EXISTS " + EmployeeDbOperation.TABLENAME1);
        // db.execSQL("DROP table student");
        db.execSQL(EmployeeDbOperation.CREATE_TABLE);
        db.execSQL(EmployeeDbOperation.CREATE_TABLE1);

    }
}
