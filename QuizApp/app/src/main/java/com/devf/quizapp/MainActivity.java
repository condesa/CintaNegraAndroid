package com.devf.quizapp;

import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

import com.devf.quizapp.model.TrueFalse;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Bind(R.id.coordinator_layout) CoordinatorLayout coordinatorLayout;
    @Bind(R.id.label_question) TextView labelQuestion;

    private TrueFalse[] questionBank = new TrueFalse[]{
            new TrueFalse(R.string.question_oceans, true),
            new TrueFalse(R.string.question_mideast, false),
            new TrueFalse(R.string.question_africa, false),
            new TrueFalse(R.string.question_americas, true),
            new TrueFalse(R.string.question_asia, true),
    };
    private int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        updateQuestion();


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    @OnClick({R.id.button_next, R.id.label_question})
    public void showNextQuestion(){
        currentIndex = currentIndex++;
        updateQuestion();
    }

    @OnClick(R.id.button_true)
    public void showMessageButtonTrue() {
        checkAnswer(true);
    }

    @OnClick(R.id.button_false)
    public void showMessageButtonFalse() {
        checkAnswer(false);
    }

    private void updateQuestion(){
        int question = questionBank[currentIndex].getQuestion();
        labelQuestion.setText(question);
    }

    private void checkAnswer(boolean userAnswer){
        boolean answerIsTrue = questionBank[currentIndex].isTrueQuestion();
        int messageResId = 0;

        if(userAnswer == answerIsTrue){
            messageResId = R.string.label_correct_answer
        }
    }
}
