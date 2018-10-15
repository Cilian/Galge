package com.example.sren.galge;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import static android.view.Window.FEATURE_NO_TITLE;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {

    Galgelogik spil = new Galgelogik();
    TextView word;
    Button B,T,K,A,E,V,J,U,F,H,I,S,Re,L,O,N,M,Y,P,G,D,C;
    ImageView fail,fail1,fail2,fail3,fail4,fail5,fail6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(FEATURE_NO_TITLE);
        setContentView(R.layout.activity_game);


        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        spil.nulstil();

        word = findViewById(R.id.word);
        word.setText(spil.getSynligtOrd());

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
        if(v == B){
            spil.gætBogstav("b");
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        } else if(v == T){
            spil.gætBogstav("t");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == K){
            spil.gætBogstav("k");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == A){
            spil.gætBogstav("a");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == E){
            spil.gætBogstav("e");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == V){
            spil.gætBogstav("v");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == J){
            spil.gætBogstav("j");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == U){
            spil.gætBogstav("u");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == F){
            spil.gætBogstav("f");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == H){
            spil.gætBogstav("h");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == I){
            spil.gætBogstav("i");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == S){
            spil.gætBogstav("s");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == Re){
            spil.gætBogstav("r");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == L){
            spil.gætBogstav("l");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }else if(v == O){
            spil.gætBogstav("o");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        } else if(v == N){
            spil.gætBogstav("n");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        } else if(v == M){
            spil.gætBogstav("m");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        } else if(v == Y){
            spil.gætBogstav("y");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        } else if(v == P){
            spil.gætBogstav("p");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        } else if(v == G){
            spil.gætBogstav("g");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        } else if(v == D){
            spil.gætBogstav("d");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        } else if(v == C){
            spil.gætBogstav("c");
            spil.logStatus();
            word.setText(spil.getSynligtOrd());
            B.setVisibility(View.INVISIBLE);
            updateFail();
            if (spil.erSpilletSlut()) return;
        }

    }
    public void updateFail(){
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

}
