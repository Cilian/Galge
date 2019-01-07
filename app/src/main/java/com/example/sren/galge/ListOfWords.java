package com.example.sren.galge;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;


public class ListOfWords extends Activity implements View.OnClickListener {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    ArrayList<Words> words = new ArrayList<Words>();
    ListView list;
    Button dr;
    Galgelogik logik = new Galgelogik();

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

        dr = findViewById(R.id.dr);
        dr.setOnClickListener(this);

        list.setAdapter(new MyListOfWordsRecyclerViewAdapter(this, R.layout.fragment_listofwords, words));
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


    @Override
    public void onClick(View v) {
        if (v == dr) {
            System.out.println("Du trykkede på dr");
            new CallDr();
        }
    }
        class CallDr extends AsyncTask<URL, Void, String> {
            @Override
            protected String doInBackground(URL... url) {
                try {
                    Intent intent = new Intent(getBaseContext(), GameActivity.class);
                    startActivity(intent);
                    // logik.hentOrdFraDr();

                } catch (Exception e1) {
                    e1.printStackTrace();
                }
                return "Task Completed.";
            }

            protected void onPostExecute(String result) {
                return ;
            }

/*            try {
                logik.hentOrdFraDr();
                Intent intent = new Intent(getBaseContext(),GameActivity.class);
                startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                Intent intent = new Intent(getBaseContext(), MenuActivity.class);
                startActivity(intent);
            }*/

    }
}
