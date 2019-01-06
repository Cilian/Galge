package com.example.sren.galge;

import android.app.Activity;
import android.app.DialogFragment;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.widget.Button;


public class PropFragment extends DialogFragment implements OnClickListener {

    Button btn, music,music1,music2,music3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View rootView=inflater.inflate(R.layout.properties,container,false);

        music = rootView.findViewById(R.id.music);
        music.setOnClickListener(this);
        music1 = rootView.findViewById(R.id.music1);
        music1.setOnClickListener(this);
        music2 = rootView.findViewById(R.id.music2);
        music2.setOnClickListener(this);
        music3 = rootView.findViewById(R.id.music3);
        music3.setOnClickListener(this);

        btn = rootView.findViewById(R.id.dismiss);
        btn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        return rootView;
    }

    @Override
    public void onClick(View v) {
    /*    if(v == music){
            ((MenuActivity)getActivity()).music.stop();
            ((MenuActivity)getActivity()).setMusic(MediaPlayer.create(getActivity(), R.raw.unlive));
        }
        else if(v == music1){
            ((MenuActivity)getActivity()).music.stop();
            ((MenuActivity)getActivity()).setMusic(MediaPlayer.create(getActivity(), R.raw.celta_world));
        }
        else if(v == music2){
            ((MenuActivity)getActivity()).music.stop();
           ((MenuActivity)getActivity()).setMusic(MediaPlayer.create(getActivity(), R.raw.downhole));
        }
        else if(v == music3){
            ((MenuActivity)getActivity()).music.stop();
           ((MenuActivity)getActivity()).setMusic(MediaPlayer.create(getActivity(), R.raw.the_organ));
        }*/
    }
}
