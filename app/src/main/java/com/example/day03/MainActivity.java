package com.example.day03;

import androidx.appcompat.app.AppCompatActivity;
import static com.example.day03.Grade.*;
import static com.example.day03.Student.*;
import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;//database
    HelperDB hlp;//מחלקת עזר
    private ContentValues cv=new ContentValues();
    private EditText name;
    private EditText parent;
    private EditText address;
    private EditText sphone;
    private EditText lphone;
    private EditText pphone;
    private EditText activ;
    private Switch swi;
    private Button b1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.tw_name);
        parent = findViewById(R.id.tw_parent);
        address = findViewById(R.id.tw_address);
        sphone = findViewById(R.id.tw_s);
        lphone = findViewById(R.id.tw_l);
        pphone = findViewById(R.id.tw_p);
        activ = findViewById(R.id.tw_active);
        swi = findViewById(R.id.swi1);
        b1= findViewById(R.id.ad);

        hlp = new HelperDB(this);
        db =hlp.getWritableDatabase();//הרשאת כתיבה
        db.close();

        swi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swi.isChecked()){
                    parent.setHint("subject:");
                    address.setHint("type:");
                    sphone.setHint("semester:");
                    lphone.setHint("active:");//שימי לב נייד הופך לגי- אקטיב
                    pphone.setHint("");
                    activ.setHint("");
                }
                else {
                    parent.setHint("parent:");
                    address.setHint("address:");
                    sphone.setHint("Mobile Phone:");
                    lphone.setHint("local phone:");
                    pphone.setHint("Parent's phone:");
                    activ.setHint("active:");
                }
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(swi.isChecked()){
                    cv.put(Student.NAME, name.getText().toString());
                    cv.put(Student.PARENT, parent.getText().toString());
                    cv.put(Student.ADDRESS, address.getText().toString());
                    cv.put(Student.S_PHONE, sphone.getText().toString());
                    cv.put(Student.L_PHONE, lphone.getText().toString());
                    cv.put(Student.P_PHONE, pphone.getText().toString());
                    cv.put(Student.ACTIVE, activ.getText().toString());
                    db =hlp.getWritableDatabase();
                    db.insert(TABLE_STUDENT, null, cv);
                    db.close();
                }
                else {
                    cv.put(Grade.GNAME, name.getText().toString());
                    cv.put(Grade.SUBJECT, parent.getText().toString());
                    cv.put(Grade.TYPE, address.getText().toString());
                    cv.put(Grade.SEMESTER, sphone.getText().toString());
                    cv.put(Grade.GACTIVE, lphone.getText().toString());
                    db =hlp.getWritableDatabase();
                    db.insert(TABLE_GRADE, null, cv);
                    db.close();
                }

            }
        });
    }

}