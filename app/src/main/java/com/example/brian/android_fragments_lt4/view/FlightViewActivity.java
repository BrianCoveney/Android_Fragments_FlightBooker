package com.example.brian.android_fragments_lt4.view;


import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.brian.android_fragments_lt4.R;
import com.example.brian.android_fragments_lt4.model.Flight;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Brian on 13/01/2015.
 */
public class FlightViewActivity extends FragmentActivity  {

    private Flight theFlight;
    private Button sendEmail;
    private Button fileBtn;
    private Button hideFileBtn;
    private TextView fileTv;
    private ToggleButton toggle;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flightview);



        //Display the file
        fileBtn = (Button) findViewById(R.id.fileButton);
        fileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Read from file into a text view
                fileTv = (TextView) findViewById(R.id.fileOriginsTv);
                fileTv.setText(readText());
                fileTv.setVisibility(View.VISIBLE);
            }
        });

        //Hide the file
        hideFileBtn = (Button) findViewById(R.id.hideFileButton);
        hideFileBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fileTv = (TextView) findViewById(R.id.fileOriginsTv);
                fileTv.setVisibility(View.INVISIBLE);
            }
        });

        //Toggle Show / Hide
        ToggleButton toggle = (ToggleButton) findViewById(R.id.toggleShowHide);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                            fileTv = (TextView) findViewById(R.id.fileOriginsTv);
                            fileTv.setText(readText());
                            fileTv.setVisibility(View.VISIBLE);

                } else {
                            fileTv = (TextView) findViewById(R.id.fileOriginsTv);
                            fileTv.setVisibility(View.INVISIBLE);
                        }
            }
        });



        //Get users flight selection and place into a text view
        theFlight = (Flight) getIntent().getSerializableExtra("selectedFlight");
        TextView textView = (TextView) findViewById(R.id.flightDisplayField);
        textView.setText(theFlight.toString());


        /***
         On first run this button shows the dialog, then when button is
         pressed again it launches the email
         */
        sendEmail = (Button) findViewById(R.id.emailButton);
        sendEmail.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                // Create an instance of the dialog fragment and show it
                DialogFragment dialog = new SendEmailDialog();
                Bundle b = new Bundle();
                b.putSerializable("flightObj", theFlight);
                dialog.setArguments(b);
                dialog.show(getFragmentManager(), "my_email");

            }

        });
    }


    //Function to read text from a file
    public String readText() {

        InputStream inputStream = getResources().openRawResource(R.raw.flight_list);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        int i;
        try {
            i = inputStream.read();
            while (i != -1) {
                byteArrayOutputStream.write(i);
                i = inputStream.read();
            }
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return byteArrayOutputStream.toString();
    }
}
