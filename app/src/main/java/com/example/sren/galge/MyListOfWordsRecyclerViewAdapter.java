package com.example.sren.galge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sren.galge.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;


public class MyListOfWordsRecyclerViewAdapter extends ArrayAdapter<Words> {


    private Context mcontext;
    int mResource;

    public MyListOfWordsRecyclerViewAdapter(Context context, int resource, ArrayList<Words> objects) {
        super(context, resource, objects);
        mcontext = context;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        String word = getItem(position).getWords();
       // Words wrd = new Words(word);

        LayoutInflater inflater = LayoutInflater.from(mcontext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvId = (TextView) convertView.findViewById(R.id.word);

        tvId.setText(word);

        return convertView;
    }
}
