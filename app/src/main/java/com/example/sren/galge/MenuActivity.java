package com.example.sren.galge;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.widget.Button;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;

import static android.view.Window.FEATURE_NO_TITLE;

public class MenuActivity extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    final FragmentManager fm = getFragmentManager();
    final PropFragment n = new PropFragment();

    btn = findViewById(R.id.options);
    btn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            n.show(fm,"Indstillinger");
        }
    });

    }
/*
   public void ChangeFrag(View view){
    Fragment fragment;

    if(view == findViewById(R.id.options)){
        fragment = new PropFragment();
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.prop, fragment);

    }

    }
*/


}
