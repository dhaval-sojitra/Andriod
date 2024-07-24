package com.example.busbooking

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.example.busbooking.splashscreen.Companion.editor

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var edtusertype = findViewById<EditText>(R.id.edtusertype)
        var edtusername = findViewById<EditText>(R.id.edtusername)
        var edtpassword = findViewById<EditText>(R.id.edtpassword)
        var btnlogin = findViewById<Button>(R.id.btnlogin)
        var btnregester = findViewById<Button>(R.id.btnregester)

        btnlogin.setOnClickListener {
            var edtusertype = edtusertype.text.toString()
            var edtusername = edtusername.text.toString()
            var edtpassword = edtpassword.text.toString()


            var selectdb = Mydatabase(this@MainActivity)
            var cursor = selectdb.selectlogin(edtusertype, edtusername, edtpassword)
            if (cursor.moveToNext()) {
                if (edtusertype == "Admin" || edtusertype == "Client") {

                    var usertype = cursor.getString(1)
                    var username = cursor.getString(2)

                    if (usertype == "Admin") {
                        editor.putString("username", username)
                        editor.putBoolean("login", true)
                        editor.apply()
                        startActivity(Intent(this@MainActivity, homeadmin::class.java))
                        finish()
                    } else if (usertype == "Client") {

                        editor.putString("username", username)
                        editor.putBoolean("login1", true)
                        editor.apply()

                        startActivity(Intent(this@MainActivity, homeclient::class.java))
                        finish()
                    } else {
                        Toast.makeText(this, "User Not Found", Toast.LENGTH_SHORT).show()
                    }

                    Toast.makeText(this, "Login Success", Toast.LENGTH_SHORT).show()
                } else
                    Toast.makeText(this, "Select UserType", Toast.LENGTH_SHORT).show()
            } else
                Toast.makeText(this, "User Not Found", Toast.LENGTH_SHORT).show()
        }

        btnregester.setOnClickListener {
            startActivity(Intent(this@MainActivity, Regestration::class.java))
        }

    }
}