package com.example.busbooking

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class routmast : AppCompatActivity() {
    var arrylist = ArrayList<Routemastdataclass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routmast)

        var edtrbid = findViewById<EditText>(R.id.edtrbid)
        var edtrrid = findViewById<EditText>(R.id.edtrrid)
        var edtrfrom = findViewById<EditText>(R.id.edtrfrom)
        var edtrto = findViewById<EditText>(R.id.edtrto)
        var edtrdate = findViewById<EditText>(R.id.edtrdate)
        var edtrtime = findViewById<EditText>(R.id.edtrtime)
        var edtrprice = findViewById<EditText>(R.id.edtrprice)
        var btnradd = findViewById<Button>(R.id.btnradd)
        var routemastrv = findViewById<RecyclerView>(R.id.routemastrv)
        var rsearch = findViewById<SearchView>(R.id.rsearch)

        edtrdate.setOnClickListener {
            val datePicker = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    // Set the selected date to the EditText
                    val calendar = Calendar.getInstance()
                    calendar.set(year, monthOfYear, dayOfMonth)
                    val selectedDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)
                    edtrdate.setText(selectedDate)
                },
                // Set the default date in the dialog
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            )

            datePicker.show()

        }
        edtrtime.setOnClickListener {
            val timePicker = TimePickerDialog(
                this,
                { _, hourOfDay, minute ->
                    // Set the selected time to the EditText
                    val selectedTime = String.format("%02d:%02d", hourOfDay, minute)
                    edtrtime.setText(selectedTime)
                },
                // Set the default time in the dialog
                Calendar.getInstance().get(Calendar.HOUR_OF_DAY),
                Calendar.getInstance().get(Calendar.MINUTE),
                true // Set to true to enable 24-hour format
            )

            timePicker.show()
        }

        var addroute = Mydatabase(this@routmast)
        var id = edtrrid.text.toString()
        var cursor = addroute.selectrrid(id)
        rsearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(searchvalue: String): Boolean {

                var searchlist = ArrayList<Routemastdataclass>()

                for (element in arrylist) {
                    var routeid = element.rrid
                    var from = element.from
                    if (routeid.toString().toLowerCase()
                            .contains(searchvalue.toLowerCase()) || from.toString().toLowerCase()
                            .contains(searchvalue.toLowerCase())
                    ) {
                        searchlist.add(element)
                    }
                    var MyRecyclervriew = RoutemastRecyclerview(this@routmast, searchlist, addroute)
                    routemastrv.adapter = MyRecyclervriew


                }
                return false
            }
        })
        while (cursor.moveToNext())
        {
            var rrid = cursor.getInt(0)
            var bid = cursor.getInt(1)
            var from = cursor.getString(2)
            var to = cursor.getString(3)
            var date = cursor.getString(4)
            var time = cursor.getString(5)
            var price = cursor.getInt(6)

            var routemastdataclass = Routemastdataclass(rrid,bid,from,to,date,time,price)
            arrylist.add(routemastdataclass)
        }
        var MyRecyclervriew = RoutemastRecyclerview(this@routmast, arrylist, addroute)
        routemastrv.adapter=MyRecyclervriew


        btnradd.setOnClickListener {
            var rid = edtrrid.text.toString()
            var bid = edtrbid.text.toString()
            var from = edtrfrom.text.toString()
            var to = edtrto.text.toString()
            var date = edtrdate.text.toString()
            var time = edtrtime.text.toString()
            var price = edtrprice.text.toString()

            var routemast = Mydatabase(this)
            var cursor1 = routemast.selectid(rid)

            if (cursor1.moveToNext()) {
                Toast.makeText(this, "Routeid Already Taken", Toast.LENGTH_SHORT).show()
            } else {
                if (rid == "" || bid == "" || from == "" || to == "" || date == "" || time == "" || price == "") {
                    Toast.makeText(this, "Enter Proper Details", Toast.LENGTH_SHORT).show()
                } else {
                    routemast.addroute(rid, bid, from, to, date, time, price)
                    Toast.makeText(this, "Route Added", Toast.LENGTH_SHORT).show()
                    edtrrid.setText("")
                    edtrbid.setText("")
                    edtrfrom.setText("")
                    edtrto.setText("")
                    edtrdate.setText("")
                    edtrtime.setText("")
                    edtrprice.setText("")
                }

            }

            startActivity(Intent(this@routmast,routmast::class.java))
            finish()

        }


    }
}