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

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public Community(Long like, Long share, String report, Post post) {
        this.like = like;
        this.share = share;
        this.report = report;
        this.post = post;
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
