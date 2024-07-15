package com.example.relativelayout_allbuttons
import android.content.Intent
import android.net.Uri
import android.widget.EditText
import android.widget.ToggleButton
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var button: Button = findViewById(R.id.button)
        var imgbtn: ImageButton = findViewById(R.id.imageButton)
        var tglbtn: ToggleButton = findViewById(R.id.toggleButton)
        var imgview: ImageView = findViewById(R.id.imageView)
        var flotingbtn: FloatingActionButton = findViewById(R.id.floatingActionButton)

        button.setOnClickListener {
            Toast.makeText(applicationContext, "Simple Button Clicked..", Toast.LENGTH_LONG).show()
        }
        imgbtn.setOnClickListener {
            Toast.makeText(applicationContext, "View Button Clicked..", Toast.LENGTH_LONG).show()
        }
        tglbtn.setOnClickListener {
            if (tglbtn.text.equals("OFF")) {
                imgview.setImageResource(R.drawable.off)
            } else {
                imgview.setImageResource(R.drawable.on)
            }
        }
        flotingbtn.setOnClickListener {
            Toast.makeText(applicationContext, "Floting Action Button Clicked..", Toast.LENGTH_LONG).show()
        }

        var cb1 : CheckBox = findViewById(R.id.checkBox)
        var cb2 : CheckBox = findViewById(R.id.checkBox2)
        var cb3 : CheckBox = findViewById(R.id.checkBox3)
        var textview : TextView = findViewById(R.id.textView)
        var str : String

        cb1.setOnClickListener {
            str = "Java : ${cb1.isChecked} \nAndroid : ${cb2.isChecked}\nPython : ${cb3.isChecked}"
            textview.setText(str)
        }
        cb2.setOnClickListener {
            str = "Java : ${cb1.isChecked} \nAndroid : ${cb2.isChecked}\nPython : ${cb3.isChecked}"
            textview.setText(str)
        }
        cb3.setOnClickListener {
            str = "Java : ${cb1.isChecked} \nAndroid : ${cb2.isChecked}\nPython : ${cb3.isChecked}"
            textview.setText(str)
        }

        var rg : RadioGroup = findViewById(R.id.rg)
        var textview2 : TextView = findViewById(R.id.textView2)
        var reset : Button = findViewById(R.id.button2)

        rg.setOnCheckedChangeListener { radioGroup, i ->
            var rb = findViewById<RadioButton>(i)
            if(rb!=null){
            textview2.setText(rb.text)
        }
        }
        reset.setOnClickListener {
            rg.clearCheck()
            textview2.setText("Selected Options")
        }
    }
}
