package com.example.day03;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;//database
    HelperDB hlp;//מחלקת עזר


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hlp = new HelperDB(this);
        db =hlp.getWritableDatabase();//הרשאת כתיבה
        db.close();
    }
}