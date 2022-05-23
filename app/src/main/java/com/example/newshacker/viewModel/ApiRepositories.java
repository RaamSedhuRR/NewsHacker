package com.example.newshacker.viewModel;

import android.util.Log;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.newshacker.model.dagger2.component.ApiInterface;

import com.example.newshacker.model.dagger2.component.AppComponent;
import com.example.newshacker.model.dagger2.component.DaggerAppComponent;
import com.example.newshacker.model.dagger2.module.RetrofitModule;
import com.example.newshacker.model.utils.Article;
import com.example.newshacker.model.utils.Comment;


import java.util.List;


import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiRepositories {

    public String TAG = "Failure Call:";


    @Inject
    ApiInterface apiInterface;


    public  MutableLiveData<List<Article>> getTopArticleDataSet(){

        injectDependencies();

        final MutableLiveData<List<Article>> articleList = new MutableLiveData<>();


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

        injectDependencies();

        final MutableLiveData<List<Article>> articleList = new MutableLiveData<>();

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

        injectDependencies();

        final MutableLiveData<List<Comment>> commentList = new MutableLiveData<>();


        Call<List<Comment>> Call = apiInterface.getComments();

        Call.enqueue(new Callback<List<Comment>>() {
            @Override
            public void onResponse (@NonNull retrofit2.Call<List<Comment>> call,
                                    @NonNull Response<List<Comment>> response) {

                commentList.setValue(response.body());

            }

            @Override
            public void onFailure (@NonNull retrofit2.Call<List<Comment>> call,
                                   @NonNull Throwable t) {

                Log.e(TAG,"Failed to fetch..."+t.getLocalizedMessage());

            }
        });

        return commentList;

    }
    private void injectDependencies () {
        AppComponent appComponent = DaggerAppComponent.builder().
                retrofitModule(new RetrofitModule()).build();

        appComponent.inject(ApiRepositories.this);

    }


}
