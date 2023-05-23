package com.example.taxibedrijf.ui

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.taxibedrijf.R
import org.json.JSONArray
import org.json.JSONObject

class HomeFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_home, container, false)

        // set url for the api call
        val url = "https://opendata.rdw.nl/resource/m9d7-ebf2.json"

        // Create a new request queue
        val requestQueue = Volley.newRequestQueue(this.requireContext())

        // Create a new string request
        val stringRequest = object : StringRequest(
            Method.GET, url,
            { response ->
                val jsonArray = JSONArray(response)


                // Krijg de eerste 50 auto's uit de api
                for (i in 0 until 50) {
                    val carObject = jsonArray.getJSONObject(i)
                    val kenteken = carObject.optString("kenteken", "Unknown")
                    val merk = carObject.optString("merk", "Unknown")
                    val datumTenaamstelling = carObject.optString("datum_tenaamstelling", "Unknown")

                    println("Car ${i + 1}")
                    println("Kenteken: $kenteken")
                    println("Merk: $merk")
                    println("Datum Tenaamstelling: $datumTenaamstelling")
                    println()
                }
            },
            { error ->
                println(error)
            }
        ) {}

        // Add the request to the request queue and return the view
        requestQueue.add(stringRequest)

        // return the view
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}