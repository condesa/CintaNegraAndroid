package com.devf.quizapp.fragments;


import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.devf.quizapp.R;
import com.devf.quizapp.model.TrueFalse;
import com.devf.quizapp.model.TrueFalseCollection;
import com.devf.quizapp.utils.Constants;
import com.devf.quizapp.utils.QuizGenerator;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class QuizFragment extends Fragment {

    private static final String TAG = QuizFragment.class.getSimpleName();

    @Bind(R.id.label_question)
    TextView labelQuestion;

    @Bind(R.id.button_previous)
    ImageButton buttonPrevious;
    @Bind(R.id.button_next)
    ImageButton buttonNext;

    private TrueFalseCollection trueFalseCollection;
    private List<TrueFalse> questionBank;
    private int currentIndex = 0;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onStart() {
        super.onStart();
        new Thread(){
            @Override
            public void run() {
                trueFalseCollection = QuizGenerator.getTrueFalseCollection(getActivity(),
                        Constants.QUESTION_JSON_NAME_FILE);

                getActivity().runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        questionBank = trueFalseCollection.questions;
                        validatePosition();
                    }
                });
            }
        }.start();
    }

    private void validatePosition(){
        Log.i(TAG, "Current index " + currentIndex);
        if (currentIndex == 0) {
            buttonPrevious.setEnabled(false);
        } else if(currentIndex == questionBank.size()-1){
            buttonNext.setEnabled(false);
        } else {
            buttonNext.setEnabled(true);
            buttonPrevious.setEnabled(true);
        }
        updateQuestion();
    }

    private void updateQuestion() {
        String question = questionBank.get(currentIndex).question;
        Log.d(TAG, "String " + question);
        labelQuestion.setText(question);
    }

    private void checkAnswer(boolean userAnswer) {
        boolean answerIsTrue = questionBank.get(currentIndex).trueQuestion;
        int messageResId = 0;

        if (userAnswer == answerIsTrue) {
            messageResId = R.string.label_correct_answer;
        } else {
            messageResId = R.string.label_incorrect_answer;
        }
        Toast.makeText(getActivity(), messageResId, Toast.LENGTH_SHORT).show();
        //Snackbar.make(coordinatorLayout, messageResId, Snackbar.LENGTH_LONG).show();
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

}
