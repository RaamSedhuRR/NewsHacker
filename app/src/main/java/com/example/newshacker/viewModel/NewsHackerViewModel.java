package com.example.newshacker.viewModel;


import android.util.Log;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.newshacker.model.dagger2.component.AppComponent;
import com.example.newshacker.model.dagger2.component.DaggerAppComponent;
import com.example.newshacker.model.dagger2.module.RetrofitModule;
import com.example.newshacker.model.utils.Article;
import com.example.newshacker.model.utils.Comment;

import java.util.List;

import javax.inject.Inject;


public class NewsHackerViewModel extends ViewModel {

    ApiRepositories apiRepositories;
    MutableLiveData<List<Article>> articleList;
    MutableLiveData<List<Comment>> commentList;

    private String TAG = "Dependency Injection TAG:";

    @Inject
    String Text;

    public NewsHackerViewModel (){

        AppComponent appComponent = DaggerAppComponent.builder().
                retrofitModule(new RetrofitModule()).build();

        appComponent.inject(NewsHackerViewModel.this);

        Log.e(TAG,Text);

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
