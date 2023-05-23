package com.example.taxibedrijf.content

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class CarAdapter(context: Context, cars: List<Car>) : ArrayAdapter<Car>(context, android.R.layout.simple_list_item_1, cars) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)

        val car = getItem(position)
        val kentekenTextView = view.findViewById<TextView>(android.R.id.text1)
        if (car != null) {
            kentekenTextView.text = car.kenteken
        }

        return view
    }
}