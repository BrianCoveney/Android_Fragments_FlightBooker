package com.example.brian.android_fragments_lt4.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.brian.android_fragments_lt4.R;
import com.example.brian.android_fragments_lt4.model.Flight;

/**
 * Created by Brian on 08/02/2015.
 */
public class SendEmailDialog extends DialogFragment {

    private Flight theFlight;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        theFlight = (Flight) getArguments().getSerializable("flightObj");
    }

    // Override the Fragment.onAttach() method to instantiate the NoticeDialogListener
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

    }


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Build the dialog and set up the button click handlers
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setMessage(R.string.dialog_send_email)
                .setPositiveButton(R.string.send, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
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

                        //if (intent.resolveActivity(getPackageManager()) != null) {
                        startActivity(intent);
                    }
                })
                .setNegativeButton(R.string.cancel,new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dismiss();
                    }
                });
        return builder.create();
    }



    }


