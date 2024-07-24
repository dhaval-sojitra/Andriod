package com.example.busbooking

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class trackticket : AppCompatActivity() {
    var arrylist = ArrayList<Trackticketdataclass>()
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trackticket)

        var phone = findViewById<EditText>(R.id.edtttphone)
        var btntrack = findViewById<Button>(R.id.btnttrack)
        var tcrv  = findViewById<RecyclerView>(R.id.tticketrv)

        btntrack.setOnClickListener {
            var phone = phone.text.toString()

            var trackticket = Mydatabase(this)
            var cursor = trackticket.selectticket(phone)



                while (cursor.moveToNext()){
                    var name = cursor.getString(1)
                    var ridd = cursor.getInt(2)
                    var from = cursor.getString(3)
                    var to = cursor.getString(4)
                    var date = cursor.getString(5)
                    var sno = cursor.getInt(6)
                    var phonee = cursor.getString(7)

                    var trackticketdataclass = Trackticketdataclass(name, ridd, from, to, date, sno, phonee)
                    arrylist.add(trackticketdataclass)


                }
                var trackticketrv = Trackticketrv(this@trackticket, arrylist, trackticket)
                tcrv.adapter = trackticketrv



        }
    }
}