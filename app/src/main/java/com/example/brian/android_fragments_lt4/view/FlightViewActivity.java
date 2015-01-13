package com.example.brian.android_fragments_lt4.view;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.example.brian.android_fragments_lt4.R;
import com.example.brian.android_fragments_lt4.model.Flight;

/**
 * Created by Brian on 13/01/2015.
 */
public class FlightViewActivity extends Activity {

    private Flight theFlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //call on the layout file to populate this activity
        setContentView(R.layout.activity_flightview);

        theFlight = (Flight)getIntent().getSerializableExtra("selectedFlight");
        TextView textView = (TextView)findViewById(R.id.flightDisplayField);
        textView.setText(theFlight.toString());
    }
}
