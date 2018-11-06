package com.example.sren.galge;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class LoserFragment extends Fragment {

    Button restart;
    TextView word;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_loser, container, false);
        final GameActivity activity = (GameActivity) getActivity();
        word = rootView.findViewById(R.id.word);
        word.setText("" + activity.spil.getOrdet());

        restart = rootView.findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Du klikkede på restart");

                getActivity().onBackPressed();
            }
        });

        return rootView;
    }
}