package com.devf.quizapp.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.devf.quizapp.R;
import com.devf.quizapp.model.TrueFalse;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by Condesa on 22/02/16.
 */
public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>  {

    private Context context;
    private List<TrueFalse> items;
    private OnItemClickListener onItemClickListener;

    public QuestionAdapter(Context context, List<TrueFalse> items){
        this.context = context;
        this.items = items;
        try{
            onItemClickListener = (OnItemClickListener) context;
        }catch (ClassCastException e){
            throw new ClassCastException(context.toString()
                    + " must implement OnItemClickListener");
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final TrueFalse option = items.get(position);

        holder.labelQuestion.setText(option.question);
        holder.labelAnswer.setText(String.format(
                context.getResources().getString(R.string.label_answer),
                String.valueOf(option.trueQuestion)));

        holder.containerHolder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickListener.onClick(option);
            }
        });
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).
                inflate(R.layout.row_question, parent, false);
        return new ViewHolder(itemView);
    }

    public interface OnItemClickListener {
        void onClick(TrueFalse trueFalseSelected);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        @Bind(R.id.container_holder)
        ViewGroup containerHolder;
        @Bind(R.id.label_question)
        TextView labelQuestion;
        @Bind(R.id.label_answer)
        TextView labelAnswer;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
