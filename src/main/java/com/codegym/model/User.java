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
    @OneToMany(targetEntity = Community.class)
    private List<Community> communities;

    public User(String nickName, String account, String password, List<Post> posts, List<Community> communities) {
        this.nickName = nickName;
        this.account = account;
        this.password = password;
        this.posts = posts;
        this.communities = communities;
    }

    public List<Community> getCommunities() {
        return communities;
    }

    public void setCommunities(List<Community> communities) {
        this.communities = communities;
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
