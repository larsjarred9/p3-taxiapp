package com.example.taxibedrijf.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.taxibedrijf.R
import com.example.taxibedrijf.content.Car
import com.example.taxibedrijf.content.CarAdapter
import org.json.JSONArray

class HomeFragment : Fragment(), AdapterView.OnItemClickListener {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_home, container, false)

        var lv: ListView = view.findViewById(R.id.ListView)

        // set url for the api call
        val url = "https://opendata.rdw.nl/resource/m9d7-ebf2.json"

        // Create a new request queue
        val requestQueue = Volley.newRequestQueue(this.requireContext())

        // Create a new string request
        val stringRequest = object : StringRequest(
            Method.GET, url,
            { response ->
                val jsonArray = JSONArray(response)

                val carsArray = mutableListOf<Car>()


                // Get the first 50 cars out of the array
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

                    val car = Car(kenteken, merk, datumTenaamstelling)
                    carsArray.add(car)
                }


                // Create a new car object
                var ad = CarAdapter(view.context, carsArray)

                // Asign click listener to the listview
                lv.onItemClickListener = this
                lv.adapter = ad
            },
            { error ->
                println(error)
            }
        ) {}

        // Add the request to the request queue and return the view
        requestQueue.add(stringRequest)

        // return the view
        return view;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onItemClick(parent: AdapterView<*>?, p1: View?, position: Int, p3: Long) {
        // Get the car object from the listview
        val car: Car = parent?.getItemAtPosition(position) as Car

        // Create a bundle to pass data to the next fragment
        val bundle = Bundle()
        bundle.putString("kenteken", car.kenteken)
        bundle.putString("merk", car.merk)
        bundle.putString("datumTenaamstelling", car.datumTenaamstelling)

        // Create a new CarFragment and pass the bundle to it
        val carFragment = CarFragment()
        carFragment.arguments = bundle

        // Get the FragmentManager
        val fragmentManager = requireActivity().supportFragmentManager

        // Replace the current fragment with the CarFragment
        fragmentManager.beginTransaction()
            .replace(R.id.FragmentLayout, carFragment)
            .addToBackStack(null)
            .commit()
    }


}