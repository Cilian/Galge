package com.example.sren.galge;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sren.galge.dummy.DummyContent.DummyItem;

import java.util.ArrayList;
import java.util.List;


public class MyListOfWordsRecyclerViewAdapter extends RecyclerView.Adapter<MyListOfWordsRecyclerViewAdapter.ViewHolder> {

    Galgelogik spil = new Galgelogik();
    private final ArrayList<String> mValues;
    Context mContext;
    ConstraintLayout itemHolder;
    TextView number,word;
    ArrayList<String> words = new ArrayList<String>();

    public MyListOfWordsRecyclerViewAdapter(Context mContext, ArrayList<String> items) {
        this.mContext = mContext;
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_listofwords, parent, false);

     //   number.findViewById(R.id.number);
        word = view.findViewById(R.id.word);
        itemHolder = view.findViewById(R.id.holder);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
      //  holder.number.setText("1");
        holder.word.setText(mValues.get(position));

        holder.itemHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Clicked on: " + mValues.get(position), Toast.LENGTH_SHORT).show();
          //      Intent intent = new Intent(mContext, request_mail.class);
          //      mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
    //    public TextView number;
        public TextView word;
        private ConstraintLayout itemHolder;
       // public DummyItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
         //   number = (TextView) view.findViewById(R.id.number);
            word = (TextView) view.findViewById(R.id.content);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + word.getText() + "'";
        }
    }
}
