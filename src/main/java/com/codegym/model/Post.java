package com.codegym.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "post")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String title;
    private LocalDateTime date;
    private Long typeId;
    private Long userId;

    @JsonIgnore
    @OneToMany(targetEntity = Report.class)
    private List<Report> reports;

    @JsonIgnore
    @OneToMany(targetEntity = Comment.class)
    private List<Comment> comments ;

    @JsonIgnore
    @OneToMany(targetEntity = Like.class)
    private List<Like> likes ;

    @JsonIgnore
    @OneToMany(targetEntity = Share.class)
    private List<Share> shares ;

    @JsonIgnore
    @OneToMany(targetEntity = MultiFile.class)
    private List<MultiFile> files;

    public List<MultiFile> getFiles() {
        return files;
    }

    public void setFiles(List<MultiFile> files) {
        this.files = files;
    }

    public Post(String title, LocalDateTime date, Long typeId, Long userId, List<Report> reports, List<Comment> comments, List<Like> likes, List<Share> shares, List<MultiFile> files, User user, Type type) {
        this.title = title;
        this.date = date;
        this.typeId = typeId;
        this.userId = userId;
        this.reports = reports;
        this.comments = comments;
        this.likes = likes;
        this.shares = shares;
        this.files = files;
        this.user = user;
        this.type = type;
    }

    public List<Share> getShares() {
        return shares;
    }

    public void setShares(List<Share> shares) {
        this.shares = shares;
    }

    public Post(String title, LocalDateTime date, Long typeId, Long userId, List<Report> reports, List<Comment> comments, List<Like> likes, List<Share> shares, User user, Type type) {
        this.title = title;
        this.date = date;
        this.typeId = typeId;
        this.userId = userId;
        this.reports = reports;
        this.comments = comments;
        this.likes = likes;
        this.shares = shares;
        this.user = user;
        this.type = type;
    }

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public Post(String title,LocalDateTime date, Long typeId, Long userId, List<Report> reports, List<Comment> comments, List<Like> likes, User user, Type type) {
        this.title = title;
        this.date = date;
        this.typeId = typeId;
        this.userId = userId;
        this.reports = reports;
        this.comments = comments;
        this.likes = likes;
        this.user = user;
        this.type = type;
    }

    public Post(String title,  LocalDateTime date, Long typeId, Long userId, List<Report> reports, List<Comment> comments, User user, Type type) {
        this.title = title;
        this.date = date;
        this.typeId = typeId;
        this.userId = userId;
        this.reports = reports;
        this.comments = comments;
        this.user = user;
        this.type = type;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Post(String title,LocalDateTime date, Long typeId, Long userId, List<Report> reports, User user, Type type) {
        this.title = title;
        this.date = date;
        this.typeId = typeId;
        this.userId = userId;
        this.reports = reports;
        this.user = user;
        this.type = type;
    }

    public Post(String title,LocalDateTime date, Long typeId, List<Report> reports, User user, Type type) {
        this.title = title;
        this.date = date;
        this.typeId = typeId;
        this.reports = reports;
        this.user = user;
        this.type = type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }



    public Post(String title, LocalDateTime date, List<Report> reports, User user, Type type) {
        this.title = title;
        this.date = date;
        this.reports = reports;
        this.user = user;
        this.type = type;
    }

    public List<Report> getReports() {
        return reports;
    }

    public void setReports(List<Report> reports) {
        this.reports = reports;
    }

    public Post(String title,LocalDateTime date, User user, Type type) {
        this.title = title;
        this.date = date;
        this.user = user;
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(String title,LocalDateTime date, Type type) {
        this.title = title;
        this.date = date;
        this.type = type;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Post() {
    }

    public Post(String title,LocalDateTime date) {
        this.title = title;
        this.date = date;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
