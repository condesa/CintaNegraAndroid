package com.devf.newyorktimesexample.utils.asynctask;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.devf.newyorktimesexample.volley.models.Book;
import com.devf.newyorktimesexample.volley.models.BookResponse;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

/**
 * Created by Condesa on 07/03/16.
 */
public class ProcessBookList extends AsyncTask<Void, Void, List<Book>> {

    private ProcessBookCallback callback;
    private JSONObject jsonResponse;

    public interface ProcessBookCallback{
        void processFinish(List<Book> books);
    }

    public ProcessBookList(JSONObject jsonResponse, ProcessBookCallback callback){
        this.jsonResponse = jsonResponse;
        this.callback = callback;
    }

    @Override
    protected List<Book> doInBackground(Void... params) {
        Gson gson = new Gson();
        BookResponse bookResponse = gson.fromJson(jsonResponse.toString(), BookResponse.class);
        return bookResponse.getResults();
    }

    @Override
    protected void onPostExecute(List<Book> books) {
        if(callback != null){
            callback.processFinish(books);
        }
    }
}
