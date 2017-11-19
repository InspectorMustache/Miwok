package com.example.android.miwok;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {
    private AdapterView.OnItemClickListener adapterViewClickListener;
    private MediaPlayer mPlayer;
    private MediaPlayer.OnCompletionListener mPlayerCompletionListener;

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("red", "weṭeṭṭi", R.drawable.color_red, R.raw.color_red));
        words.add(new Word("green", "chokokki", R.drawable.color_green, R.raw.color_green));
        words.add(new Word("brown", "ṭakaakki", R.drawable.color_brown, R.raw.color_brown));
        words.add(new Word("gray", "ṭopoppi", R.drawable.color_gray, R.raw.color_gray));
        words.add(new Word("black", "kululli", R.drawable.color_black, R.raw.color_black));
        words.add(new Word("white", "kelelli", R.drawable.color_white, R.raw.color_white));
        words.add(new Word("dusty yellow", "ṭopiisә", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        words.add(new Word("mustard yellow", "chiwiiṭә", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        mPlayer = null;
        mPlayerCompletionListener = new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                releaseMediaPlayer();
            }
        };

        adapterViewClickListener = new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                releaseMediaPlayer();
                mPlayer = MediaPlayer.create(parent.getContext(), words.get(position).getPronuciationId());
                mPlayer.start();
                mPlayer.setOnCompletionListener(mPlayerCompletionListener);
            }
        };

        ListView wordListView = (ListView) findViewById(R.id.list);
        WordAdapter wordAdapter = new WordAdapter(this, words, R.color.category_colors);
        wordListView.setAdapter(wordAdapter);
        wordListView.setOnItemClickListener(adapterViewClickListener);
    }

    private void releaseMediaPlayer() {
        if (this.mPlayer != null) {
            this.mPlayer.release();
            this.mPlayer = null;
        }
    }
}
