package com.devf.quizapp.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devf.quizapp.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Condesa on 19/02/16.
 */
public class QuizListFragment extends Fragment {

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_quiz_list, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
}
