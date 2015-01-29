package com.example.brian.android_fragments_lt4.view;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.brian.android_fragments_lt4.controller.FlightController;
import com.example.brian.android_fragments_lt4.model.Flight;

import java.util.ArrayList;

/**
* Created by Brian on 08/01/2015.
*/
public class SecondFragment extends ListFragment {


    private ArrayAdapter<Flight> adapter;


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {

        ArrayList<Flight> flights =  FlightController.getInstance().getFlights();
        this.adapter
                = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, flights);

        setListAdapter(this.adapter);
        super.onActivityCreated(savedInstanceState);



    }

    public void refreshList()
    {
        this.adapter.notifyDataSetChanged();
    }


    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {

        //Create a new instance of Intent - our context is our Activity - then our new FlightViewActivity class
        Intent i = new Intent(getActivity(), FlightViewActivity.class);
        //Call the controller, we get the flight list and within that list we get the item at that position
        //dictated what was selected in the list fragment
        Flight selectedFlight = FlightController.getInstance().getFlights().get(position);

        //put our flight object into the bundle
        i.putExtra("selectedFlight", selectedFlight);
        startActivity(i);



    }
}