package com.example.brian.android_fragments_lt4.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.brian.android_fragments_lt4.R;


public class MainActivity extends FragmentActivity implements FirstFragment.FlightSearcher  {


    @Override
    public void refreshFlightList()
    {
        FragmentManager mgr = getFragmentManager();
        SecondFragment secondFragmentRef =
                (SecondFragment)mgr.findFragmentById(R.id.second_fragment);

        secondFragmentRef.refreshList();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
