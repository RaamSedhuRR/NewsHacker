package com.example.newshacker.model.utils;

import com.google.gson.annotations.SerializedName;

public class Comment {

    @SerializedName("authorName")
    public String authorName;

    @SerializedName("authorComment")
    public String authorComment;

    @SerializedName("commentButton")
    public String commentButton;

    public Comment (String authorName,String authorComment) {
        this.authorName=authorName;
        this.authorComment=authorComment;
    }

    public Comment (String authorName,String authorComment,String commentButton) {
        this.authorName=authorName;
        this.authorComment=authorComment;
        this.commentButton="Comments";
    }

    public String getAuthorName () {
        return authorName;
    }

    public void setAuthorName (String authorName) {
        this.authorName=authorName;
    }

    public String getAuthorComment () {
        return authorComment;
    }

    public void setAuthorComment (String authorComment) {
        this.authorComment=authorComment;
    }

    public String getCommentButton () {
        return "Comments";
    }

    public void setCommentButton (String commentButton) {
        this.commentButton="Comments";
    }
}
