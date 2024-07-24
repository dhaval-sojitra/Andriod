package com.example.busbooking

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class Mydatabase(
    context: Context?,

)    : SQLiteOpenHelper(context, "mydatabase", null, 1) {
    override fun onCreate(p0: SQLiteDatabase) {
        var create = "create table regestration (Name text,Usertype text,Username text primary key,Phone integer,Password text)"
        p0.execSQL(create)

        //busmast fields : Id,Date,Model,Seats
        var busmast = "create table busmast (Id integer,Date text,Model text,Seats integer)"
        p0.execSQL(busmast)

        var route = "create table routemast (Routeid integer primary key,Busid integer,Frompalce text,Toplace text,Date text,Time text,Price integer)"
        p0.execSQL(route)


        var booking = "create table bookingmast (Id integer Primary key Autoincrement,Name text,Routeid integer,Fromplace text,Toplace text,Date text,Seatno integer,Phone integer)"
        p0.execSQL(booking)

    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun tableregestration(rname: String, rusertype: String, rusername: String, rphone: String, rpassword: String) {
        var insert = "insert into regestration values ('$rname','$rusertype','$rusername','$rphone','$rpassword')"
        writableDatabase.execSQL(insert)
    }

    fun selectlogin(edtusertype: String, edtusername: String, edtpassword: String) : Cursor{
        var select = "select * from regestration where Usertype = '$edtusertype' and Username = '$edtusername' and Password = '$edtpassword'"
        return readableDatabase.rawQuery(select,null)
    }

    fun selectregestration(rusername: String) : Cursor{
        var select = "select * from regestration where Username = '$rusername'"
        return readableDatabase.rawQuery(select,null)
    }

    fun addbus(id: String, bdate: String, model: String, seat: String) {
        var insertt = "insert into busmast values('$id','$bdate','$model','$seat')"
        writableDatabase.execSQL(insertt)
    }

    fun selectbusid(id: String) : Cursor{
        var select = "select * from busmast"
    return readableDatabase.rawQuery(select,null)
    }

    fun addroute(rid: String, bid: String, from: String, to: String, date: String, time: String, price: String) {
        var insert = "insert into routemast values('$rid','$bid','$from','$to','$date','$time','$price')"
        writableDatabase.execSQL(insert)
    }

    fun selectid(rid: String) : Cursor {
        var select = "select * from routemast where Routeid='$rid'"
        return readableDatabase.rawQuery(select,null)

    }

    fun selectbusidd(id: String) : Cursor{
        var select = "select * from busmast where Id = '$id'"
        return readableDatabase.rawQuery(select,null)

    }

    fun deletebus(id: Int) {
        var delete = "delete from busmast where Id = '$id'"
        writableDatabase.execSQL(delete)

    }

    fun selectrrid(id: String): Cursor {
        var select = "select * from routemast "
        return readableDatabase.rawQuery(select,null)

    }

    fun deleteroute(id: Int) {
        var delete = "delete from routemast where Routeid='$id'"
        writableDatabase.execSQL(delete)

    }

    fun updatebus(bid: String, date: String, model: String, seat: String) {

        var update = "update busmast set Date ='$date',Model = '$model',Seats='$seat' where Id='$bid'"
        writableDatabase.execSQL(update)

    }

    fun updateroutee(rid: String, bid: String, from: String, to: String, date: String, time: String, price: String) {
        var update = "update routemast set Busid = '$bid',Frompalce='$from',Toplace='$to',Date='$date',Time='$time',Price='$price' where Routeid='$rid'"
        writableDatabase.execSQL(update)

    }

    fun Selectroute(from: String, to: String, date: String) : Cursor{
        var select = "select * from routemast where Frompalce ='$from' and Toplace = '$to' or Date = '$date'"
        return readableDatabase.rawQuery(select,null)

    }



    fun booktickett(name: String?, rid: String?, from: String?, to: String?, date: String?, seat: String, phone: String?) {
        var insert = "insert into bookingmast (Name,Routeid,Fromplace,Toplace,Date,Seatno,Phone) values ('$name','$rid','$from','$to','$date','$seat','$phone')"
        writableDatabase.execSQL(insert)

    }

    fun cticket(phone: String, rid: String) {
        var cancle = "delete from bookingmast where Phone = '$phone' and Routeid = '$rid'"
        writableDatabase.execSQL(cancle)

    }

    fun selectticket(phone: String) : Cursor{
        var select = "select * from bookingmast where Phone = '$phone'"
        return readableDatabase.rawQuery(select,null)


    }

    fun selectbooking(rid: String): Cursor{
        var select = "select * from bookingmast where Routeid = '$rid'"
        return readableDatabase.rawQuery(select,null)

    }


}
