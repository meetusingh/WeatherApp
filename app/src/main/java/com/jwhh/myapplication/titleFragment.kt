package com.jwhh.myapplication

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.AutoCompleteTextView
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [title.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [title.newInstance] factory method to
 * create an instance of this fragment.
 *
 */
class title : Fragment(), AdapterView.OnItemClickListener {

    var autoCompleteTextView: AutoCompleteTextView? = null
    var postcode = arrayOf(
        "3000",
        "3024",
        "3030"
    )


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val rootview =  inflater.inflate(R.layout.fragment_title, container, false)

        autoCompleteTextView = rootview.findViewById(R.id.searchBar)
        val adapter = ArrayAdapter(this.activity, android.R.layout.simple_list_item_1, postcode)
        autoCompleteTextView?.setAdapter(adapter);
        autoCompleteTextView?.onItemClickListener = this

        val displayWeatherButton = rootview.findViewById<Button>(R.id.search_weather)
        displayWeatherButton.setOnClickListener { view : View -> view.findNavController().navigate(R.id.action_search_to_weatherList) }

        return rootview
    }

    override fun onItemClick(parent: AdapterView<*>, view: View, position: Int, id: Long) {

        // fetch the user selected value
        val item = parent.getItemAtPosition(position).toString()

    }

    override fun onContextItemSelected(item: MenuItem?): Boolean {
        return super.onContextItemSelected(item)
    }


}
