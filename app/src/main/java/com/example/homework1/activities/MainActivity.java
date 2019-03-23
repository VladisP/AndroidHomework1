package com.example.homework1.activities;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import com.example.homework1.R;
import com.example.homework1.fragments.MyListFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showList();
    }

    private void showList() {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        MyListFragment listFragment = (MyListFragment) fragmentManager.findFragmentById(R.id.fragment_container);

        if (listFragment == null) {
            Log.d("FUCK", "im here");
            transaction.add(R.id.fragment_container, new MyListFragment());
        }

        transaction.commit();
        Log.d("FUCK", "showList");
    }
}
