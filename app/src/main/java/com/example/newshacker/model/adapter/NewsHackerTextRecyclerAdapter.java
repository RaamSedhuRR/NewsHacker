package com.example.newshacker.model.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newshacker.databinding.LayoutTopStoriesItemBinding;
import com.example.newshacker.model.adapter.viewHolder.NewsHackerTextViewHolder;
import com.example.newshacker.model.utils.Article;

import java.util.List;

public class NewsHackerTextRecyclerAdapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;

    List<Article> textNewsList;




    public NewsHackerTextRecyclerAdapter(Context context, List<Article> textNewsList) {
        this.context = context;
        this.textNewsList = textNewsList;

    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder (@NonNull ViewGroup parent,int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        return new NewsHackerTextViewHolder
                (LayoutTopStoriesItemBinding.inflate(layoutInflater,parent,false));
    }

    @Override
    public void onBindViewHolder (@NonNull RecyclerView.ViewHolder holder,int position) {
        ((NewsHackerTextViewHolder) holder).bindView(textNewsList.get(position).getScore()
                ,textNewsList.get(position).getAuthorName(),
                textNewsList.get(position).getDatePosted()
                ,textNewsList.get(position).getArticleTitle());

    }

    @Override
    public int getItemCount () {
        return textNewsList.size();
    }
}
