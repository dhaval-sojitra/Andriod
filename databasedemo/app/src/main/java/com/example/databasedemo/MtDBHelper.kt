package com.example.databasedemo

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class MyDBHelper(context : Context) : SQLiteOpenHelper(context,"STUDENT_DB",null,1){
    override fun onCreate(p0: SQLiteDatabase?) {
        p0?.execSQL("create table student(sid integer primary key autoincrement,sname text,sem number)")
        p0?.execSQL("insert into student(sname,sem) values ('Dhaval',3)")
        p0?.execSQL("insert into student(sname,sem) values ('Keval',2)")

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
    }

}
