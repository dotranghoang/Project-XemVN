package com.codegym.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Lob
    private String report;
    private LocalDateTime dateTime;
    private Long postId;
    private Long userId;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Report(String report, LocalDateTime dateTime, Long postId, Long userId, User user, Post post) {
        this.report = report;
        this.dateTime = dateTime;
        this.postId = postId;
        this.userId = userId;
        this.user = user;
        this.post = post;
    }

    public Report(String report, Long postId, Long userId, User user, Post post) {
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

    public Report(String report, Post post) {
        this.report = report;
        this.post = post;
    }

    public Report(String report, User user, Post post) {
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
    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Report(String report) {
        this.report = report;
    }

    public Report() {
    }
}
