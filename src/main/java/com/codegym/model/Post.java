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
    private String video;
    private String image;
    private LocalDateTime date;
    private Long typeId;
    private Long userId;

    @JsonIgnore
    @OneToMany(targetEntity = Community.class)
    private List<Community> communities;

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

    public Post(String title, String video, String image, LocalDateTime date, Long typeId, Long userId, List<Community> communities, User user, Type type) {
        this.title = title;
        this.video = video;
        this.image = image;
        this.date = date;
        this.typeId = typeId;
        this.userId = userId;
        this.communities = communities;
        this.user = user;
        this.type = type;
    }

    public Post(String title, String video, String image, LocalDateTime date, Long typeId, List<Community> communities, User user, Type type) {
        this.title = title;
        this.video = video;
        this.image = image;
        this.date = date;
        this.typeId = typeId;
        this.communities = communities;
        this.user = user;
        this.type = type;
    }

    public Long getTypeId() {
        return typeId;
    }

    public void setTypeId(Long typeId) {
        this.typeId = typeId;
    }



    public Post(String title, String video, String image, LocalDateTime date, List<Community> communities, User user, Type type) {
        this.title = title;
        this.video = video;
        this.image = image;
        this.date = date;
        this.communities = communities;
        this.user = user;
        this.type = type;
    }

    public List<Community> getCommunities() {
        return communities;
    }

    public void setCommunities(List<Community> communities) {
        this.communities = communities;
    }

    public Post(String title, String video, String image, LocalDateTime date, User user, Type type) {
        this.title = title;
        this.video = video;
        this.image = image;
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

    public Post(String title, String video, String image, LocalDateTime date, Type type) {
        this.title = title;
        this.video = video;
        this.image = image;
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

    public Post(String title, String video, String image, LocalDateTime date) {
        this.title = title;
        this.video = video;
        this.image = image;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}
