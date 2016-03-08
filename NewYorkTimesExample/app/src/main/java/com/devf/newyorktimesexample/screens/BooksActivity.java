package com.devf.newyorktimesexample.screens;

import android.support.v4.app.Fragment;

import com.devf.newyorktimesexample.core.NavigationViewActivity;
import com.devf.newyorktimesexample.fragments.BooksFragment;

/**
 * Created by Condesa on 04/03/16.
 */
public class BooksActivity extends NavigationViewActivity {

    @Override
    protected Fragment createFragment() {
        return new BooksFragment();
    }
}
