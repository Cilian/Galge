package com.example.sren.galge;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;


public class PropFragment extends DialogFragment {

    Button btn;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.properties,container,false);

        //getDialog().setTitle("Indstillinger");

        btn = rootView.findViewById(R.id.dismiss);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();
            }
        });

        return rootView;
    }

}
