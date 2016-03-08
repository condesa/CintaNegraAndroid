package com.devf.newyorktimesexample.volley.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Condesa on 07/03/16.
 */
public class BookResponse {

    @SerializedName("status")
    private String status;
    @SerializedName("results")
    private List<Book> results;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<Book> getResults() {
        return results;
    }

    public void setResults(List<Book> results) {
        this.results = results;
    }
}
