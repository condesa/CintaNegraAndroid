package com.devf.newyorktimesexample.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Condesa on 07/03/16.
 */
public class ConnectionUtils {

    public static boolean isNetworkAvailable(Context context){
        final ConnectivityManager connectivityManager =
                (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return ((networkInfo != null) && networkInfo.isConnected());
    }
}
