package com.example.newshacker.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newshacker.databinding.FragmentNewStoriesBinding;
import com.example.newshacker.model.adapter.NewsHackerCommentRecyclerAdapter;
import com.example.newshacker.model.utils.Comment;
import com.example.newshacker.viewModel.NewsHackerViewModel;

import java.util.List;
public class NewStoriesFragment extends Fragment {

    FragmentNewStoriesBinding binding;

    Context context;

    List<Comment> commentList;

    NewsHackerCommentRecyclerAdapter adapter;



    NewsHackerViewModel viewModel = new NewsHackerViewModel();

    @Override
    public void onAttach (@NonNull Context context) {
        super.onAttach(context);
        this.context = context;
    }

    @Override
    public void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState); }

    @Override
    public View onCreateView (@NonNull LayoutInflater inflater,ViewGroup container
            ,Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentNewStoriesBinding.inflate(getLayoutInflater());

        binding.swipeToRefresh.setOnRefreshListener(() ->
                binding.swipeToRefresh.setRefreshing(false));

        viewModel.getCommentsDataSet().observe(getViewLifecycleOwner(),comments -> {
            commentList = comments;


            binding.progressBar.setVisibility(View.GONE);
            adapter = new NewsHackerCommentRecyclerAdapter(context, commentList);

            binding.recyclerViewNewStories.setLayoutManager
                    (new LinearLayoutManager(context));

            binding.recyclerViewNewStories.setAdapter(adapter);
        });


        return binding.getRoot();
    }
}

