package com.example.audio_player

import android.media.MediaPlayer
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {

    lateinit var btnaudio : Button
    lateinit var btnstop : Button
    lateinit var btnaudio1 : Button
    lateinit var btnstop1 : Button
    lateinit var mp : MediaPlayer


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnaudio = findViewById(R.id.btnaudio)
        btnaudio1 = findViewById(R.id.btnaudio1)
        btnstop = findViewById(R.id.btnstop)
        btnstop1 = findViewById(R.id.btnstop1)

        btnaudio.setOnClickListener {
            mp = MediaPlayer.create(this,R.raw.iphone)
            mp.start()
        }
        btnstop.setOnClickListener {
            mp.stop()
        }
        btnaudio1.setOnClickListener {
            mp= MediaPlayer()
            mp.setDataSource(this, Uri.parse("fdsfsd"))
            mp.prepare()
            mp.start()
        }
        btnstop1.setOnClickListener {
            mp.stop()
        }


    }
}