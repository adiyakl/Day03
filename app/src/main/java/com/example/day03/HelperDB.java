package com.example.day03;

import static com.example.day03.Grade.*;
import static com.example.day03.Student.*;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class HelperDB extends SQLiteOpenHelper {
    public static final String DATABASE_NAME ="dbexam.db";
    public static final int DATABASE_VERSION=1;
    private String strCreate,strDelete;
    public HelperDB(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        strCreate="CREATE TABLE "+TABLE_STUDENT;
        strCreate+=" ("+KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+NAME+" TEXT,";
        strCreate+=" "+PARENT+" TEXT,";
        strCreate+=" "+ADDRESS+" TEXT,";
        strCreate+=" "+S_PHONE+" TEXT,";
        strCreate+=" "+L_PHONE+" TEXT,";
        strCreate+=" "+P_PHONE+" TEXT,";
        strCreate+=" "+ACTIVE+" TEXT";//פרמטר אחד לפני האחרון בלי פסיק!
        strCreate+=");";
        db.execSQL(strCreate);

        strCreate="CREATE TABLE "+TABLE_GRADE;
        strCreate+=" ("+KEY_ID+" INTEGER PRIMARY KEY,";
        strCreate+=" "+SUBJECT+" TEXT,";
        strCreate+=" "+GNAME+" TEXT,";
        strCreate+=" "+GACTIVE+" TEXT,";
        strCreate+=" "+TYPE+" INTEGER,";
        strCreate+=" "+SEMESTER+" INTEGER";
        strCreate+=");";
        db.execSQL(strCreate);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        strDelete="DROP TABLE IF EXISTS "+TABLE_STUDENT;
        db.execSQL(strDelete);
        strDelete="DROP TABLE IF EXISTS "+TABLE_GRADE;
        db.execSQL(strDelete);
        onCreate(db);
    }
}

//בכל פעם שנרצה לפנות לבסיס נתונים במחלקה
//db = hlp.getWritableDatabase();
//הרשאת כתיבה
//db.insert(Grades.TABLE_GRADES, null, cv);
//םעולה על בסיס נתונים
//db.close();
//סגירת תקשורת