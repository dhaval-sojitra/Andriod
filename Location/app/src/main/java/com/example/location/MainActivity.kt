package com.example.location

import android.Manifest
import android.content.pm.PackageManager
import android.location.Geocoder
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import java.util.Locale

class MainActivity : AppCompatActivity() {

    lateinit var ed: EditText
    lateinit var btn: Button
    lateinit var tv: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ed = findViewById(R.id.editTextTextPersonName)
        btn = findViewById(R.id.button)
        tv = findViewById(R.id.textView2)

        btn.setOnClickListener {
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, arrayOf(Manifest.permission.ACCESS_FINE_LOCATION, Manifest.permission.ACCESS_COARSE_LOCATION), 111)
            } else {
                val city = ed.text.toString()
                forwardGeoCode(city)
            }
        }
    }

    private fun forwardGeoCode(city: String) {
        val geocoder = Geocoder(this, Locale.getDefault())
        try {
            val addresses = geocoder.getFromLocationName(city, 1)
            if (addresses.isNotEmpty()) {
                val address = addresses[0]
                val result = "${address.locality}, ${address.countryName}"
                tv.text = result
            } else {
                tv.text = "No results found"
            }
        } catch (e: Exception) {
            tv.text = "Error: ${e.message}"
        }
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == 111 && grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            val city = ed.text.toString()
            forwardGeoCode(city)
        }
    }
}
