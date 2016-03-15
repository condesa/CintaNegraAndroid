package com.devf.newyorktimesexample.screens;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.devf.newyorktimesexample.core.NavigationViewActivity;
import com.devf.newyorktimesexample.fragments.LoginFragment;
import com.facebook.CallbackManager;
import com.facebook.FacebookSdk;

/**
 * Created by Condesa on 14/03/16.
 */
public class LoginActivity extends NavigationViewActivity {

    CallbackManager callbackManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        callbackManager = CallbackManager.Factory.create();
    }

    @Override
    protected Fragment createFragment() {
        return new LoginFragment();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
