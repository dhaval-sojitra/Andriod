package com.example.busbooking

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.widget.EditText
import android.widget.Toast

class splashscreen : AppCompatActivity() {

    companion object {
        lateinit var sp: SharedPreferences
        lateinit var editor: SharedPreferences.Editor
    }

    var islogin = false
    var islogin1 = false

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splashscreen)

        sp = getSharedPreferences("sharepreference", MODE_PRIVATE)
        editor = sp.edit()

        islogin = sp.getBoolean("login", false)
        islogin1 = sp.getBoolean("login1", false)

        Handler(mainLooper).postDelayed({
            if (islogin) {
                startActivity(Intent(this@splashscreen, homeadmin::class.java))
                finish()
            } else if (islogin1){
                startActivity(Intent(this@splashscreen, homeclient::class.java))
                finish()
            }
            else
            {
                startActivity(Intent(this@splashscreen, MainActivity::class.java))
                finish()
            }
        }, 500)
    }
}