package com.example.busbooking

import android.app.DatePickerDialog
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class busmast : AppCompatActivity() {
    var arrylist = ArrayList<Busmastdataclass>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_busmast)

        var edtbid = findViewById<EditText>(R.id.edtbid)
        var edtbdate = findViewById<TextView>(R.id.edtbdate)
        var edtbmodel = findViewById<EditText>(R.id.edtbmodel)
        var edtbseat = findViewById<EditText>(R.id.edtbseat)
        var btnbadd = findViewById<Button>(R.id.btnbadd)
        var busmastrv = findViewById<RecyclerView>(R.id.busmastrv)
        var bsearch = findViewById<SearchView>(R.id.bsearch)

        edtbdate.setOnClickListener {
            val datePicker = DatePickerDialog(
                this,
                { _, year, monthOfYear, dayOfMonth ->
                    // Set the selected date to the EditText
                    val calendar = Calendar.getInstance()
                    calendar.set(year, monthOfYear, dayOfMonth)
                    val selectedDate = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(calendar.time)
                    edtbdate.setText(selectedDate)
                },
                // Set the default date in the dialog
                Calendar.getInstance().get(Calendar.YEAR),
                Calendar.getInstance().get(Calendar.MONTH),
                Calendar.getInstance().get(Calendar.DAY_OF_MONTH)
            )

            datePicker.show()

        }

        var addbus = Mydatabase(this@busmast)
        var id = edtbid.text.toString()
        var cursor = addbus.selectbusid(id)

        while (cursor.moveToNext())
        {
            var bid =cursor.getInt(0)
            var bdate =cursor.getString(1)
            var bmodel =cursor.getString(2)
            var bseat =cursor.getInt(3)

            var busmastdataclass = Busmastdataclass(bid,bdate,bmodel,bseat)
            arrylist.add(busmastdataclass)

        }
        var MyRecyclervriew = BusmastRecyclerview(this@busmast, arrylist, addbus)
        busmastrv.adapter=MyRecyclervriew

        btnbadd.setOnClickListener {
            var bdate = edtbdate.text.toString()
            var model = edtbmodel.text.toString()
            var seat = edtbseat.text.toString()
            var addbus = Mydatabase(this@busmast)

            var id = edtbid.text.toString()
            var cursor2 = addbus.selectbusidd(id)
            if (cursor2.moveToNext()) {
                Toast.makeText(this, "Bus id already taken", Toast.LENGTH_SHORT).show()
            } else {
                if (id == "" || bdate == "" || model == "" || seat == "") {
                    Toast.makeText(this, "Enter Proper Details", Toast.LENGTH_SHORT).show()
                } else {
                    addbus.addbus(id, bdate, model, seat)
                    Toast.makeText(this, "Bus Added", Toast.LENGTH_SHORT).show()
                    edtbid.setText("")
                    edtbdate.setText("")
                    edtbmodel.setText("")
                    edtbseat.setText("")

                }

            }
            startActivity(Intent(this@busmast,busmast::class.java))
            finish()
        }

        bsearch.setOnQueryTextListener(object : SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(searchvalue: String): Boolean {

                var searchlist =ArrayList<Busmastdataclass>()

                for (element in arrylist)
                {
                    var busid = element.bid
                    var model = element.bmodel
                    if (busid.toString().toLowerCase().contains(searchvalue.toLowerCase())||model.toString().toLowerCase().contains(searchvalue.toLowerCase()))
                    {
                        searchlist.add(element)
                    }
                    var MyRecyclervriew = BusmastRecyclerview(this@busmast, searchlist, addbus)
                    busmastrv.adapter=MyRecyclervriew


                }
                return false
            }

        })




    }
}