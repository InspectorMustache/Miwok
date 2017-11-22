package com.example.android.miwok;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CategoryPagerAdapter extends FragmentStatePagerAdapter {
    private final int TOTAL_PAGES = 4;

    public CategoryPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() {
        return TOTAL_PAGES;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence returnTitle = null;
        switch (position) {
            case 0:
                returnTitle = "Numbers";
                break;
            case 1:
                returnTitle = "Family";
                break;
            case 2:
                returnTitle = "Colors";
                break;
            case 3:
                returnTitle = "Phrases";
                break;
        }
        return returnTitle;
    }

    @Override
    public Fragment getItem(int position) {
        Fragment returnFragment = null;
        switch (position) {
            case 0:
                returnFragment = new NumbersFragment();
                break;
            case 1:
                returnFragment = new FamilyFragment();
                break;
            case 2:
                returnFragment = new ColorsFragment();
            break;
            case 3:
                returnFragment = new PhrasesFragment();
            break;
        }
        return returnFragment;
    }
}
