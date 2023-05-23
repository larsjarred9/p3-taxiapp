package com.example.taxibedrijf.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.taxibedrijf.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CarFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CarFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // inflate the layout for this fragment
        var view: View = inflater.inflate(R.layout.fragment_car, container, false)

        var kentekenInput : TextView = view.findViewById(R.id.kenteken)
        var merkInput : TextView = view.findViewById(R.id.merk)
        var datumTenaamstellingInput : TextView = view.findViewById(R.id.tenaamstelling)

        // get data from the arguments bundle
        val kenteken = arguments?.getString("kenteken")
        val merk = arguments?.getString("merk")
        val datumTenaamstelling = arguments?.getString("datumTenaamstelling")

        kentekenInput.text = kenteken
        merkInput.text = merk

        // format the date
        val year = datumTenaamstelling?.substring(0, 4)
        val month = datumTenaamstelling?.substring(4, 6)
        val day = datumTenaamstelling?.substring(6, 8)

        datumTenaamstellingInput.text = "$day-$month-$year"


        return view
    }
}