package com.example.sren.galge;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

/**
 * @author Jacob Nordfalk
 */
public class Hovedmenu_akt extends AppCompatActivity implements OnClickListener {
  // Vi erklærer variabler herude så de huskes fra metode til metode
  Button hjaelpKnap, indstillingerKnap, spilKnap;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    setContentView(R.layout.activity_menu);

    hjaelpKnap = findViewById(R.id.help);
    hjaelpKnap.setText("Hjælp");

    indstillingerKnap = findViewById(R.id.options);
    indstillingerKnap.setText("Indstillinger");

    spilKnap = findViewById(R.id.start);
    spilKnap.setText("Spil");

    hjaelpKnap.setOnClickListener(this);
    indstillingerKnap.setOnClickListener(this);
    spilKnap.setOnClickListener(this);
  }

  public void onClick(View v) {
    System.out.println("Der blev trykket på en knap");
    if (v == hjaelpKnap) {

      Intent i = new Intent(this, Hjaelp_akt.class);
      startActivity(i);

    } else if (v == indstillingerKnap) {

      Intent i = new Intent(this, Indstillinger_akt.class);
      startActivity(i);

    } else if (v == spilKnap) {

      Intent i = new Intent(this, Spillet_akt.class);
      i.putExtra("velkomst", "\n\nHalløj fra Hovedmenu_akt!\n");
      startActivity(i);

    }
  }
}
