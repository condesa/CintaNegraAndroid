package com.devf.newyorktimesexample.retrofit;

import com.devf.newyorktimesexample.volley.models.BookResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by Condesa on 14/03/16.
 */
public interface MyApiEndpointInterface {

    // Request method and URL specified in the annotation
    // Callback for the parsed response is the last parameter

    @GET("svc/books/v2/lists/{date}/trade-fiction-paperback.json?api-key={apiKey}")
    Call<BookResponse> getBooks(@Path("date") String date, @Query("apiKey") String apiKey);

}
