package com.example.taxibedrijf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Search input and button
        val searchinput : TextView = findViewById(R.id.SearchInput)
        val searchbutton : Button = findViewById(R.id.SearchBtn)


        // Search button on click -> Intent to SearchActivity
        searchbutton.setOnClickListener {
            val intent = Intent(this, SearchActivity::class.java)
            intent.putExtra("search", searchinput.text.toString())
            startActivity(intent)
        }


    }
}