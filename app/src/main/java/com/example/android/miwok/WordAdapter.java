package com.example.android.miwok;

import android.app.Activity;
import android.content.Context;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class WordAdapter extends ArrayAdapter<Word> {
    int bgColor;

    WordAdapter(Activity context, List<Word> wordList, int bgColor) {
        super(context, 0, wordList);
        this.bgColor = bgColor;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false
            );
        }

        LinearLayout textContainer = (LinearLayout) convertView.findViewById(R.id.text_container);
        textContainer.setBackgroundColor(ContextCompat.getColor(getContext(), this.bgColor));

        final Word currentWord = this.getItem(position);

        TextView defaultTranslationView = (TextView) convertView.findViewById(R.id.default_trans);
        defaultTranslationView.setText(currentWord.getdefaultTranslation());

        TextView miwokTranslationView = (TextView) convertView.findViewById(R.id.miwok_trans);
        miwokTranslationView.setText(currentWord.getMiwokTranslation());

        ImageView wordIcon = (ImageView) convertView.findViewById(R.id.image);
        if (currentWord.hasImage()) {
            wordIcon.setImageResource(currentWord.getImageResourceId());
        } else {
            wordIcon.setVisibility(View.GONE);
        }

        return convertView;
    }
}
