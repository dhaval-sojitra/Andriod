package com.example.busbooking

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class cancleticket : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cancleticket)

        var mobile = findViewById<EditText>(R.id.edtcmoblie)
        var rid = findViewById<EditText>(R.id.edtcrid)
        var btncancle = findViewById<Button>(R.id.btnccancle)

        btncancle.setOnClickListener {
            var phone = mobile.text.toString()
            var rid = rid.text.toString()
            if (phone=="" || rid ==""){
                Toast.makeText(this, "Enter Mobile Number", Toast.LENGTH_SHORT).show()
            }
            else{
                var cancleticket = Mydatabase(this)
                cancleticket.cticket(phone,rid)
                Toast.makeText(this, "Ticket Cancle", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this@cancleticket,homeclient::class.java))
                finish()
            }
        }
    }
}