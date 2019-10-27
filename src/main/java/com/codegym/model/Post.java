package com.codegym.model;

import javax.persistence.*;
import java.util.Date;
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
    private Date timer;

    @OneToMany(targetEntity = Community.class)
    private List<Community> communities;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private Type type;

    public Post(String title, String video, String image, Date timer, List<Community> communities, User user, Type type) {
        this.title = title;
        this.video = video;
        this.image = image;
        this.timer = timer;
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

    public Post(String title, String video, String image, Date timer, User user, Type type) {
        this.title = title;
        this.video = video;
        this.image = image;
        this.timer = timer;
        this.user = user;
        this.type = type;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Post(String title, String video, String image, Date timer, Type type) {
        this.title = title;
        this.video = video;
        this.image = image;
        this.timer = timer;
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

    public Post(String title, String video, String image, Date timer) {
        this.title = title;
        this.video = video;
        this.image = image;
        this.timer = timer;
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

    public Date getTimer() {
        return timer;
    }

    public void setTimer(Date timer) {
        this.timer = timer;
    }
}
