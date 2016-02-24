package com.devf.quizapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devf.quizapp.R;
import com.devf.quizapp.adapter.QuestionAdapter;
import com.devf.quizapp.model.TrueFalseCollection;
import com.devf.quizapp.utils.Constants;
import com.devf.quizapp.utils.QuizGenerator;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Condesa on 19/02/16.
 */
public class QuizListFragment extends Fragment  {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    private QuestionAdapter questionAdapter;
    private TrueFalseCollection trueFalseCollection;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz_list, container, false);
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
                        setUpRecyclerView();
                    }
                });
            }
        }.start();
    }

    private void setUpRecyclerView(){
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(1,
                StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        questionAdapter = new QuestionAdapter(getActivity(), trueFalseCollection.questions);
        recyclerView.setAdapter(questionAdapter);
    }


}
