package com.example.sren.galge;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Restart extends Fragment {
    Button restart;
    TextView msg;
    TextView finalScore;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.fragment_restart,container,false);

        GameActivity activity = (GameActivity)  getActivity();
        Boolean winner = activity.getWinner();

        msg = rootView.findViewById(R.id.msg);

        if(winner)
            msg.setText("Du vandt!");
        else
            msg.setText("Du tabte!");

        finalScore = rootView.findViewById(R.id.finalScore);
        finalScore.setText("" + activity.spil.getPoint());

        SharedPreferences pref = activity.getApplicationContext().getSharedPreferences("Highscores", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt("currentScore", activity.spil.getPoint()).commit();

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
