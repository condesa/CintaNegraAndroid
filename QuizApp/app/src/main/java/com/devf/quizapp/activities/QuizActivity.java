package com.devf.quizapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.devf.quizapp.R;
import com.devf.quizapp.fragments.QuizFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

public class QuizActivity extends SingleFragmentActiviy {

    @Override
    protected Fragment createFragment() {
        return new QuizFragment();
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
                startActivity(new Intent(this, QuizListActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
