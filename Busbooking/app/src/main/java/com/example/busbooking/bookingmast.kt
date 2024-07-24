package com.example.busbooking

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.RecyclerView

class bookingmast : AppCompatActivity() {
    var arrylist = ArrayList<Bookingmastdataclass>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bookingmast)
        var rid = findViewById<EditText>(R.id.edtbmrid)
        var btnsearch = findViewById<Button>(R.id.btnbmsearch)
        var bookingmastrvv = findViewById<RecyclerView>(R.id.bookingmastrv)



        btnsearch.setOnClickListener {
            startActivity(Intent(this@bookingmast,bookingmast::class.java))
            finish()

            var bookingdb = Mydatabase(this)
            var cursor = bookingdb.selectbooking(rid.text.toString())


            while(cursor.moveToNext()){
                var name = cursor.getString(1)
                var ridd = cursor.getInt(2)
                var from = cursor.getString(3)
                var to = cursor.getString(4)
                var date = cursor.getString(5)
                var sno = cursor.getInt(6)
                var phonee = cursor.getString(7)

                var bookingmastdataclass = Bookingmastdataclass(name, ridd, from, to, date, sno, phonee)
                arrylist.add(bookingmastdataclass)


            }
            var bookingmastrv = Bookingmastrv(this@bookingmast, arrylist, bookingdb)
            bookingmastrvv.adapter = bookingmastrv


            
            
        }
        
    }
}