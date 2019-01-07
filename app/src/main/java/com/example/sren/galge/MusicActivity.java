package com.example.sren.galge;

import android.app.Activity;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ToggleButton;

public class MusicActivity extends Activity implements View.OnClickListener {

    public MediaPlayer music = new MediaPlayer();
    ToggleButton music1, music2, music3, music4;
    ImageView playBtn, pauseBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

            music = MediaPlayer.create(this, R.raw.unlive);

            music1 = findViewById(R.id.music1);
            music1.setOnClickListener(this);
            music2 = findViewById(R.id.music2);
            music2.setOnClickListener(this);
            music3 = findViewById(R.id.music3);
            music3.setOnClickListener(this);
            music4 = findViewById(R.id.music4);
            music4.setOnClickListener(this);

            playBtn = findViewById(R.id.playBtn);
            playBtn.setOnClickListener(this);
            pauseBtn = findViewById(R.id.pauseBtn);
            pauseBtn.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if(v == music1 ){
            music.stop();
            playMusic(MediaPlayer.create(this, R.raw.unlive));
            music1.setChecked(true);
            music1.setTextColor(Color.parseColor("#ffffff"));
            musicIsPlaying();
        } else if (v == music2) {
            music.stop();
            playMusic(MediaPlayer.create(this, R.raw.celta_world));
            music2.setChecked(true);
            music2.setTextColor(Color.parseColor("#ffffff"));
            musicIsPlaying();
        } else if (v == music3) {
            music.stop();
            playMusic(MediaPlayer.create(this, R.raw.downhole));
            music3.setChecked(true);
            music3.setTextColor(Color.parseColor("#ffffff"));
            musicIsPlaying();
        } else if (v == music4){
            music.stop();
            playMusic(MediaPlayer.create(this, R.raw.the_organ));
            music4.setChecked(true);
            music4.setTextColor(Color.parseColor("#ffffff"));
            musicIsPlaying();
        } else if (v == playBtn){
            music.start();
            musicIsPlaying();
            System.out.println("Du trykkede på play");
        } else if (v == pauseBtn) {
            music.pause();
            pauseBtn.setVisibility(View.INVISIBLE);
            playBtn.setVisibility(View.VISIBLE);
            System.out.println("Du trykkede på Pause");
        }
    }

    public void musicIsPlaying(){
        playBtn.setVisibility(View.INVISIBLE);
        pauseBtn.setVisibility(View.VISIBLE);
    }

    public void playMusic(MediaPlayer music){
        this.music = music;
        ((Music) this.getApplication()).setMusic(music);
        music.setLooping(true);
        System.out.println(((Music) this.getApplication()).getMusic());
        music.start();
        music1.setChecked(false); music2.setChecked(false); music3.setChecked(false); music4.setChecked(false);
        music1.setTextColor(Color.parseColor("#5c5c5c"));
        music2.setTextColor(Color.parseColor("#5c5c5c"));
        music3.setTextColor(Color.parseColor("#5c5c5c"));
        music4.setTextColor(Color.parseColor("#5c5c5c"));
    }

    @Override
    public void onBackPressed() {
        if (getFragmentManager().getBackStackEntryCount() > 0) {
            music.stop();
            getFragmentManager().popBackStack();
        } else {
            super.onBackPressed();
            music.stop();
        }
    }

    @Override
    protected void onStop() {
        music.stop();
        super.onStop();
    }
}
