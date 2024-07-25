package com.example.typeofintents

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.app.NavUtils
import org.w3c.dom.Text

class Activity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_2)

        var txtname : TextView = findViewById(R.id.textView)
        var txtsurname : TextView = findViewById(R.id.textView2)
        var btn : Button = findViewById(R.id.button)

        var intent : Intent = intent
        var name = intent.getStringExtra("name")
        var surname = intent.getStringExtra("surname")

        txtname.setText("Name : "+name)
        txtsurname.setText("Surname : "+surname)

        btn.setOnClickListener {
            var uri = Uri.parse("https://www.google.com")
            var i = Intent(Intent.ACTION_VIEW,uri)
            startActivity(i)
        }

        var edtnum : EditText = findViewById(R.id.edtphone)
        var numbtn : Button = findViewById(R.id.button2)
        numbtn.setOnClickListener{
            var uri = Uri.parse()
        }
    }
}