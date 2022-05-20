package com.example.eetk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TableLayout;

import com.google.android.material.tabs.TabLayout;

public class Admin_menu extends AppCompatActivity {

    private TabLayout tableLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maket1);

        tableLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        tableLayout.setupWithViewPager(viewPager);

        FAdapter fAdapter = new FAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        fAdapter.addFragment(new fragment1(), "ПН");
        fAdapter.addFragment(new fragment2(), "ВТ");
        fAdapter.addFragment(new fragment3(), "СР");
        fAdapter.addFragment(new fragmentThursday(), "ЧТ");
        fAdapter.addFragment(new fragmentFriday(), "ПТ");
        fAdapter.addFragment(new fragmentSaturday(), "СБ");
        viewPager.setAdapter(fAdapter);
    }
}