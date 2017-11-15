package com.example.android.miwok;

/**
 * {@link Word} represents a dictionary entry consisting of the default
 * translation and the miwok translation
 */
public class Word {
    private String defaultTranslation;
    private String miwokTranslation;

    Word(String defaultTranslation, String miwokTranslation) {
        this.defaultTranslation = defaultTranslation;
        this.miwokTranslation = miwokTranslation;
    }

    public String getdefaultTranslation() {
        return defaultTranslation;
    }

    public String getMiwokTranslation() {
        return miwokTranslation;
    }
}
