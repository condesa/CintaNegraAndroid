package com.devf.quizapp;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.coordinator_layout) CoordinatorLayout coordinatorLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

    @OnClick(R.id.button_true)
    public void showMessageButtonTrue() {
        Snackbar.make(coordinatorLayout, R.string.label_correct_answer, Snackbar.LENGTH_LONG).show();
    }

    @OnClick(R.id.button_false)
    public void showMessageButtonFalse() {
        Snackbar.make(coordinatorLayout, R.string.label_incorrect_answer, Snackbar.LENGTH_LONG).show();
    }
}
