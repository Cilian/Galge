package com.example.sren.galge;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import static android.view.Window.FEATURE_NO_TITLE;

public class MenuActivity extends Activity implements View.OnClickListener{

    Button option;
    Button start;

@Override
protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(FEATURE_NO_TITLE);
        setContentView(R.layout.activity_menu);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        final FragmentManager fm = getFragmentManager();
        final PropFragment n = new PropFragment();

        start=findViewById(R.id.start);
        start.setOnClickListener(this);

        option=findViewById(R.id.options);
        option.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                n.show(fm,"Indstillinger");
            }
        });
}

@Override
public void onClick(View v){
        if(v==start){
        start.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View v){
        openGame();
        }
        });
        }
        }


        public void openGame(){
        Intent intent = new Intent(this,GameActivity.class);
        startActivity(intent);

        }

/*
publicvoidChangeFrag(Viewview){
Fragmentfragment;

if(view==findViewById(R.id.options)){
fragment=newPropFragment();
FragmentManagerfm=getFragmentManager();
FragmentTransactionft=fm.beginTransaction();
ft.replace(R.id.prop,fragment);

}

}
*/


        }
