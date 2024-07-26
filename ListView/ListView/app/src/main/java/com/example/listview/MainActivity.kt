package com.example.listview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var listview : ListView = findViewById(R.id.listview)

        var city = arrayOf("Rajkot","Surat","Ahemedabad","Baroda","Amreli")
        var adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,city)
        listview.adapter = adapter

        listview.setOnItemClickListener { adapterView, view, i, l ->
            var value = listview.getItemAtPosition(i).toString()
            var i = Intent(this,Rajkot_Activity::class.java)
            if (value.equals("Rajkot")){
                i.putExtra("city",value)
                var dis  = "Rajkot has been under different rulers since it was founded. It has had a long history and had a significant influence in the Indian independence movement. Rajkot was home to many personalities like Mahatma Gandhi."
                i.putExtra("disc",dis.toString())
                var path = R.drawable.rajkot
                i.putExtra("path",path)
            }
            else if (value.equals("Surat")){
                i.putExtra("city",value)
                var dis  = "Surat is one of the cleanest city of India and is also known by several other names like \"THE SILK CITY\", \"THE DIAMOND CITY\", \"THE GREEN CITY\", etc."
                i.putExtra("disc",dis.toString())
                var path = R.drawable.surat
                i.putExtra("path",path)
            }
            else if (value.equals("Ahemedabad")){
                i.putExtra("city",value)
                var dis  = "Ahmedabad is the largest city in the State of Gujarat and the Seventh- largest urban agglomeration in India, with a population of almost 74 lakhs (7.4 Million). City is Located on the banks of the River Sabarmati."
                i.putExtra("disc",dis.toString())
                var path = R.drawable.ahemedabad
                i.putExtra("path",path)
            }
            else if (value.equals("Baroda")){
                i.putExtra("city",value)
                var dis  = "Vadodara (Gujarati: [ʋəˈɽodɾɑ]), also known as Baroda, is a major city in the Indian state of Gujarat. It serves as the administrative headquarters of the Vadodara district and is situated on the banks of the Vishwamitri River, 141 km (88 mi) from the state capital of Gandhinagar."
                i.putExtra("disc",dis.toString())
                var path = R.drawable.baroda
                i.putExtra("path",path)
            }
            else if (value.equals("Amreli")){
                i.putExtra("city",value)
                var dis  = "Amreli is a city and a municipality in Amreli district in Indian state of Gujarat. Amreli. City. Amreli Tower. Amreli is located in Gujarat. Amreli."
                i.putExtra("disc",dis.toString())
                var path = R.drawable.amreli
                i.putExtra("path",path)
            }


            startActivity(i)
//            Toast.makeText(applicationContext,value,Toast.LENGTH_LONG).show()
        }
    }
}