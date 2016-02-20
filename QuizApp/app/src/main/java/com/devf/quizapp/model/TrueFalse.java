package com.devf.quizapp.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Condesa on 11/02/16.
 */
public class TrueFalse {

    @SerializedName("label")
    public String question;
    @SerializedName("isTrue")
    public boolean trueQuestion;

}
