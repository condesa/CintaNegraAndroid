package com.devf.quizapp.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.devf.quizapp.R;
import com.devf.quizapp.adapter.QuestionAdapter;
import com.devf.quizapp.fragments.QuizListFragment;
import com.devf.quizapp.model.TrueFalse;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ListQuestionActivity extends AppCompatActivity implements QuestionAdapter.OnItemClickListener {

    @Bind(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_question);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);

        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment = fragmentManager.findFragmentById(R.id.container_fragment);
        if(fragment == null){
            fragment = new QuizListFragment();
            fragmentManager.beginTransaction()
                    .add(R.id.container_fragment, fragment)
                    .commit();
        }
    }

    @Override
    public void onClick(TrueFalse trueFalseSelected) {
        Snackbar.make(coordinatorLayout, trueFalseSelected.question, Snackbar.LENGTH_SHORT).show();
    }
}
