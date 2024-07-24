package com.example.busbooking

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.text.SimpleDateFormat
import java.util.*

class updatebusmast : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_updatebusmast)

        var ubid = findViewById<EditText>(R.id.edtubid)
        var ubdate = findViewById<EditText>(R.id.edtubdate)
        var ubmodle = findViewById<EditText>(R.id.edtubmodel)
        var ubseat = findViewById<EditText>(R.id.edtubseat)
        var btnupdatd = findViewById<Button>(R.id.btnubupdate)
        ubdate.setOnClickListener {
            val datePicker = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    // Set the selected date to the EditText
                    val calendar = Calendar.getInstance()
                    calendar.set(year, monthOfYear, dayOfMonth)
                    val selectedDate =
                        SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)
                    ubdate.setText(selectedDate)
                },
                // Set the default date in the dialog
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            )

            datePicker.show()
        }

        var bid = intent.getIntExtra("bid",0)
        var date = intent.getStringExtra("date")
        var model = intent.getStringExtra("model")
        var seat = intent.getIntExtra("seat",0)

        ubid.setText(bid.toString())
        ubdate.setText(date)
        ubmodle.setText(model)
        ubseat.setText(seat.toString())

        btnupdatd.setOnClickListener {

            var updatebusmast = Mydatabase(this)
            updatebusmast.updatebus(ubid.text.toString(),ubdate.text.toString(),ubmodle.text.toString(),ubseat.text.toString())
            
            startActivity(Intent(this@updatebusmast,busmast::class.java))
            finish()
            Toast.makeText(this, "Bus Update", Toast.LENGTH_SHORT).show()
        }
    }
}