package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "comment")
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String comment;
    private LocalDateTime dateTime;
    private Long postId;
    private Long userId;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Comment(String comment, LocalDateTime dateTime, Long postId, Long userId, User user, Post post) {
        this.comment = comment;
        this.dateTime = dateTime;
        this.postId = postId;
        this.userId = userId;
        this.user = user;
        this.post = post;
    }

    public Comment(String report, Long postId, Long userId, User user, Post post) {
        this.comment = report;
        this.postId = postId;
        this.userId = userId;
        this.user = user;
        this.post = post;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Comment(String report, Post post) {
        this.comment = report;
        this.post = post;
    }

    public Comment(String report, User user, Post post) {
        this.comment = report;
        this.user = user;
        this.post = post;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Comment(String report) {
        this.comment = report;
    }

    public Comment() {
    }
}


