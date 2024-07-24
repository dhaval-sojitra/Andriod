package com.example.busbooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.busbooking.splashscreen.Companion.editor

class homeadmin : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeadmin)

        var buscard = findViewById<CardView>(R.id.cardbusmast)
        var bookingcard = findViewById<CardView>(R.id.cardbooking)
        var routecard = findViewById<CardView>(R.id.cardroute)
        var logoutcard = findViewById<CardView>(R.id.cardlogout)

        buscard.setOnClickListener{
            startActivity(Intent(this@homeadmin,busmast::class.java))
        }
        bookingcard.setOnClickListener{
            startActivity(Intent(this@homeadmin,bookingmast::class.java))
        }
        routecard.setOnClickListener{
            startActivity(Intent(this@homeadmin,routmast::class.java))
        }
        logoutcard.setOnClickListener{
            startActivity(Intent(this@homeadmin,MainActivity::class.java))
            finish()
            editor.clear()
            editor.apply()

        }


    }
}