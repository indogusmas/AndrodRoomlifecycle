package com.indo.room.Adapter;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.indo.room.MainActivity;
import com.indo.room.R;
import com.indo.room.enity.Word;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.ViewHolder> {

    private LayoutInflater mInflater;
    private List<Word> mword;

    public WordListAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        if (mword != null){
            Word current = mword.get(position);
            holder.wordItemView.setText(current.getWord());
        }else {
            //Covers the case of  data being ready yet
            holder.wordItemView.setText("No World");
        }
    }
    public void setWord(List<Word> words){
        mword =words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mword != null)
            return mword.size();
        else return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView wordItemView;

        public ViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textview);
        }
    }
}
