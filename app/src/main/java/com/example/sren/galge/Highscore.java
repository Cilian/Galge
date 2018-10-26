package com.example.sren.galge;

import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class Highscore extends ListActivity {

    ListView scores;
    int myScore;
    int best1, best2, best3, best4, best5, best6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        scores = findViewById(android.R.id.list);

       // ArrayAdapter<Integer> scoreAdapter = new ArrayAdapter<String>(this, android.R.layout.activity_list_item, score);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("Highscores", 0); // 0 - for private mode
        SharedPreferences.Editor editor = pref.edit();

         //pref.edit().clear().commit();
        myScore = pref.getInt("currentScore",0);
        best1 = pref.getInt("best1",0);
        best2 = pref.getInt("best2",0);
        best3 = pref.getInt("best3",0);
        best4 = pref.getInt("best4",0);
        best5 = pref.getInt("best5",0);
        best6 = pref.getInt("best6",0);

        if(myScore > best1){
            best6 = best5;
            best5 = best4;
            best4 = best3;
            best3 = best2;
            best2 = best1;
            editor.putInt("best1",myScore);
            editor.putInt("best2",best2);
            editor.putInt("best3",best3);
            editor.putInt("best4",best4);
            editor.putInt("best5",best5);
            editor.putInt("best6",best6);
            editor.commit();
        } else if(myScore > best2){
            best6 = best5;
            best5 = best4;
            best4 = best3;
            best3 = best2;
            editor.putInt("best2",myScore);
            editor.putInt("best3",best3);
            editor.putInt("best4",best4);
            editor.putInt("best5",best5);
            editor.putInt("best6",best6);
            editor.commit();
        } else if(myScore > best3){
            best6 = best5;
            best5 = best4;
            best4 = best3;
            editor.putInt("best3",myScore);
            editor.putInt("best4",best4);
            editor.putInt("best5",best5);
            editor.putInt("best6",best6);
            editor.commit();
        } else if(myScore > best4){
            best6 = best5;
            best5 = best4;
            editor.putInt("best4",myScore);
            editor.putInt("best5",best5);
            editor.putInt("best6",best6);
            editor.commit();
        } else if(myScore > best5){
            best6 = best5;
            editor.putInt("best5",myScore);
            editor.putInt("best6",best6);
            editor.commit();
        } else if(myScore > best6){
            editor.putInt("best6",myScore);
            editor.commit();
        }


        Integer[] scores = {best1, best2, best3, best4, best5, best6};
        ArrayAdapter<Integer> adapter = new ArrayAdapter<Integer>(getListView().getContext(), android.R.layout.simple_list_item_1, scores) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                TextView tv = (TextView) view.findViewById(android.R.id.text1);
                tv.setTextColor(Color.GRAY);
                tv.setGravity(Gravity.CENTER_HORIZONTAL);

                return view;
            }
        };

        getListView().setAdapter(adapter);

    }

}
