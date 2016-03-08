package com.devf.newyorktimesexample.volley.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Condesa on 07/03/16.
 */
public class Book {

    @SerializedName("list_name")
    private String listName;
    @SerializedName("published_date")
    private String publishedDate;

    @SerializedName("book_details")
    private List<BookDetail> bookDetails;

    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }

    public String getPublishedDate() {
        return publishedDate;
    }

    public void setPublishedDate(String publishedDate) {
        this.publishedDate = publishedDate;
    }

    public List<BookDetail> getBookDetails() {
        return bookDetails;
    }

    public void setBookDetails(List<BookDetail> bookDetails) {
        this.bookDetails = bookDetails;
    }
}
