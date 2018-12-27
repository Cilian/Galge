package com.example.sren.galge;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
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

    Button option, start, highscore;
    TextView galge1,galge2,leg1,leg2, preparing, wait;
    ProgressBar progressBar;

    TextView txt;
    Integer count =1;

     ScaleAnimation growAnim = new ScaleAnimation(1.0f, 1.08f, 1.0f, 1.08f, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);
     ScaleAnimation shrinkAnim = new ScaleAnimation(1.08f, 1.0f, 1.08f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5F, Animation.RELATIVE_TO_SELF, 0.5F);



@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        final FragmentManager fm = getFragmentManager();
        final PropFragment n = new PropFragment();

        progressBar = findViewById(R.id.progressBar);

        preparing = findViewById(R.id.preparing);
        wait = findViewById(R.id.wait);

        start = findViewById(R.id.start);
        start.setOnClickListener(this);

        option = findViewById(R.id.options);
        option.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v){
            n.show(fm,"Indstillinger");
        }
    });

        highscore = findViewById(R.id.highscore);
        highscore.setOnClickListener(this);

        galge1 = findViewById(R.id.galge1);
        galge2 = findViewById(R.id.galge2);
        leg1 = findViewById(R.id.leg1);
        leg2 = findViewById(R.id.leg2);


    growAnim.setDuration(1500);
    shrinkAnim.setDuration(1500);

   // Animation grow = AnimationUtils.loadAnimation(this, R.anim.scale);

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
            openLoading();
        }
        if(v == highscore){
            openScores();
        }
}

        public void openScores(){
            Intent intent = new Intent(this,Highscore.class);
            startActivity(intent);
        }

        public void openLoading(){
            option.setVisibility(View.INVISIBLE);
            highscore.setVisibility(View.INVISIBLE);
            start.setVisibility(View.INVISIBLE);

            wait.setVisibility(View.VISIBLE);
            preparing.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            new MyTask().execute(70);

        }

    class MyTask extends AsyncTask<Integer, Integer, String> {
        @Override
        protected String doInBackground(Integer... params) {
            for (; count <= params[0]; count++) {
                try {
                    Thread.sleep(20);
                    publishProgress(count);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return "Task Completed.";
        }
        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.GONE);
        }
        @Override
        protected void onPreExecute() {
        }
        @Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }
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
