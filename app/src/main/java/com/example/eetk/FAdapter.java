package com.example.eetk;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class FAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentArrayList = new ArrayList<>();
    private final ArrayList<String> fragmentTitle = new ArrayList<>();

    public FAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }


    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 0:
                fragment1 fragment1 = new fragment1();
                return fragment1;
            case 1:
                fragment2 fragment2 = new fragment2();
                return fragment2;
            case 2:
                fragment3 fragment3 = new fragment3();
                return fragment3;
            case 3:
                fragmentThursday fragmentThursday = new fragmentThursday();
                return fragmentThursday;
            case 4:
                fragmentFriday fragmentFriday = new fragmentFriday();
                return fragmentFriday;
            case 5:
                fragmentSaturday fragmentSaturday = new fragmentSaturday();
                return fragmentSaturday;

            default:
                return null;
        }

    }

    @Override
    public int getCount() {
        return 0;
    }

   /* @Override
    public int getCount() {
        return fragmentArrayList.size();
    }

    public void addFragment(Fragment fragment, String title){
        fragmentArrayList.add(fragment);
        fragmentTitle.add(title);
    }*/

    /*@Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return fragmentTitle.get(position);
    }*/
}
