package com.example.newshacker.model.dagger2.component;

import com.example.newshacker.model.dagger2.module.RetrofitModule;

import com.example.newshacker.viewModel.ApiRepositories;
import com.example.newshacker.viewModel.NewsHackerViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { RetrofitModule.class})
public interface AppComponent {
    void inject (NewsHackerViewModel viewModel);
    void inject (ApiRepositories apiRepositories);
}

