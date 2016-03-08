package com.devf.newyorktimesexample.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by Condesa on 07/03/16.
 */
public class Utility {

    public static boolean isEmptyString(String string){
        if(string == null){
            return true;
        }

        if(string.equals(null)){
            return true;
        }

        if(string.equals("null")){
            return true;
        }

        if(string.equals("") || string.equals(" ")){
            return true;
        }else{
            return false;
        }
    }

    public static String getDateForBooksRequest(){
        Date date = new Date();
        SimpleDateFormat dateFormat =
                new SimpleDateFormat("yyyy-MM-dd", new Locale("es", "ES"));
        return dateFormat.format(date);
    }
}
