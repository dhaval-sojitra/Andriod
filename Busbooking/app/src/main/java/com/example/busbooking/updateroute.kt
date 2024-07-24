package com.example.busbooking

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class updateroute : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updateroute)

        var edturbid = findViewById<EditText>(R.id.edturbid)
        var edturrid = findViewById<EditText>(R.id.edturrid)
        var edturfrom = findViewById<EditText>(R.id.edturfrom)
        var edturto = findViewById<EditText>(R.id.edturto)
        var edturdate = findViewById<EditText>(R.id.edturdate)
        var edturtime = findViewById<EditText>(R.id.edturtime)
        var edturprice = findViewById<EditText>(R.id.edturprice)
        var btnurupdate = findViewById<Button>(R.id.btnurupdate)

        edturdate.setOnClickListener {
            val datePicker = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    // Set the selected date to the EditText
                    val calendar = Calendar.getInstance()
                    calendar.set(year, monthOfYear, dayOfMonth)
                    val selectedDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)
                    edturdate.setText(selectedDate)
                },
                // Set the default date in the dialog
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            )

            datePicker.show()

        }
        edturtime.setOnClickListener {
            val timePicker = TimePickerDialog(
                this,
                { _, hourOfDay, minute ->
                    // Set the selected time to the EditText
                    val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                    edturtime.setText(selectedTime)
                },
                // Set the default time in the dialog
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE),
                true // Set to true to enable 24-hour format
            )

            timePicker.show()
        }

        var rid = intent.getIntExtra("rid",0)
        var bid = intent.getIntExtra("bid",0)
        var from = intent.getStringExtra("from")
        var to = intent.getStringExtra("to")
        var date = intent.getStringExtra("date")
        var time = intent.getStringExtra("time")
        var price = intent.getIntExtra("price",0)
        
        edturrid.setText(rid.toString())
        edturbid.setText(bid.toString())
        edturfrom.setText(from)
        edturto.setText(to)
        edturdate.setText(date)
        edturtime.setText(time)
        edturprice.setText(price.toString())
        
        btnurupdate.setOnClickListener {
            var rid = edturrid.text.toString()
            var bid = edturbid.text.toString()
            var from = edturfrom.text.toString()
            var to = edturto.text.toString()
            var date = edturdate.text.toString()
            var time = edturtime.text.toString()
            var price = edturprice.text.toString()
            
            var updateroute = Mydatabase(this)
            updateroute.updateroutee(rid,bid,from,to,date,time,price)
            
            startActivity(Intent(this@updateroute,routmast::class.java))
            finish()
            Toast.makeText(this, "Route Update", Toast.LENGTH_SHORT).show()
        }
    }
}