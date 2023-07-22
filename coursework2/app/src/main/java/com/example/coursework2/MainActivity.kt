package com.example.coursework2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button


class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // When a button is clicked, it starts a new activity using an Intent.
        val click = findViewById<Button>(R.id.button1)
        click.setOnClickListener {
            val page2 = Intent(this@MainActivity,Page2::class.java)
            startActivity(page2)
        }

        val click2 = findViewById<Button>(R.id.button2)
        click2.setOnClickListener {
            val page3 = Intent(this@MainActivity,Page3::class.java)
            startActivity(page3)
        }

        val click3 = findViewById<Button>(R.id.button3)
        click3.setOnClickListener {
            val page4 = Intent(this@MainActivity,Page4::class.java)
            startActivity(page4)
        }

        val click4 = findViewById<Button>(R.id.button4)
        click4.setOnClickListener {
            val retrievedFromWeb = Intent(this@MainActivity,RetrievedFromWeb::class.java)
            startActivity(retrievedFromWeb)
        }
    }


}