package com.devf.newyorktimesexample.volley.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Condesa on 07/03/16.
 */
public class BookDetail {

    @SerializedName("title")
    private String title;
    @SerializedName("description")
    private String description;
    @SerializedName("contributor")
    private String contributor;
    @SerializedName("author")
    private String author;
    @SerializedName("publisher")
    private String publisher;
    @SerializedName("book_image")
    private String bookImage;
    @SerializedName("amazon_product_url")
    private String amazonProductUrl;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContributor() {
        return contributor;
    }

    public void setContributor(String contributor) {
        this.contributor = contributor;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getBookImage() {
        return bookImage;
    }

    public void setBookImage(String bookImage) {
        this.bookImage = bookImage;
    }

    public String getAmazonProductUrl() {
        return amazonProductUrl;
    }

    public void setAmazonProductUrl(String amazonProductUrl) {
        this.amazonProductUrl = amazonProductUrl;
    }
}
