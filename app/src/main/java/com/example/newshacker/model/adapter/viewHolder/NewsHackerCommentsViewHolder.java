package com.example.newshacker.model.adapter.viewHolder;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newshacker.databinding.LayoutNewsHackerPostAndCommentsBinding;

public class NewsHackerCommentsViewHolder extends RecyclerView.ViewHolder {
    LayoutNewsHackerPostAndCommentsBinding binding;

    public NewsHackerCommentsViewHolder (@NonNull LayoutNewsHackerPostAndCommentsBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }
    public void bindView(String txtAuthorName,String txtAuthorComment){
        binding.textCommentAuthor.setText(txtAuthorName);
        binding.textCommentPost.setText(txtAuthorComment);
        binding.btnComment.setText("Comments");
    }
}
