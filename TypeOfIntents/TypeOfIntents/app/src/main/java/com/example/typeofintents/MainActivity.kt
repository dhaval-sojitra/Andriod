package com.example.typeofintents

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var name : EditText = findViewById(R.id.edittextname)
        var surname : EditText = findViewById(R.id.edittextsurname)
        var button : Button =findViewById(R.id.button)

        button.setOnClickListener {
            var i = Intent(this,Activity2::class.java)
            i.putExtra("name",name.text.toString())
            i.putExtra("surname",surname.text.toString())
            startActivity(i)
        }

    }
}