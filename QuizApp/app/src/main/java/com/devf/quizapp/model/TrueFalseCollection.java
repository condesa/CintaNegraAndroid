package com.devf.quizapp.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Condesa on 19/02/16.
 */
public class TrueFalseCollection {

    @SerializedName("questions")
    public List<TrueFalse> questions;
}
