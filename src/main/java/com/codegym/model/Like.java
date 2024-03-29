package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "like")
public class Like {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private boolean like;
    private Long postId;
    private Long userId;

    public Like(boolean like, Long postId, Long userId, User user, Post post) {
        this.like = like;
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

    public Like(boolean report, Post post) {
        this.like = report;
        this.post = post;
    }

    public Like(boolean report, User user, Post post) {
        this.like = report;
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
    public boolean isLike() {
        return like;
    }

    public void setLike(boolean like) {
        this.like = like;
    }

    public Like(boolean like) {
        this.like = like;
    }

    public Like() {
    }
}
