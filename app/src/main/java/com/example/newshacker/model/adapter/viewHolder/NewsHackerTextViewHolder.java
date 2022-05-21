package com.example.newshacker.model.adapter.viewHolder;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newshacker.databinding.LayoutTopStoriesItemBinding;


public class NewsHackerTextViewHolder  extends RecyclerView.ViewHolder {
    LayoutTopStoriesItemBinding binding;

    public NewsHackerTextViewHolder(@NonNull LayoutTopStoriesItemBinding binding){
        super(binding.getRoot());
        this.binding = binding;

    }
    public void bindView(String txtScore,String txtAuthorName,
                         String txtDatePosted,String txtArticleTitle){
        binding.labelPointValue.setText(txtScore);
        binding.labelStoryAuthor.setText(txtAuthorName);
        binding.labelStoryCreatedAt.setText(txtDatePosted);
        binding.labelStoryTitle.setText(txtArticleTitle);
    }


}
