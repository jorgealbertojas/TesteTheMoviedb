package com.example.jorge.myapplication.movies;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.example.jorge.myapplication.R;
import com.example.jorge.myapplication.util.Common;

public class MoviesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);

        if (null == savedInstanceState) {
            if (Common.isOnline(this)) {
                initFragment(MoviesFragment.newInstance());
            }
        }
    }

    /**
     * Init Fragment for cars
     * @param carFragment
     */
    private void initFragment(Fragment carFragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.fl_movies, carFragment);
        transaction.commit();

    }
}
