package com.example.busbooking

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast

class Regestration : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_regestration)

        var edtrname = findViewById<EditText>(R.id.edtrname)
        var edtrusertype = findViewById<EditText>(R.id.edtrusertype)
        var edtrusername = findViewById<EditText>(R.id.edtrusername)
        var edtrphone = findViewById<EditText>(R.id.edtrphone)
        var edtrpassword = findViewById<EditText>(R.id.edtrpassword)
        var btnrregester = findViewById<Button>(R.id.btnrregester)
        var btnrcanlce = findViewById<Button>(R.id.btnrcancle)


        btnrregester.setOnClickListener {
            var rname = edtrname.text.toString()
            var rusertype = edtrusertype.text.toString()
            var rusername = edtrusername.text.toString()
            var rphone = edtrphone.text.toString()
            var rpassword = edtrpassword.text.toString()

            var mydatabase = Mydatabase(this@Regestration)
            var cursor = mydatabase.selectregestration(rusername)
            if (cursor.moveToNext())
            {
                Toast.makeText(this, "Username Already Taken", Toast.LENGTH_SHORT).show()
            }
            else
            {
                if(rname=="" || rusertype=="" || rusername=="" || rphone=="" || rpassword==""){
                    Toast.makeText(this, "Enter Proper Details", Toast.LENGTH_SHORT).show()
                }
                else {
                    if (rusertype == "Admin" || rusertype == "Client") {
                        mydatabase.tableregestration(rname, rusertype, rusername, rphone, rpassword)
                        Toast.makeText(this, "Registration Success", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(this@Regestration, MainActivity::class.java))
                        finish()
                    } else
                        Toast.makeText(this, "Select UserType", Toast.LENGTH_SHORT).show()
                }
            }
        }
    btnrcanlce.setOnClickListener {
        startActivity(Intent(this@Regestration, MainActivity::class.java))
        finish()
    }


    }
}