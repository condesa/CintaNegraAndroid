package com.devf.newyorktimesexample.core;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.inputmethod.InputMethodManager;

import com.afollestad.materialdialogs.MaterialDialog;
import com.devf.newyorktimesexample.R;
import com.devf.newyorktimesexample.volley.VolleyManager;

/**
 * Created by Condesa on 07/03/16.
 */
public class MainFragment extends Fragment {

    protected String TAG = MainFragment.class.getSimpleName();
    protected VolleyManager volleyManager;
    protected boolean isInfoLoaded;
    protected MaterialDialog materialDialog;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        volleyManager = VolleyManager.getInstance(getActivity());
    }

    protected void showMaterialProgress(int title){
        materialDialog = new MaterialDialog.Builder(getActivity())
                .title(getResources().getString(title))
                .titleColor(getResources().getColor(android.R.color.black))
                .content(getResources().getString(R.string.dialog_wait))
                .progress(true, 0)
                .widgetColor(getResources().getColor(R.color.colorPrimary))
                .cancelable(false)
                .show();
    }

    public void hideSoftKeyboard() {
        InputMethodManager inputMethodManager = (InputMethodManager) getActivity().getSystemService(FragmentActivity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getView().getWindowToken(), 0);
    }

    protected void showMaterialDialog(int message) {
        materialDialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.app_name)
                .titleColor(getResources().getColor(android.R.color.black))
                .content(message)
                .positiveText(R.string.button_ok)
                .positiveColor(getResources().getColor(R.color.colorPrimary))
                .show();
    }

    protected void showMaterialDialog(String message) {
        materialDialog = new MaterialDialog.Builder(getActivity())
                .title(R.string.app_name)
                .titleColor(getResources().getColor(android.R.color.black))
                .content(message)
                .positiveText(R.string.button_ok)
                .positiveColor(getResources().getColor(R.color.colorPrimary))
                .show();
    }

    protected void dismissDialog(){
        materialDialog.dismiss();
    }

    protected void showLogMessage(String message){
        Log.i(TAG, message);
    }
}
