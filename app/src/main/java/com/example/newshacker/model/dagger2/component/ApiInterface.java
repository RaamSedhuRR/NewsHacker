package com.example.newshacker.model.dagger2.component;

import com.example.newshacker.model.utils.Article;
import com.example.newshacker.model.utils.Comment;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("3c69d91f-f5a3-43ca-82ce-d0cda903aaf6")
    Call<List<Article>> getArticles();

    @GET("13aaa326-f111-43c2-8e21-60f2edee84be")
    Call<List<Article>> getBestArticles();

    @GET("bdd537fb-a7bb-4b03-ad05-a2f7a71658ee")
    Call<List<Comment>> getComments();
}
