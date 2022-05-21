package com.example.newshacker.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newshacker.databinding.LayoutNewsHackerPostAndCommentsBinding;
import com.example.newshacker.model.adapter.viewHolder.NewsHackerCommentsViewHolder;
import com.example.newshacker.model.utils.Comment;

import java.util.List;

public class NewsHackerCommentRecyclerAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;

    List<Comment> commentList;


    public NewsHackerCommentRecyclerAdapter (Context context,List<Comment> commentList) {
        this.context=context;
        this.commentList=commentList;
    }


    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType) {

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new NewsHackerCommentsViewHolder(LayoutNewsHackerPostAndCommentsBinding
                .inflate(layoutInflater,parent,false));
    }

    @Override
    public void onBindViewHolder (@NonNull RecyclerView.ViewHolder holder,int position) {
        ((NewsHackerCommentsViewHolder)holder).bindView(commentList.get(position).getAuthorName(),
                                               commentList.get(position).getAuthorComment());

    }

    @Override
    public int getItemCount () {
        return commentList.size();
    }
}
