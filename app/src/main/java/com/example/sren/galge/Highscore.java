package com.example.sren.galge;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.w3c.dom.Text;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Highscore extends Activity {

    UserScore user;
    ListView scores;
    ArrayList<UserScore>  users;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscore);

        scores = (ListView) findViewById(R.id.list);

        loadUser();
        Collections.sort(users, new Comparator<UserScore>() {
            @Override
            public int compare(UserScore o1, UserScore o2) {
                return Integer.valueOf(o2.getScore()).compareTo(o1.getScore());
            }
        });


        UserListAdapter adapter = new UserListAdapter(this, R.layout.listelements, users);
        scores.setAdapter(adapter);
    }


    public void loadUser(){
        SharedPreferences sharedPreferences = getSharedPreferences("highscore", MODE_PRIVATE);
        Gson gson = new Gson();
        String json = sharedPreferences.getString("list",null);
        Type type = new TypeToken<ArrayList<UserScore>>() {}.getType();
        users = gson.fromJson(json,type);

    }

}
