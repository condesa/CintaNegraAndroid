package com.devf.quizapp.activities;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
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

public class QuizListActivity extends SingleFragmentActiviy implements QuestionAdapter.OnItemClickListener {

    @Bind(R.id.fab)
    FloatingActionButton floatingActionButton;

    @Override
    protected int getResLayout() {
        return R.layout.activity_list_question;
    }

    @Override
    protected Fragment createFragment() {
        return new QuizListFragment();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @Override
    public void onClick(TrueFalse trueFalseSelected) {
        showSnackbar(trueFalseSelected.question);
    }
}
