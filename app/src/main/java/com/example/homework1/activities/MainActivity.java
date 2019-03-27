package com.example.homework1.activities;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.homework1.R;
import com.example.homework1.fragments.FocusFragment;
import com.example.homework1.fragments.MyListFragment;

public class MainActivity extends AppCompatActivity implements OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showList();
    }

    public void showList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (currentFragment == null) {
            fragmentManager.beginTransaction().
                    add(R.id.fragment_container, new MyListFragment()).
                    commit();
        }
    }

    public void showNumber(int number, int color) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        Fragment currentFragment = fragmentManager.findFragmentById(R.id.fragment_container);

        if (currentFragment instanceof MyListFragment) {
            transaction.replace(R.id.fragment_container, FocusFragment.newInstance(number, color));
            transaction.addToBackStack(null);
        }
        transaction.commit();
    }
}
