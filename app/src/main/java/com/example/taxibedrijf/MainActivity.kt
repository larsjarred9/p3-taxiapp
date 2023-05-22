package com.example.taxibedrijf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.example.taxibedrijf.ui.HomeFragment
import com.example.taxibedrijf.ui.SearchFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Create an instance of the Fragments
        val homeFragment = HomeFragment()
        var searchFragment = SearchFragment()
        // Set layout to activity_main
        setContentView(R.layout.activity_main)

        // Set fragment to homeFragment on start
        supportFragmentManager.beginTransaction().add(R.id.FragmentLayout, homeFragment).commit()

        // Search input and button
        val searchinput : TextView = findViewById(R.id.SearchInput)
        val searchbutton : Button = findViewById(R.id.SearchBtn)


        // @event click on searchbutton
        searchbutton.setOnClickListener {
            // Get search input data
            val searchData = searchinput.text.toString()

            // Create bundle and add search data
            var b : Bundle = Bundle()
            b.putString("search", searchData)

            // Set arguments to searchFragment
            searchFragment.arguments = b

            // Switch fragment to searchFragment
            supportFragmentManager.beginTransaction().replace(R.id.FragmentLayout, searchFragment).commit()
        }


    }
}