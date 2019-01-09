package com.example.sren.galge;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.view.Window.FEATURE_NO_TITLE;

public class MenuActivity extends Activity implements View.OnClickListener{

    Button music, start, highscore,custom;
    TextView galge1,galge2,leg1,leg2;



     ScaleAnimation growAnim = new ScaleAnimation(1.0f, 1.08f, 1.0f, 1.08f, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
     ScaleAnimation shrinkAnim = new ScaleAnimation(1.08f, 1.0f, 1.08f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);

@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        start = findViewById(R.id.start);
        start.setOnClickListener(this);

        music = findViewById(R.id.options);
        music.setOnClickListener(this);


        highscore = findViewById(R.id.highscore);
        highscore.setOnClickListener(this);

        custom = findViewById(R.id.custom);
        custom.setOnClickListener(this);

        galge1 = findViewById(R.id.galge1);
        galge2 = findViewById(R.id.galge2);
        leg1 = findViewById(R.id.leg1);
        leg2 = findViewById(R.id.leg2);

    growAnim.setDuration(1500);
    shrinkAnim.setDuration(1500);

    galge1.setAnimation(growAnim);
    galge2.setAnimation(growAnim);
    leg1.setAnimation(growAnim);
    leg2.setAnimation(growAnim);
    growAnim.start();

    growAnim.setAnimationListener(new Animation.AnimationListener()
    {
        @Override
        public void onAnimationStart(Animation animation){}

        @Override
        public void onAnimationRepeat(Animation animation){}

        @Override
        public void onAnimationEnd(Animation animation)
        {
            galge1.setAnimation(shrinkAnim);
            galge2.setAnimation(shrinkAnim);
            leg1.setAnimation(shrinkAnim);
            leg2.setAnimation(shrinkAnim);
            shrinkAnim.start();
        }
    });
    shrinkAnim.setAnimationListener(new Animation.AnimationListener()
    {
        @Override
        public void onAnimationStart(Animation animation){}

        @Override
        public void onAnimationRepeat(Animation animation){}

        @Override
        public void onAnimationEnd(Animation animation)
        {
            galge1.setAnimation(growAnim);
            galge2.setAnimation(growAnim);
            leg1.setAnimation(growAnim);
            leg2.setAnimation(growAnim);
            growAnim.start();
        }
    });
}

@Override
public void onClick(View v){
        if(v==start){
            openGame();
        }
        if(v == highscore){
            openScores();
        }
        if(v == custom){
            openCustom();
        }
        if(v == music){
            openMusic();
        }
}

    public void openMusic() {
        Intent intent = new Intent(this, MusicActivity.class);
        startActivity(intent);
    }

        public void openCustom() {
            Intent intent = new Intent(this, ListOfWords.class);
            startActivity(intent);
        }

        public void openScores(){
            Intent intent = new Intent(this,Highscore.class);
            startActivity(intent);
        }

    public void openGame(){
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);
      //  finish();
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();

        } else {
            super.onBackPressed();
        }
    }
}
