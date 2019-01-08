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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ListOfWords extends Activity implements View.OnClickListener {

    private static final String ARG_COLUMN_COUNT = "column-count";
    private int mColumnCount = 1;
    ArrayList<Words> words = new ArrayList<Words>();
    ListView list;
    Button dr;
    Galgelogik logik = new Galgelogik();
    String chosenWord;
    int count;
    ProgressBar progressBar;
    TextView preparing, wait,txt;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_listofwords_list);

        list = findViewById(R.id.list);
        progressBar = findViewById(R.id.progressBar);
        preparing = findViewById(R.id.preparing);
        wait = findViewById(R.id.wait);
        txt = findViewById(R.id.txt);

        dr = findViewById(R.id.dr);
        dr.setOnClickListener(this);

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
            dr.setVisibility(View.GONE);
            list.setVisibility(View.GONE);
            txt.setVisibility(View.GONE);

            wait.setVisibility(View.VISIBLE);
            preparing.setVisibility(View.VISIBLE);
            progressBar.setVisibility(View.VISIBLE);
            new wordsFromDR().execute(25);
        }
    }

    private class wordsFromDR extends AsyncTask<Integer, Integer, String> {
        @Override
        protected String doInBackground(Integer... params) {
                try {
                    logik.hentOrdFraDr();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            for (; count <= params[0]; count++) {
                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                publishProgress(count);
            }
            return "Task Completed.";
        }

        @Override
        protected void onPreExecute() {
        }

        @Override
        protected void onPostExecute(String result) {
            progressBar.setVisibility(View.GONE);
            chosenWord = logik.muligeOrd.get(new Random().nextInt(logik.muligeOrd.size()));
            Intent intent = new Intent(getBaseContext(), GameActivity.class);
            intent.putExtra("word", chosenWord);
            startActivity(intent);
        }
            @Override
            protected void onProgressUpdate(Integer... values) {
                progressBar.setProgress(values[0]);
            }
    }

}
