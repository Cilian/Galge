package com.example.sren.galge;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Restart extends DialogFragment {

  //  Button restart;
    Galgelogik spil = new Galgelogik();
    Button restart;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

    //    restart = getView().findViewById(R.id.restart);
    //    restart.setOnClickListener(this);

      View rootView=inflater.inflate(R.layout.fragment_restart,container,false);

      restart = rootView.findViewById(R.id.restart);
      restart.setOnClickListener(new View.OnClickListener() {

        @Override
        public void onClick(View v) {


        }
      });


        return rootView;




    }






    public void restarter(){


    }

}
