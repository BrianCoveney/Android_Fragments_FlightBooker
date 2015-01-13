package com.example.brian.android_fragments_lt4.controller;

import com.example.brian.android_fragments_lt4.model.Flight;

import java.util.ArrayList;

/**
 * Created by Brian on 12/01/2015.
 */
public class FlightController {

    private static FlightController instance;

    private ArrayList<Flight> flightList;

    private FlightController(){

        this.flightList = new ArrayList<Flight>();

    }

    public static FlightController getInstance(){

        if(instance == null){
            instance = new FlightController();
        }
        return instance;

    }

    public void addFlight(String origin, String destination){
        Flight f = new Flight(origin, destination);
        this.flightList.add(f);
    }

    public ArrayList<Flight> getFlights(){
        return this.flightList;
    }




}
