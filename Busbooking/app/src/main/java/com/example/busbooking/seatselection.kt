package com.example.busbooking

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class seatselection : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seatselection)

        var seatno = findViewById<EditText>(R.id.edtseat)
        var btnbook = findViewById<Button>(R.id.btnbook)



        btnbook.setOnClickListener {
            var from = intent.getStringExtra("from")
            var to = intent.getStringExtra("to")
            var date = intent.getStringExtra("date")
            var name = intent.getStringExtra("name")
            var phone = intent.getStringExtra("phone")
            var seat = seatno.text.toString()
            var riddd =intent.getStringExtra("rid")
            if (seat==""){
                Toast.makeText(this, "Enter SeatNo", Toast.LENGTH_SHORT).show()
            }
            else{
            var bookticket = Mydatabase(this)
            bookticket.booktickett(name,riddd,from,to,date,seat,phone)
            Toast.makeText(this, "Booking Success", Toast.LENGTH_SHORT).show()
            seatno.setText("")
            startActivity(Intent(this@seatselection,homeclient::class.java))
            finish()
            }

        }




    }
}