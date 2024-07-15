package com.example.relativelayout_allbuttons

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button : Button = findViewById(R.id.button)
        var imgbtn : ImageButton = findViewById(R.id.imageButton)
        var tglbtn : ToggleButton = findViewById(R.id.toggleButton)
        var imgview : ImageView = findViewById(R.id.imageView)

        button.setOnClickListener {
            Toast.makeText(applicationContext,"Simple Button Clicked..",Toast.LENGTH_LONG).show()
        }
        imgbtn.setOnClickListener {
            Toast.makeText(applicationContext,"View Button Clicked..",Toast.LENGTH_LONG).show()
        }
        tglbtn.setOnClickListener {
            if(tglbtn.text.equals("OFF")){
                imgview.setImageResource(R.drawable.off)
            }
            else{
                imgview.setImageResource(R.drawable.on)
            }
        }
    }
}