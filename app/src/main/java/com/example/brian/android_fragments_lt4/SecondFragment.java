package com.example.brian.android_fragments_lt4;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
* Created by Brian on 08/01/2015.
*/
public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater,
            ViewGroup container,
            Bundle savedInstanceState) {

            return inflater.inflate(R.layout.fragment_second, container, false);

    }




}