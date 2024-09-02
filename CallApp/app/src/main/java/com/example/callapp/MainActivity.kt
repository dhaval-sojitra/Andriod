package com.example.callapp

import android.annotation.SuppressLint
import android.content.Intent
import android.content.pm.PackageManager
import android.database.Cursor
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.widget.ListView
import android.widget.SearchView
import android.widget.SimpleCursorAdapter
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    var cols = arrayOf(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME,
        ContactsContract.CommonDataKinds.Phone.NUMBER,
        ContactsContract.CommonDataKinds.Phone._ID)
    private var cursor: Cursor? = null
    private var adapter: SimpleCursorAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button : FloatingActionButton = findViewById(R.id.floatingActionButton)

        button.setOnClickListener {
            val intent = Intent(Intent.ACTION_INSERT)
            intent.data = ContactsContract.RawContacts.CONTENT_URI
            startActivity(intent)
        }

        if (ActivityCompat.checkSelfPermission(this,android.Manifest.permission.READ_CONTACTS) != PackageManager.PERMISSION_GRANTED ){
            ActivityCompat.requestPermissions(this, arrayOf(android.Manifest.permission.READ_CONTACTS),111)
        }
        else{
            readContacts()
        }
        var searchView : SearchView = findViewById(R.id.search)

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let { filterContacts(it) }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let { filterContacts(it) }
                return true
            }
        })
    }

    override fun onResume() {
        super.onResume()
        // Refresh contacts when activity resumes
        if (ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED) {
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


        cursor = contentResolver.query(
            ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
            cols,
            null,
            null,
            ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
        )

        adapter = SimpleCursorAdapter(
            applicationContext,
            android.R.layout.simple_list_item_2,
            cursor,
            cols,
            intArrayOf(android.R.id.text1, android.R.id.text2),0
        )
        listview.adapter = adapter

        listview.setOnItemClickListener { _, _, position, _ ->
            cursor?.moveToPosition(position)
            val phoneNumber = cursor?.getString(cursor?.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER) ?:-1)
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
    private fun filterContacts(query: String) {
        cursor?.let {
            it.close() // Close the old cursor to prevent leaks
            val filteredCursor = contentResolver.query(
                ContactsContract.CommonDataKinds.Phone.CONTENT_URI,
                cols,
                "${ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME} LIKE ?",
                arrayOf("%$query%"),
                ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME
            )
            adapter?.swapCursor(filteredCursor)
            cursor = filteredCursor // Update the cursor reference
        }
    }



}