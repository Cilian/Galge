package com.example.sren.galge;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Restart extends Fragment {

  //  Button restart;
    Galgelogik spil = new Galgelogik();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

    //    restart = getView().findViewById(R.id.restart);
    //    restart.setOnClickListener(this);

        return inflater.inflate(R.layout.fragment_restart, container, false);




    }






    public void restarter(){


    }

}
