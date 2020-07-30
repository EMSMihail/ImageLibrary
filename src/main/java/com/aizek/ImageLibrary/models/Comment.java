package com.aizek.ImageLibrary.models;

import com.aizek.ImageLibrary.repo.UserRepository;

import javax.persistence.*;

@Entity
public class Comment{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    public String username;

    public String CommentText;

    public Long getId() {
        return this.id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getUsername() {
        return this.username;
    }

    public void setUsername(final String username) {
        this.username = username;
    }

    public String getCommentText() {
        return this.CommentText;
    }

    public void setCommentText(final String commentText) {
        this.CommentText = commentText;
    }

    public Comment() {
    }

    public Comment(final String username, final String commentText) {
        this.username = username;
        this.CommentText = commentText;
    }
}
