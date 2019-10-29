package com.codegym.model;

import javax.persistence.*;

@Entity
@Table(name = "community")
public class Community {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long like;
    private Long share;

    @Lob
    private String report;
    private Long postId;
    private Long userId;

    public Community(Long like, Long share, String report, Long postId, Long userId, User user, Post post) {
        this.like = like;
        this.share = share;
        this.report = report;
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

    public Community(Long like, Long share, String report, Post post) {
        this.like = like;
        this.share = share;
        this.report = report;
        this.post = post;
    }

    public Community(Long like, Long share, String report, User user, Post post) {
        this.like = like;
        this.share = share;
        this.report = report;
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

    public Long getLike() {
        return like;
    }

    public void setLike(Long like) {
        this.like = like;
    }

    public Long getShare() {
        return share;
    }

    public void setShare(Long share) {
        this.share = share;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Community(Long like, Long share, String report) {
        this.like = like;
        this.share = share;
        this.report = report;
    }

    public Community() {
    }
}
