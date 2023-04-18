package com.example.taxibedrijf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class SearchActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        // Get search input from MainActivity (intent) and set it to the SearchText TextView
        val searchinput = intent.getStringExtra("search")
        val searchtext : TextView = findViewById(R.id.SearchText)

        searchtext.text = searchinput
    }
}