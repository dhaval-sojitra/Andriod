package com.example.callapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {

    var cols = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS),111)
        }
        else{
            readContacts()
        }
    }

    override fun onRequestPermissionsResult(requestCode: Int,permissions: Array<out String>,grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (requestCode == 111 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            readContacts()
        }
    }

    @SuppressLint("Range")
    private fun readContacts() {
        var listview : ListView = findViewById(R.id.listview)

        var rs = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI,cols,
            null,null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME)
        var adapter = SimpleCursorAdapter(applicationContext,android.R.layout.simple_list_item_2,rs,cols,
            intArrayOf(android.R.id.text1,android.R.id.text2),0)

        listview.adapter = adapter

        listview.setOnItemClickListener { _, _, position, _ ->
            // Move the cursor to the clicked item position
            rs?.moveToPosition(position)

            // Extract the phone number from the cursor
            val phoneNumber = rs?.getString(rs.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))

            // Make a call if the phone number is not null
            phoneNumber?.let { makeCall(it) }
        }

    }
    private fun makeCall(phoneNumber: String) {
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.CALL_PHONE),112)
        } else {
            val intent = Intent(Intent.ACTION_CALL).apply {
                data = Uri.parse("tel:$phoneNumber")
            }
            startActivity(intent)
        }
    }
}