package com.example.busbooking

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.cardview.widget.CardView
import com.example.busbooking.splashscreen.Companion.editor
import com.example.busbooking.splashscreen.Companion.sp

class homeclient : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_homeclient)

        var cardcbooking = findViewById<CardView>(R.id.cardcbooking)
        var cardccancle = findViewById<CardView>(R.id.cardccancle)
        var cardctrack = findViewById<CardView>(R.id.cardctrack)
        var cardclogout = findViewById<CardView>(R.id.cardclogout)

        cardcbooking.setOnClickListener{
            startActivity(Intent(this@homeclient,ticketbooking::class.java))

        }
        cardccancle.setOnClickListener{
            startActivity(Intent(this@homeclient,cancleticket::class.java))

        }
        cardctrack.setOnClickListener{
            startActivity(Intent(this@homeclient,trackticket::class.java))

        }
        cardclogout.setOnClickListener{

            startActivity(Intent(this@homeclient,MainActivity::class.java))
            finish()
            editor.clear()
            editor.apply()



        }

    }
}