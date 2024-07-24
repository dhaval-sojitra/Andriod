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
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class ticketbooking : AppCompatActivity() {
    var arraylist =ArrayList<routerv>()


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ticketbooking)


        var edttfrom = findViewById<EditText>(R.id.edttfrom)
        var edttto = findViewById<EditText>(R.id.edttto)
        var edttrid = findViewById<EditText>(R.id.edttrid)
        var edttname = findViewById<EditText>(R.id.edttname)
        var edttphone = findViewById<EditText>(R.id.edttphone)
        var btntsearch = findViewById<Button>(R.id.btntsearch)
        var btntbook = findViewById<Button>(R.id.btntbookticket)
        val edttdate = findViewById<EditText>(R.id.datePickerEditText)
        var bookingrv = findViewById<RecyclerView>(R.id.bookingrv)


        edttdate.setOnClickListener {
            // Show the date picker dialog
            val datePicker = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    // Set the selected date to the EditText
                    val calendar = Calendar.getInstance()
                    calendar.set(year, monthOfYear, dayOfMonth)
                    val selectedDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)
                    edttdate.setText(selectedDate)
                },
                // Set the default date in the dialog
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            )

            datePicker.show()

        }


        btntsearch.setOnClickListener {
            var selectroute = Mydatabase(this)
            var from = edttfrom.text.toString()
            var to = edttto.text.toString()
            var date = edttdate.text.toString()
            var cursor = selectroute.Selectroute(from, to,date)

            while(cursor.moveToNext()) {
                var rrid = cursor.getInt(0)
                var bid = cursor.getInt(1)
                var from = cursor.getString(2)
                var to = cursor.getString(3)
                var date = cursor.getString(4)
                var time = cursor.getString(5)
                var price = cursor.getInt(6)

                var routerv = routerv(rrid, bid, from, to, date, time, price)
                arraylist.add(routerv)
            }
                var ticketbookingrvv = Ticketbookingrv(this@ticketbooking, arraylist, selectroute)
                bookingrv.adapter = ticketbookingrvv

        }

        btntbook.setOnClickListener {
            var from = edttfrom.text.toString()
            var to = edttto.text.toString()
            var date = edttdate.text.toString()
            var rid = edttrid.text.toString()
            var name = edttname.text.toString()
            var phone = edttphone.text.toString()

            if (from=="" || to=="" || date=="" || rid=="" || name=="" || phone==""){
                Toast.makeText(this, "Enter Proper Detalis", Toast.LENGTH_SHORT).show()
            }
            else{
                var intent = Intent(this@ticketbooking,seatselection::class.java)
                intent.putExtra("phone",phone)
                intent.putExtra("from",from)
                intent.putExtra("to",to)
                intent.putExtra("rid",rid)
                intent.putExtra("name",name)
                intent.putExtra("date",date)
                startActivity(intent)
                finish()
            }
        }
    }
}