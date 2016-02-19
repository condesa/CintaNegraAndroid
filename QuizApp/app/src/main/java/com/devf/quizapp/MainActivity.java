package com.devf.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.devf.quizapp.model.TrueFalse;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private final String KEY_INDEX = "com.devf.quizapp.KeyIndex";

    @Bind(R.id.coordinator_layout)
    CoordinatorLayout coordinatorLayout;
    @Bind(R.id.label_question)
    TextView labelQuestion;
    @Bind(R.id.toolbar)
    Toolbar toolbar;
    @Bind(R.id.button_previous)
    ImageButton buttonPrevious;
    @Bind(R.id.button_next)
    ImageButton buttonNext;

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

        if(savedInstanceState != null){
            currentIndex = savedInstanceState.getInt(KEY_INDEX, 0);
        }

        validatePosition();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onStart() {
        super.onStart();
         Log.d(TAG, "onStart called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onResume called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "onPause called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy called");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "onSaveInstanceState");
        outState.putInt(KEY_INDEX, currentIndex);
    }

    @OnClick({R.id.button_next, R.id.label_question})
    public void showNextQuestion() {
        currentIndex = currentIndex + 1;
        validatePosition();
    }

    @OnClick(R.id.button_previous)
    public void showPreviousQuestion() {
        currentIndex = currentIndex - 1;
        validatePosition();
    }

    @OnClick(R.id.button_true)
    public void showMessageButtonTrue() {
        checkAnswer(true);
    }

    @OnClick(R.id.button_false)
    public void showMessageButtonFalse() {
        checkAnswer(false);
    }

    private void validatePosition(){
        Log.i(TAG, "Current index " + currentIndex);
        if (currentIndex == 0) {
            buttonPrevious.setEnabled(false);
        } else if(currentIndex == questionBank.length-1){
            buttonNext.setEnabled(false);
        } else {
            buttonNext.setEnabled(true);
            buttonPrevious.setEnabled(true);
        }
        updateQuestion();
    }

    private void updateQuestion() {
        int question = questionBank[currentIndex].getQuestion();
        Log.d(TAG, "String " + getString(question));
        labelQuestion.setText(question);
    }

    private void checkAnswer(boolean userAnswer) {
        boolean answerIsTrue = questionBank[currentIndex].isTrueQuestion();
        int messageResId = 0;

        if (userAnswer == answerIsTrue) {
            messageResId = R.string.label_correct_answer;
        } else {
            messageResId = R.string.label_incorrect_answer;
        }
        Snackbar.make(coordinatorLayout, messageResId, Snackbar.LENGTH_LONG).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_list:
                // Launch ListQuestionActivity
                startActivity(new Intent(this, ListQuestionActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
