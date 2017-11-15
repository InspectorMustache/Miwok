package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {

    WordAdapter(Activity context, List<Word> wordList) {
        super(context, 0, wordList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        Word currentWord = this.getItem(position);
        TextView defaultTranslationView = (TextView) convertView.findViewById(R.id.default_trans);
        defaultTranslationView.setText(currentWord.getdefaultTranslation());

        TextView miwokTranslationView = (TextView) convertView.findViewById(R.id.miwok_trans);
        miwokTranslationView.setText(currentWord.getMiwokTranslation());

        return convertView;
    }
}
