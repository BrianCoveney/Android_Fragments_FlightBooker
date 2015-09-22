package com.example.brian.android_fragments_lt4.view;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.brian.android_fragments_lt4.R;


public class MainActivity extends FragmentActivity implements FirstFragment.FlightSearcher  {


    private RadioButton radBtn1;
    private RadioButton radBtn2;


    @Override
    public void refreshFlightList()
    {
        FragmentManager mgr = getFragmentManager();
        SecondFragment secondFragmentRef =
                (SecondFragment)mgr.findFragmentById(R.id.second_fragment);

        secondFragmentRef.refreshList();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radBtn1 = (RadioButton) findViewById(R.id.radioButton1);
        radBtn1.setOnCheckedChangeListener(btnOnChangeListener);
        radBtn2 = (RadioButton) findViewById(R.id.radioButton2);
        radBtn2.setOnCheckedChangeListener(btnOnChangeListener);
    }


    //Changing RadioButton text
    private CompoundButton.OnCheckedChangeListener btnOnChangeListener =
            new CompoundButton.OnCheckedChangeListener(){
                public void onCheckedChanged(CompoundButton buttonView,
                                             boolean isChecked){
                    if(isChecked){
                        buttonView.setTypeface(null, Typeface.BOLD_ITALIC);

                    }else{
                        buttonView.setTypeface(null, Typeface.NORMAL);
                    }
                }
            };




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
