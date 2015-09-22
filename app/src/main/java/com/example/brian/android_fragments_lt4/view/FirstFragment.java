package com.example.brian.android_fragments_lt4.view;

import android.app.Activity;
import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Spinner;

import com.example.brian.android_fragments_lt4.R;
import com.example.brian.android_fragments_lt4.controller.FlightController;

/**
 * Created by Brian on 08/01/2015.
 */
public class FirstFragment extends Fragment {

    private FlightSearcher searcher;

    //The interface whice this fragment uses to communicate up to its Activity
    public interface FlightSearcher
    {
        public void refreshFlightList();
    }

    @Override
    public void onAttach(Activity activity) {
        searcher = (FlightSearcher)activity;
        super.onAttach(activity);
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

            return inflater.inflate(R.layout.fragment_first, container, false);
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        setUpListeners();
        super.onActivityCreated(savedInstanceState);
    }

    private void setUpListeners() {
        Button findFlights = (Button) getActivity().findViewById(R.id.find_flights_button);

        findFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner originSpinner = (Spinner) getActivity().findViewById(R.id.origin_spinner);
                String selectedOrigin = originSpinner.getSelectedItem().toString();

                Spinner destinationSpinner = (Spinner) getActivity().findViewById(R.id.destination_spinner);
                String selectedDestination = destinationSpinner.getSelectedItem().toString();

                //Calls out to the controller to put the data into the model,
                //then tells the bottom fragment to refresh itself from the update model
                FlightController.getInstance().addFlight(selectedOrigin, selectedDestination);

                searcher.refreshFlightList();
            }
        });

    }


}
