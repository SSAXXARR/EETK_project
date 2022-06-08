package com.example.eetk;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.Toast;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.tabs.TabLayout;

public class Schedule extends AppCompatActivity implements SwipeRefreshLayout.OnRefreshListener{

    private TabLayout tabLayout;
    String classID, tabID; Bundle b;
    private SectionsPagerAdapter mSectionsPagerAdapter;
    SwipeRefreshLayout mSwipeRefreshLayout
;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maket1);
        mSwipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.refresh);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        // делаем повеселее
        mSwipeRefreshLayout.setColorScheme(R.color.red,R.color.blue, R.color.green);

        Bundle bundle = getIntent().getExtras();
        classID = bundle.getString("classID");

        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.viewPager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);

        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));
        tabLayout.addOnTabSelectedListener(new TabLayout.ViewPagerOnTabSelectedListener(mViewPager));


    }

    @Override
    public void onRefresh() {
        // начинаем показывать прогресс
        mSwipeRefreshLayout.setRefreshing(true);
        // ждем 3 секунды и прячем прогресс
        mSwipeRefreshLayout.postDelayed(new Runnable() {
            @Override
            public void run() {
                mSwipeRefreshLayout.setRefreshing(false);
            }
        }, 3000);
    }


    /*@Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/

    /**
     * A placeholder fragment containing a simple view.
     */


    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            // return PlaceholderFragment.newInstance(position + 1);
            //открывает по позиции дня недели.
            switch (position){
                case 0:
                    fragment1 bf1= new fragment1();
                    return bf1;
                case 1:
                    fragment2 bf2= new fragment2();
                    return bf2;
                case 2:
                    fragment3 bf3= new fragment3();
                    return bf3;
                case 3:
                    fragmentThursday bf4= new fragmentThursday();
                    return bf4;
                case 4:
                    fragmentFriday bf5= new fragmentFriday();
                    return bf5;
                case 5:
                    fragmentSaturday bf6 = new fragmentSaturday();
                    return bf6;

                default:
                    return null;
            }

        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 6;
        }
    }
}