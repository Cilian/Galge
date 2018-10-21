package com.example.sren.galge;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class Restart extends Fragment {

  //  Button restart;
    Galgelogik spil = new Galgelogik();
    GameActivity game = new GameActivity();


    Button restart;
    TextView msg;
    View rootView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment

    //    restart = getView().findViewById(R.id.restart);
    //    restart.setOnClickListener(this);

      rootView = inflater.inflate(R.layout.fragment_restart,container,false);
     // msg = rootView.findViewById(R.id.msg);
      msg = (TextView)rootView.findViewById(R.id.msg);

      System.out.println("Ja"+ spil.erSpilletVundet());
      System.out.println("Nej" + spil.erSpilletVundet());


      System.out.println("checkwinner " + game.getWin());
      if(game.getWin())
              msg.setText("Du vandt!");
          else
              msg.setText("Du tabte!");



      restart = rootView.findViewById(R.id.restart);
      restart.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
          System.out.println("Clicked on restart");
        }
      });

        return rootView;
    }
  public void CheckMessage(Boolean v){
    if(v == true)
      msg.setText("Du vandt!");
     else
       msg.setText("Du tabte!");
  }

}
