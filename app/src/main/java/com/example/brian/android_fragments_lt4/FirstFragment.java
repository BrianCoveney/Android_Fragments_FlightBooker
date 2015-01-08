package com.example.brian.android_fragments_lt4;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Spinner;

/**
 * Created by Brian on 08/01/2015.
 */
public class FirstFragment extends Fragment {

    private FlightSearcher searcher;

    //The interface whice this fragment uses to communicate up to its Activity
    public interface FlightSearcher
    {
        public void searchForFlight(String origin, String destination);
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

    private void setUpListeners(){
        Button findFlights = (Button)getActivity().findViewById(R.id.find_flights_button);
        findFlights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Spinner originSpinner = (Spinner)getActivity().findViewById(R.id.origin_spinner);
                String selectedOrigin = originSpinner.getSelectedItem().toString();

                Spinner destinationSpinner = (Spinner)getActivity().findViewById(R.id.destination_spinner);
                String selectedDestination = destinationSpinner.getSelectedItem().toString();

                searcher.searchForFlight(selectedOrigin, selectedDestination);

            }

        });
    }


}
