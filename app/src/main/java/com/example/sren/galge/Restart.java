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
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.content.Context.MODE_PRIVATE;


public class Restart extends Fragment {
    Button restart;
    TextView finalScore, msg, fejl, antalFejl,tv, dinScore;
    EditText name;
    ArrayList<UserScore> users = new ArrayList<UserScore>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        String score = getArguments().getString("score");
        String antal_fejl = getArguments().getString("fejl");

        View rootView=inflater.inflate(R.layout.fragment_restart,container,false);

        final GameActivity activity = (GameActivity) getActivity();

        msg = rootView.findViewById(R.id.msg);
        name = rootView.findViewById(R.id.name);
        fejl = rootView.findViewById(R.id.fejl);
        antalFejl = rootView.findViewById(R.id.antalFejl);
        tv = rootView.findViewById(R.id.tv);
        finalScore = rootView.findViewById(R.id.finalScore);
        dinScore = rootView.findViewById(R.id.dinScore);

        finalScore.setText(score);
        fejl.setText(antal_fejl);

        restart = rootView.findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("Du klikkede på restart");
 //               pref.edit().putString("userName", name.getText().toString()).apply();

                System.out.println("Navn: " + name.getText().toString());
                System.out.println("Point: " + activity.spil.getPoint());

                String username = name.getText().toString();
                int point = activity.spil.getPoint();

                loadUser();
                users.add(new UserScore(null, username, point));
                saveUser();
                getActivity().onBackPressed();
            }
        });

        return rootView;
    }

    public void saveUser(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("highscore", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        Gson gson = new Gson();
        String json = gson.toJson(users);
        editor.putString("list",json);
        editor.apply();
    }

    public void loadUser(){
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("highscore", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("list",null);
        Type type = new TypeToken<ArrayList<UserScore>>() {}.getType();
        users = gson.fromJson(json,type);
        if(users == null){
            System.out.println("Shared is null");
            users = new ArrayList<>();
        }
    }
}
