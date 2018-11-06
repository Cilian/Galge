package com.example.sren.galge;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class UsernamePop extends Fragment implements View.OnClickListener {
    Button send;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView=inflater.inflate(R.layout.fragment_username_pop,container,false);

        send = rootView.findViewById(R.id.send);
        send.setOnClickListener(this);

        return rootView;


    }


    @Override
    public void onClick(View v) {
        if(v == send) {
            SharedPreferences pref = getActivity().getSharedPreferences("Highscores", 0); // 0 - for private mode
            SharedPreferences.Editor editor = pref.edit();

            editor.putString("username", send.getText().toString());

            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.setCustomAnimations(R.anim.slide_down_in, R.anim.slide_up_out);
            getActivity().onBackPressed();


        }
    }


}