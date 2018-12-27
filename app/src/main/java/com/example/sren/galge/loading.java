package com.example.sren.galge;

import android.os.AsyncTask;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

public class loading extends AppCompatActivity {

    ProgressBar progressBar;
    static loading synligAktivitet;
    static AsyncTaskUdskifteligAktivitet asyncTask;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);

        progressBar = findViewById(R.id.progressBar);

        asyncTask = new AsyncTaskUdskifteligAktivitet();
        asyncTask.execute(500, 50);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    static class AsyncTaskUdskifteligAktivitet extends AsyncTask<Integer, Double, String> {
        @Override
        protected String doInBackground(Integer... param) {
            int antalSkridt = param[0];
            int ventetidPrSkridtIMilisekunder = param[1];
            for (int i = 0; i < antalSkridt; i++) {
                SystemClock.sleep(ventetidPrSkridtIMilisekunder);
                if (isCancelled()) {
                    return null; // stop uden resultat
                }
                double procent = i * 100.0 / antalSkridt;
                double resttidISekunder = (antalSkridt - i) * ventetidPrSkridtIMilisekunder / 100 / 10.0;
                publishProgress(procent, resttidISekunder); // sendes som parameter til onProgressUpdate()
            }
            return "færdig med doInBackground()!"; // resultat (String) sendes til onPostExecute()
        }

    @Override
    protected void onProgressUpdate(Double... progress) {
        if (synligAktivitet == null) return;
        double procent = progress[0];
        double resttidISekunder = progress[1];
        String tekst = "arbejder - " + procent + "% færdig, mangler " + resttidISekunder + " sekunder endnu";
        Log.d("AsyncTask", tekst);
        synligAktivitet.progressBar.setProgress((int) procent);
    }
        @Override
        protected void onPostExecute(String resultat) {
            if (synligAktivitet == null) return;
            asyncTask = null;
        }

        @Override
        protected void onCancelled() {
            if (synligAktivitet == null) return;
            asyncTask = null;
        }
    }

}