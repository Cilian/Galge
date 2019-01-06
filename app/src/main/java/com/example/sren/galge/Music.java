package com.example.sren.galge;

import android.app.Application;
import android.media.MediaPlayer;
import android.provider.MediaStore;

public class Music extends Application {
    private MediaPlayer music;

   public void setMusic(MediaPlayer music){
       this.music = music;
   }

   public MediaPlayer getMusic(){
       return music;
   }
}
