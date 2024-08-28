package com.example.dbdemo20

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.DialogInterface
import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")

    lateinit var rs : Cursor
    lateinit var edtname : EditText
    lateinit var edtcity : EditText
    lateinit var edtgender : EditText
    lateinit var bt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var btninsert : Button = findViewById(R.id.btninsert)
        var btnupdate : Button = findViewById(R.id.btnupdate)
        var btnclear : Button = findViewById(R.id.btnclear)
        var btndelete : Button = findViewById(R.id.btndelete)
        edtname = findViewById(R.id.edtname)
        edtcity = findViewById(R.id.edtcity)
        edtgender = findViewById(R.id.edtgender)

        var helper = MyDBHelper(applicationContext)
        var db = helper.writableDatabase
        rs = db.rawQuery("select * from student",null)
        if(rs.moveToFirst()){
            edtname.setText(rs.getString(1))
            edtcity.setText(rs.getString(2))
            edtgender.setText(rs.getString(3))
        }
        else{
            Toast.makeText(applicationContext, "Data Not Found!", Toast.LENGTH_SHORT).show()
        }

        btninsert.setOnClickListener {
            var cv = ContentValues()
            cv.put("name",edtname.text.toString())
            cv.put("city",edtcity.text.toString())
            cv.put("gender",edtgender.text.toString())
            db.insert("student",null,cv)
            Toast.makeText(applicationContext, "Record Inserted Successfully..", Toast.LENGTH_SHORT).show()

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