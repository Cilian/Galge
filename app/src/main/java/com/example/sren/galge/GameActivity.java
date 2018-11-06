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
    Button B,T,K,A,E,V,J,U,F,H,I,S,Re,L,O,N,M,Y,P,G,D,C;
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

        B = findViewById(R.id.B);
        B.setOnClickListener(this);
        T = findViewById(R.id.T);
        T.setOnClickListener(this);
        K = findViewById(R.id.K);
        K.setOnClickListener(this);
        A = findViewById(R.id.A);
        A.setOnClickListener(this);
        E = findViewById(R.id.E);
        E.setOnClickListener(this);
        V = findViewById(R.id.V);
        V.setOnClickListener(this);
        J = findViewById(R.id.J);
        J.setOnClickListener(this);
        U = findViewById(R.id.U);
        U.setOnClickListener(this);
        F = findViewById(R.id.F);
        F.setOnClickListener(this);
        H = findViewById(R.id.H);
        H.setOnClickListener(this);
        I = findViewById(R.id.I);
        I.setOnClickListener(this);
        S = findViewById(R.id.S);
        S.setOnClickListener(this);
        Re = findViewById(R.id.Re);
        Re.setOnClickListener(this);
        L = findViewById(R.id.L);
        L.setOnClickListener(this);
        O = findViewById(R.id.O);
        O.setOnClickListener(this);
        N = findViewById(R.id.N);
        N.setOnClickListener(this);
        M = findViewById(R.id.M);
        M.setOnClickListener(this);
        Y = findViewById(R.id.Y);
        Y.setOnClickListener(this);
        P = findViewById(R.id.P);
        P.setOnClickListener(this);
        G = findViewById(R.id.G);
        G.setOnClickListener(this);
        D = findViewById(R.id.D);
        D.setOnClickListener(this);
        C = findViewById(R.id.C);
        C.setOnClickListener(this);

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
        if (v == B) {
            spil.gætBogstav("b");
            B.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == T) {
            spil.gætBogstav("t");
            T.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == K) {
            spil.gætBogstav("k");
            K.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == A) {
            spil.gætBogstav("a");
            A.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == E) {
            spil.gætBogstav("e");
            E.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == V) {
            spil.gætBogstav("v");
            V.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == J) {
            spil.gætBogstav("j");
            J.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == U) {
            spil.gætBogstav("u");
            U.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == F) {
            spil.gætBogstav("f");
            F.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == H) {
            spil.gætBogstav("h");
            H.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == I) {
            spil.gætBogstav("i");
            I.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == S) {
            spil.gætBogstav("s");
            S.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == Re) {
            spil.gætBogstav("r");
            Re.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == L) {
            spil.gætBogstav("l");
            L.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == O) {
            spil.gætBogstav("o");
            O.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == N) {
            spil.gætBogstav("n");
            N.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == M) {
            spil.gætBogstav("m");
            M.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == Y) {
            spil.gætBogstav("y");
            Y.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == P) {
            spil.gætBogstav("p");
            P.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == G) {
            spil.gætBogstav("g");
            G.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        } else if (v == D) {
            spil.gætBogstav("d");
            D.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()){ { end();}}
        } else if (v == C) {
            spil.gætBogstav("c");
            C.setVisibility(View.INVISIBLE);
            updateUI();
            if (spil.erSpilletSlut()) { end();}
        }

    }
    public void end () {
        if(getWinner()){
        Restart fragment = new Restart();
        animationFragment(fragment);
    } else if(!getWinner()) {
        LoserFragment fragment = new LoserFragment();
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

    public void updateUI(){
        spil.logStatus();
        word.setText(spil.getSynligtOrd());
        updateImage();
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
