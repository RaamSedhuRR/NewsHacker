package com.example.newshacker.viewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newshacker.model.utils.Article;
import com.example.newshacker.model.utils.Comment;

import java.util.List;



public class NewsHackerViewModel extends ViewModel {

    ApiRepositories apiRepositories;
    MutableLiveData<List<Article>> articleList;
    MutableLiveData<List<Comment>> commentList;

    public NewsHackerViewModel () {
        apiRepositories = new ApiRepositories();
    }

    public LiveData<List<Article>> getTopArticlesDataSet(){
        if(articleList == null){
            articleList = apiRepositories.getTopArticleDataSet();
        }
        return articleList;
    }

    public LiveData<List<Article>> getBestArticlesDataSet(){
        if(articleList == null){
            articleList = apiRepositories.getBestArticleDataSet();
        }
        return articleList;
    }
    public LiveData<List<Comment>> getCommentsDataSet(){
        if(commentList == null){
            commentList = apiRepositories.getCommentsDataSet();
        }
        return commentList;
    }

}
