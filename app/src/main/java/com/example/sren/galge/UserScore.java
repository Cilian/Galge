package com.example.sren.galge;

import android.graphics.drawable.Drawable;

public class UserScore {

    private Drawable medal;
    private String name;
    private int score;

    public UserScore(Drawable medal, String name, int score){
        this.medal = medal;
        this.name = name;
        this.score = score;
    }
    public Drawable getMedal() {
        return medal;
    }

    public void setMedal(Drawable medal) {
        this.medal = medal;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }







}
