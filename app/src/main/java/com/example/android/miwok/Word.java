package com.example.android.miwok;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.provider.MediaStore;

/**
 * {@link Word} represents a dictionary entry consisting of the default
 * translation and the miwok translation
 */
public class Word {
    private String defaultTranslation;
    private String miwokTranslation;
    private int imageResourceId;
    private int pronuciationId;
    private static final int NO_RESOURCE_PROVIDED = -1;

    public Word(String defaultTranslation, String miwokTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceId = NO_RESOURCE_PROVIDED;
        this.pronuciationId = NO_RESOURCE_PROVIDED;
    }

    public Word(String defaultTranslation, String miwokTranslation, int imageResourceId, int pronuciationId) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceId = imageResourceId;
        this.pronuciationId = pronuciationId;
    }

    public Word(String defaultTranslation, String miwokTranslation,  int pronuciationId) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
        this.imageResourceId = NO_RESOURCE_PROVIDED;
        this.pronuciationId = pronuciationId;
    }


    public String getdefaultTranslation() {
        return defaultTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }

    public int getPronuciationId() {
        return pronuciationId;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

    /**
     * blabla obvious right
     * @return
     */
    public boolean hasImage() {
        return imageResourceId != NO_RESOURCE_PROVIDED;
    }
}
