package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String nickName;
    private String account;
    private String password;

    @JsonIgnore
    @OneToMany(targetEntity = Post.class)
    private List<Post> posts;

    @JsonIgnore
    @OneToMany(targetEntity = Report.class)
    private List<Report> reports;

    @JsonIgnore
    @OneToMany(targetEntity = Comment.class)
    private List<Comment> comments;

    @JsonIgnore
    @OneToMany(targetEntity = Like.class)
    private List<Like> likes;

    @JsonIgnore
    @OneToMany(targetEntity = Share.class)
    private List<Share> shares;

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public User(String nickName, String account, String password, List<Post> posts, List<Report> reports, List<Comment> comments, List<Like> likes, List<Share> shares) {
        this.nickName = nickName;
        this.account = account;
        this.password = password;
        this.posts = posts;
        this.reports = reports;
        this.comments = comments;
        this.likes = likes;
        this.shares = shares;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public User(String nickName, String account, String password, List<Post> posts, List<Report> reports, List<Comment> comments, List<Like> likes) {
        this.nickName = nickName;
        this.account = account;
        this.password = password;
        this.posts = posts;
        this.reports = reports;
        this.comments = comments;
        this.likes = likes;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public User(String nickName, String account, String password, List<Post> posts, List<Report> reports, List<Comment> comments) {
        this.nickName = nickName;
        this.account = account;
        this.password = password;
        this.posts = posts;
        this.reports = reports;
        this.comments = comments;
    }

    public User(String nickName, String account, String password, List<Post> posts, List<Report> reports) {
        this.nickName = nickName;
        this.account = account;
        this.password = password;
        this.posts = posts;
        this.reports = reports;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public User(String nickName, String account, String password, List<Post> posts) {
        this.nickName = nickName;
        this.account = account;
        this.password = password;
        this.posts = posts;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }

    public User() {
    }

    public User(String nickName, String account, String password) {
        this.nickName = nickName;
        this.account = account;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
