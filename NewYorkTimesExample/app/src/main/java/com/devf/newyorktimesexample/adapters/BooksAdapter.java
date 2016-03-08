package com.devf.newyorktimesexample.adapters;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.devf.newyorktimesexample.R;
import com.devf.newyorktimesexample.volley.models.Book;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Condesa on 07/03/16.
 */
public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.ViewHolder> {

    private List<Book> books;
    private Context context;

    public BooksAdapter(Context context, Fragment fragment, List<Book> books){
        this.context = context;
        this.books = books;
        /*try{
            animeListener = (AnimeListener) appCompatActivity;
        }catch (ClassCastException e){
            throw new ClassCastException(appCompatActivity.toString()
                    + " must implement AnimeListener");
        }*/
    }

    @Override
    public int getItemCount() {
        return books.size();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.row_book, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Book book = books.get(position);

        if(book.getBookDetails().size() > 0){
            Picasso.with(context)
                    .load(book.getBookDetails().get(0).getBookImage())
                    .into(holder.imageBook);
            holder.labelTitle.setText(book.getBookDetails().get(0).getTitle());
            holder.labelAuthor.setText(book.getBookDetails().get(0).getDescription());
        }
    }

    public interface BookSelectedListener {
        void onBookSelected(int book);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.image_book)
        ImageView imageBook;
        @Bind(R.id.label_title)
        TextView labelTitle;
        @Bind(R.id.label_author)
        TextView labelAuthor;
        @Bind(R.id.button_share)
        Button buttonShare;
        @Bind(R.id.button_view_more)
        Button buttonViewMore;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
