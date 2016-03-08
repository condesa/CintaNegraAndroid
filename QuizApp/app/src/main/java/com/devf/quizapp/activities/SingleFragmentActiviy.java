package com.devf.quizapp.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.devf.quizapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Condesa on 25/02/16.
 */
public abstract class SingleFragmentActiviy extends AppCompatActivity {

    @Bind(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    protected int getResLayout(){
        return R.layout.activity_single_fragment;
    }

    protected abstract Fragment createFragment();

    protected void showSnackbar(int stringResource){
        Snackbar.make(coordinatorLayout, stringResource, Snackbar.LENGTH_SHORT).show();
    }

    protected void showSnackbar(String message){
        Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getResLayout());
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.container_fragment);
        if(fragment == null){
            fragment = createFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.container_fragment, fragment)
                    .commit();
        }
    }
}
