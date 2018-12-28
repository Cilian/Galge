package com.example.sren.galge;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sren.galge.dummy.DummyContent;
import com.example.sren.galge.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;


public class ListOfWordsFragment extends Activity {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    private RecyclerView recycler;
    ArrayList<String> words = new ArrayList<String>();


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_listofwords_list);

        RecyclerView list = findViewById(R.id.list);

        words.add("bil");
        words.add("computer");
        words.add("programmering");
        words.add("motorvej");
        words.add("busrute");
        words.add("gangsti");
        words.add("skovsnegl");
        words.add("solsort");
        words.add("seksten");
        words.add("sytten");
        words.add("atten");

        //RecyclerView recyclerView = (RecyclerView) ;
        list.setAdapter(new MyListOfWordsRecyclerViewAdapter(this, words));
    }
}
