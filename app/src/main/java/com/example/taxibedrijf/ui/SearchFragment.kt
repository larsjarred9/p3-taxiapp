package com.example.taxibedrijf.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.taxibedrijf.R

class SearchFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        var view : View =  inflater.inflate(R.layout.fragment_search, container, false)

        // get search data from bundle
        val searchData = arguments?.getString("search")

        // set searchText input to searchData
        val searchtext : TextView = view.findViewById(R.id.searchText)

        searchtext.text = searchData

        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}