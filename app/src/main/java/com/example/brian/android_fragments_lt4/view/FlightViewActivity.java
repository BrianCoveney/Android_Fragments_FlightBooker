package com.example.brian.android_fragments_lt4.view;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import com.example.brian.android_fragments_lt4.R;
import com.example.brian.android_fragments_lt4.model.Flight;

import java.io.Serializable;

/**
 * Created by Brian on 13/01/2015.
 */
public class FlightViewActivity extends Activity {

    private Flight theFlight;
    private Button sendEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //call on the layout file to populate this activity
        setContentView(R.layout.activity_flightview);

        theFlight = (Flight)getIntent().getSerializableExtra("selectedFlight");
        TextView textView = (TextView)findViewById(R.id.flightDisplayField);
        textView.setText(theFlight.toString());

        sendEmail = (Button)findViewById(R.id.emailButton);
        sendEmail.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");

                intent.putExtra(Intent.EXTRA_EMAIL, getResources().getStringArray(R.array.intent_email));
                intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.intentSubject));

                // Concatenating 'message', to be placed in Intent.EXTRA_TEXT
                // Pass Serializable Flight object, as an extra to the Email Intent
                String message = "";
                message += getString(R.string.emailMessage1);
                message += "\n\n" + theFlight.toString();
                message += getString(R.string.emailMessage2);

                intent.putExtra(Intent.EXTRA_TEXT, message);


                if(intent.resolveActivity(getPackageManager()) != null){
                    startActivity(intent);
                }

            }
        });
    }
}
