package com.devf.newyorktimesexample.volley;

/**
 * Created by Condesa on 07/03/16.
 */
public class APIRest {

    // Base URL
    private static final String BASE_URL = "http://api.nytimes.com/";

    // GET Methods Urls
    public static String getBooksList(String date, String apiKey){
        return String.format("%s%s",
                BASE_URL,
                "svc/books/v2/lists/" + date + "/trade-fiction-paperback.json?api-key=" + apiKey);
    }
}
