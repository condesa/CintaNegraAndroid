package com.devf.newyorktimesexample.fragments;

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.devf.newyorktimesexample.R;
import com.devf.newyorktimesexample.adapters.BooksAdapter;
import com.devf.newyorktimesexample.core.MainFragment;
import com.devf.newyorktimesexample.utils.Utility;
import com.devf.newyorktimesexample.utils.asynctask.ProcessBookList;
import com.devf.newyorktimesexample.volley.APIRest;
import com.devf.newyorktimesexample.volley.VolleyManager;
import com.devf.newyorktimesexample.volley.models.Book;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Condesa on 07/03/16.
 */
public class BooksFragment extends MainFragment implements
        VolleyManager.OnRequestListener,
        ProcessBookList.ProcessBookCallback{

    @Bind(R.id.recycler_view)
    RecyclerView recyclerView;
    private ProcessBookList processBookList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View mView = inflater.inflate(R.layout.fragment_books, null);
        ButterKnife.bind(this, mView);
        return mView;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(!isInfoLoaded){
            showMaterialProgress(R.string.dialog_download_books);
            volleyManager.setOnRequestListener(this);
            volleyManager.executeGetRequest(
                    APIRest.getBooksList(
                        Utility.getDateForBooksRequest(),
                        getString(R.string.nyt_api_key)));
        }
    }

    /**
     * VolleyManager.OnRequestListener
     */
    @Override
    public void onRequestSuccess(JSONArray responseArray) {
        dismissDialog();
        showMaterialDialog(responseArray.toString());
    }

    @Override
    public void onRequestSuccess(JSONObject responseObject) {
        processBookList = new ProcessBookList(responseObject, this);
        processBookList.execute();
    }

    @Override
    public void onRequestFail(Error error) {
        dismissDialog();
        showMaterialDialog(error.getMessage());
    }

    @Override
    public void processFinish(List<Book> books) {
        dismissDialog();
        isInfoLoaded = true;
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(1, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(new BooksAdapter(getActivity(), this, books));
    }
}
