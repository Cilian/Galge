package com.example.sren.galge;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static android.view.Window.FEATURE_NO_TITLE;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    Galgelogik spil = new Galgelogik();

    TextView word;
    ImageView fail,fail1,fail2,fail3,fail4,fail5,fail6;
    TableLayout buttons;
    TextView myScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        spil.nulstil();

        word = findViewById(R.id.word);
        word.setText(spil.getSynligtOrd());

        myScore = findViewById(R.id.point);

        buttons = findViewById(R.id.buttons);

        fail = findViewById(R.id.fail);
        fail1 = findViewById(R.id.fail1);
        fail2 = findViewById(R.id.fail2);
        fail3 = findViewById(R.id.fail3);
        fail4 = findViewById(R.id.fail4);
        fail5 = findViewById(R.id.fail5);
        fail6 = findViewById(R.id.fail6);
    }

    @Override
    public void onClick(View v) {
        String btnText = ((Button)v).getText().toString().toLowerCase();

        spil.logStatus();
        spil.gætBogstav(btnText);
        v.setVisibility(View.INVISIBLE);
        word.setText(spil.getSynligtOrd());
        System.out.println(btnText);
        updateImage();
        if(spil.erSpilletSlut()){
            end();
        }

    }
    public void end () {
        if(getWinner()){
            Bundle bundle = new Bundle();
            bundle.putString("score", String.valueOf(spil.getPoint()));
            bundle.putString("fejl", String.valueOf(spil.getAntalForkerteBogstaver()));
            Restart fragment = new Restart();
            fragment.setArguments(bundle);
            animationFragment(fragment);

    } else if(!getWinner()) {
            Bundle bundle = new Bundle();
            bundle.putString("ordet", String.valueOf(spil.getOrdet()));
            LoserFragment fragment = new LoserFragment();
            fragment.setArguments(bundle);
            animationFragment(fragment);

        }
    }

    public void updateImage(){

        myScore.setText("" + spil.getPoint());

        switch(spil.getAntalForkerteBogstaver()){
            case 1:
                fail.setImageResource(R.drawable.forkert1);
                break;
            case 2:
                fail.setImageResource(R.drawable.forkert2);
                break;
            case 3:
                fail.setImageResource(R.drawable.forkert3);
                break;
            case 4:
                fail.setImageResource(R.drawable.forkert4);
                break;
            case 5:
                fail.setImageResource(R.drawable.forkert5);
                break;
            case 6:
                fail.setImageResource(R.drawable.forkert6);
                break;
        }
    }


    //Used to determine winner or loser message in Restart fragment
    public Boolean getWinner(){
        return spil.erSpilletVundet();
    }


    public void animationFragment(Fragment frag){
        TranslateAnimation animation = new TranslateAnimation(0.0f, 0.0f, -800.0f, 0.0f); // new TranslateAnimation (float fromXDelta,float toXDelta, float fromYDelta, float toYDelta)

        animation.setDuration(1400); // animation duration, change accordingly
        animation.setRepeatCount(0); // animation repeat count
        animation.setFillAfter(false);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        fragmentTransaction.setCustomAnimations(R.anim.slide_down_in,R.anim.slide_up_out);
        fragmentTransaction.add(R.id.games_layout, frag);
        fragmentTransaction.commit();
        buttons.setVisibility(View.INVISIBLE);
    }


}
