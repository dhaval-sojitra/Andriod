package com.example.dbdemo20

import android.annotation.SuppressLint
import android.app.appsearch.AppSearchManager.SearchContext
import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.SearchView

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    lateinit var rs : Cursor
    lateinit var edtname : EditText
    lateinit var edtcity : EditText
    lateinit var edtgender : EditText
    lateinit var btnnext : Button
    lateinit var btnprev : Button
    lateinit var btnfirst : Button
    lateinit var btnlast : Button
    lateinit var btnshow : Button
    lateinit var listview : ListView
    lateinit var searchview : SearchView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btninsert : Button = findViewById(R.id.btninsert)
        var btnupdate : Button = findViewById(R.id.btnupdate)
        var btnclear : Button = findViewById(R.id.btnclear)
        var btndelete : Button = findViewById(R.id.btndelete)
        btnnext = findViewById(R.id.btnnext)
        btnprev = findViewById(R.id.btnprev)
        btnfirst = findViewById(R.id.btnfirst)
        btnlast = findViewById(R.id.btnlast)
        btnshow = findViewById(R.id.btnshow)
        edtname = findViewById(R.id.edtname)
        edtcity = findViewById(R.id.edtcity)
        edtgender = findViewById(R.id.edtgender)
        listview = findViewById(R.id.listview)
        searchview = findViewById(R.id.searchview)

        var helper = MyDBHelper(applicationContext)
        var db = helper.writableDatabase
        rs = db.rawQuery("select * from student",null)

        btninsert.setOnClickListener {
            var cv = ContentValues()
            cv.put("name",edtname.text.toString())
            cv.put("city",edtcity.text.toString())
            cv.put("gender",edtgender.text.toString())
            db.insert("student",null,cv)
            Toast.makeText(applicationContext, "Record Inserted Successfully..", Toast.LENGTH_SHORT).show()
            edtname.setText("")
            edtcity.setText("")
            edtgender.setText("")
            edtname.requestFocus()
        }

        btnupdate.setOnClickListener {
            var cv = ContentValues()
            cv.put("name",edtname.text.toString())
            cv.put("city",edtcity.text.toString())
            cv.put("gender",edtgender.text.toString())
            db.update("student",cv,"id = ?", arrayOf(rs.getString(0)))
            Toast.makeText(applicationContext, "Record Update Successfully...", Toast.LENGTH_SHORT).show()
        }

        btndelete.setOnClickListener {
            db.delete("student","id = ?", arrayOf(rs.getString(0)))
            Toast.makeText(applicationContext, "Record Deleted Successfully...", Toast.LENGTH_SHORT).show()
        }

        btnclear.setOnClickListener {
            edtname.setText("")
            edtcity.setText("")
            edtgender.setText("")
            edtname.requestFocus()
        }

        btnnext.setOnClickListener {
            if(rs.moveToNext()){
                edtname.setText(rs.getString(1))
                edtcity.setText(rs.getString(2))
                edtgender.setText(rs.getString(3))
            }
            else if(rs.moveToFirst()){
                edtname.setText(rs.getString(1))
                edtcity.setText(rs.getString(2))
                edtgender.setText(rs.getString(3))
            }
            else{
                Toast.makeText(applicationContext, "Data not found...", Toast.LENGTH_SHORT).show()
            }
        }

        btnprev.setOnClickListener {
            if(rs.moveToPrevious()){
                edtname.setText(rs.getString(1))
                edtcity.setText(rs.getString(2))
                edtgender.setText(rs.getString(3))
            }
            else if(rs.moveToLast()){
                edtname.setText(rs.getString(1))
                edtcity.setText(rs.getString(2))
                edtgender.setText(rs.getString(3))
            }
            else{
                Toast.makeText(applicationContext, "Data not found...", Toast.LENGTH_SHORT).show()
            }
        }
        btnfirst.setOnClickListener {
            if(rs.moveToFirst()){
                edtname.setText(rs.getString(1))
                edtcity.setText(rs.getString(2))
                edtgender.setText(rs.getString(3))
            }
            else{
                Toast.makeText(applicationContext, "Data not found...", Toast.LENGTH_SHORT).show()
            }
        }
        btnlast.setOnClickListener {
            if(rs.moveToLast()){
                edtname.setText(rs.getString(1))
                edtcity.setText(rs.getString(2))
                edtgender.setText(rs.getString(3))
            }
            else{
                Toast.makeText(applicationContext, "Data not found...", Toast.LENGTH_SHORT).show()
            }
        }
        btnshow.setOnClickListener {
            searchview.queryHint = "search Among ${rs.count} Records"
            var adpater = SimpleCursorAdapter(applicationContext,android.R.layout.simple_list_item_2,rs,
                arrayOf("name","city","gender"),
                intArrayOf(android.R.id.text1,android.R.id.text2,android.R.id.content)
            )
            listview.adapter = adpater
        searchview.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(p0: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {
                rs = db.rawQuery("select * from student where name like '%${p0}%'",null)
                adpater.changeCursor(rs)
                return false
            }

        })
        }
    }

//    private fun showmessage(s: String) {
//        AlertDialog.Builder(this)
//            .setTitle("Success..")
//            .setMessage("s")
//            .setPositiveButton("ok",DialogInterface.OnClickListener { dialog, which ->
//                if(rs.moveToFirst()){
//                    edtname.setText(rs.getString(1))
//                    edtcity.setText(rs.getString(2))
//                    edtgender.setText(rs.getString(3))
//                }
//                else{
//                    Toast.makeText(applicationContext, "Data Not Found!", Toast.LENGTH_SHORT).show()
//                }
//            })
//    }


}