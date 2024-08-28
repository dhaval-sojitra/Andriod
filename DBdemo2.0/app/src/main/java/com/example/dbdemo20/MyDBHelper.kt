package com.example.dbdemo20

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context: Context) : SQLiteOpenHelper(context,"Student_db",null,1){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table student(_id integer primary key autoincrement,name text,city text,gender text)")
//        p0?.execSQL("insert into student(name,city,gender) values ('Dhaval','Surat','Male')")
//        p0?.execSQL("insert into student(name,city,gender) values ('Keval','Rajkot','Male')")
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

}