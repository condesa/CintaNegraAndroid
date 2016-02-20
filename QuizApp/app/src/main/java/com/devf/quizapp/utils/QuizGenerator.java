package com.devf.quizapp.utils;

import android.content.Context;

import com.devf.quizapp.model.TrueFalse;
import com.devf.quizapp.model.TrueFalseCollection;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Condesa on 19/02/16.
 */
public class QuizGenerator {

    public static TrueFalseCollection getTrueFalseCollection(Context context, String jsonFileName){
        JSONObject jsonObject = Utility.loadJSONObjectFromAsset(context, jsonFileName);
        Gson gson = new Gson();
        TrueFalseCollection trueFalseCollection = gson.fromJson(jsonObject.toString(), TrueFalseCollection.class);
        return trueFalseCollection;
    }
}
