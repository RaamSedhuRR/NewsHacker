package com.example.newshacker.model.utils;

import com.google.gson.annotations.SerializedName;

public class Article {
    @SerializedName("score")
    public String score;
    @SerializedName("AuthorName")
    public String authorName;
    @SerializedName("Date")
    public String datePosted;
    @SerializedName("title")
    public String articleTitle;

    public String getScore () {
        return score;
    }

    public void setScore (String score) {
        this.score=score;
    }

    public String getAuthorName () {
        return authorName;
    }

    public void setAuthorName (String authorName) {
        this.authorName=authorName;
    }

    public String getDatePosted () {
        return datePosted;
    }

    public void setDatePosted (String datePosted) {
        this.datePosted=datePosted;
    }

    public String getArticleTitle () {
        return articleTitle;
    }

    public void setArticleTitle (String articleTitle) {
        this.articleTitle=articleTitle;
    }

    public Article (String score,String authorName,String datePosted,String articleTitle) {
        this.score=score;
        this.authorName=authorName;
        this.datePosted=datePosted;
        this.articleTitle=articleTitle;
    }
}
