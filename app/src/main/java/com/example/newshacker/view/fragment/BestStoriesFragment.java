package com.example.newshacker.view.fragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.newshacker.databinding.FragmentBestStoriesBinding;
import com.example.newshacker.model.adapter.NewsHackerTextRecyclerAdapter;

import com.example.newshacker.model.utils.Article;
import com.example.newshacker.viewModel.NewsHackerViewModel;

import java.util.List;

public class BestStoriesFragment extends Fragment {

    FragmentBestStoriesBinding binding;

    List<Article> newsHackerTextList;

    Context context;

    NewsHackerTextRecyclerAdapter adapter;

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
    public View onCreateView (@NonNull LayoutInflater inflater,ViewGroup container,
                              Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentBestStoriesBinding.inflate(getLayoutInflater());

        binding.swipeToRefresh.setOnRefreshListener(() ->
                binding.swipeToRefresh.setRefreshing(false));

        viewModel.getBestArticlesDataSet().observe(getViewLifecycleOwner(),articles -> {
            newsHackerTextList = articles;

            binding.progressBar.setVisibility(View.GONE);

            adapter = new NewsHackerTextRecyclerAdapter(context, newsHackerTextList);

            binding.recyclerViewBestStories.setLayoutManager
                    (new LinearLayoutManager(context));

            binding.recyclerViewBestStories.setAdapter(adapter);

        });

        return binding.getRoot();
    }
}