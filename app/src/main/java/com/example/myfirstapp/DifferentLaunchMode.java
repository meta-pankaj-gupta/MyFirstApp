package com.example.myfirstapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;


public class DifferentLaunchMode extends AppCompatActivity implements IFragmentToActivity, SendMessage{
    private final String LOG_TAG = "Fragment Activity";
    private PagerAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(LOG_TAG, "onCreat3 Method");
        setContentView(R.layout.activity_different_launch_mode);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i(LOG_TAG, "set Toolbar method");
        ArrayList<String> tabs = new ArrayList<>();
        tabs.add("First FR");
        tabs.add("Second FR");
        tabLayout = (TabLayout) findViewById(R.id.tab_layout);
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final ViewPager viewPager = (ViewPager) findViewById(R.id.pager);
        adapter = new PagerAdapter(getSupportFragmentManager(), tabs);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_refresh) {
            int position = tabLayout.getSelectedTabPosition();
            Fragment fragment = adapter.getFragment(tabLayout
                    .getSelectedTabPosition());
            if (fragment != null) {
                switch (position) {
                    case 0:
                        ((FragmentA) fragment).onRefresh();
                        break;
                    case 1:
                        ((FragmentB) fragment).onRefresh();
                        break;
                }
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showToast(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Override
    public void communicateToFragment2() {
        FragmentB fragment = (FragmentB) adapter.getFragment(1);
        if (fragment != null) {
            fragment.fragmentCommunication();
        } else {
            Log.i(LOG_TAG, "Fragment 2 is not initialized");
        }
    }

    @Override
    public void sendData(String message) {
        FragmentB fragment = (FragmentB) adapter.getFragment(1);
        if (fragment != null) {
            fragment.displayReceivedData(message);
        }else {
            Log.i(LOG_TAG, "Fragment 2 is not initialized");
        }
    }
}