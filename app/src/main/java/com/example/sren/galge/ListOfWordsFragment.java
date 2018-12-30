package com.example.sren.galge;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


public class ListOfWordsFragment extends Activity {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    ArrayList<Words> words = new ArrayList<Words>();
    ListView list;
    MenuActivity menu = new MenuActivity();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_listofwords_list);

        list = findViewById(R.id.list);

        words.add(new Words("bil"));
        words.add(new Words("computer"));
        words.add(new Words("programmering"));
        words.add(new Words("motorvej"));
        words.add(new Words("busrute"));
        words.add(new Words("gangsti"));
        words.add(new Words("skovsnegl"));
        words.add(new Words("solsort"));
        words.add(new Words("seksten"));
        words.add(new Words("sytten"));
        words.add(new Words("atten"));

        //RecyclerView recyclerView = (RecyclerView) ;
        list.setAdapter(new MyListOfWordsRecyclerViewAdapter(this,R.layout.fragment_listofwords, words));
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                System.out.println(words.get(position).getWords());

                Intent intent = new Intent(getBaseContext(), GameActivity.class);
                intent.putExtra("word", words.get(position).getWords());

                startActivity(intent);
            }
        });

    }
}
