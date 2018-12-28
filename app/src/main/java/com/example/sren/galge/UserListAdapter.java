package com.example.sren.galge;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends ArrayAdapter<UserScore> {


    private Context mcontext;
    int mResource;

    public UserListAdapter(Context context, int resource, ArrayList<UserScore> objects) {
        super(context, resource, objects);
        mcontext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        Drawable medal = getItem(position).getMedal();
        String name = getItem(position).getName();
        int score = getItem(position).getScore();

        UserScore user = new UserScore(medal, name,score);

        LayoutInflater inflater = LayoutInflater.from(mcontext);
        convertView = inflater.inflate(mResource, parent, false);

        ImageView tvMedal = convertView.findViewById(R.id.first);
        TextView tvName = (TextView) convertView.findViewById(R.id.second);
        TextView tvScore = (TextView) convertView.findViewById(R.id.third);

        tvMedal.setImageDrawable(medal);
        tvName.setText(name);
        tvScore.setText("" +score);

        return convertView;
    }
}
