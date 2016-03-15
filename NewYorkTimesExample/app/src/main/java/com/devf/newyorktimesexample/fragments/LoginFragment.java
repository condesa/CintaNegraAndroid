package com.devf.newyorktimesexample.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devf.newyorktimesexample.R;
import com.devf.newyorktimesexample.core.MainFragment;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Condesa on 14/03/16.
 */
public class LoginFragment extends MainFragment {

    @Bind(R.id.login_button)
    LoginButton loginButton;

    CallbackManager callbackManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_login, null);
        ButterKnife.bind(this, mView);
        loginButton.setReadPermissions("public_profile");
        loginButton.setFragment(this);
        callbackManager = CallbackManager.Factory.create();
        loginButton.registerCallback(callbackManager, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                // App code
                showLogMessage(loginResult.getAccessToken().getApplicationId());
            }

            @Override
            public void onCancel() {
                // App code
            }

            @Override
            public void onError(FacebookException
                                        exception) {
                // App code
            }
        });
        return mView;
    }
}
