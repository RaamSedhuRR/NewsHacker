package com.example.newshacker.viewModel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.newshacker.model.retrofit.ApiClient;
import com.example.newshacker.model.retrofit.ApiInterface;
import com.example.newshacker.model.utils.Article;
import com.example.newshacker.model.utils.Comment;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepositories {

    public String TAG = "Failure Call:";

    public  MutableLiveData<List<Article>> getTopArticleDataSet(){

        final MutableLiveData<List<Article>> articleList = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Article>> call = apiInterface.getArticles();

        call.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse (@NonNull Call<List<Article>> call,
                                    @NonNull Response<List<Article>> response) {

                articleList.setValue(response.body());

            }

            @Override
            public void onFailure (@NonNull Call<List<Article>> call,@NonNull Throwable t) {

                Log.e(TAG,"Failed to fetch..."+t.getLocalizedMessage());

            }
        });

        return articleList;

    }

    public  MutableLiveData<List<Article>> getBestArticleDataSet(){

        final MutableLiveData<List<Article>> articleList = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Article>> call = apiInterface.getBestArticles();

        call.enqueue(new Callback<List<Article>>() {
            @Override
            public void onResponse (@NonNull Call<List<Article>> call,
                                    @NonNull Response<List<Article>> response) {

                articleList.setValue(response.body());

            }

            @Override
            public void onFailure (@NonNull Call<List<Article>> call,@NonNull Throwable t) {

                Log.e(TAG,"Failed to fetch..."+t.getLocalizedMessage());

            }
        });

        return articleList;

    }

    public MutableLiveData<List<Comment>> getCommentsDataSet(){

        final MutableLiveData<List<Comment>> commentList = new MutableLiveData<>();

        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

        Call<List<Comment>> Call = apiInterface.getComments();

        Call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse (@NonNull retrofit2.Call<List<Comment>> call,
                                    @NonNull Response<List<Comment>> response) {

                commentList.setValue(response.body());

            }

            @Override
            public void onFailure (@NonNull retrofit2.Call<List<Comment>> call,@NonNull Throwable t) {

                Log.e(TAG,"Failed to fetch..."+t.getLocalizedMessage());

            }
        });

        return commentList;

    }


}
