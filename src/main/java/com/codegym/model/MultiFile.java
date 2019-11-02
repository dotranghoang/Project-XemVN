package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;

@Entity
@Table(name = "file")
public class MultiFile {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nameFile;
    private Long postId;

    public MultiFile(String nameFile, Long postId, Post post) {
        this.nameFile = nameFile;
        this.postId = postId;
        this.post = post;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    @ManyToOne
    @JoinColumn(name = "post_id")
    private Post post;

    public MultiFile() {
    }

    public MultiFile(String nameFile, MultipartFile file, Post post) {
        this.nameFile = nameFile;
        this.post = post;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameFile() {
        return nameFile;
    }

    public void setNameFile(String nameFile) {
        this.nameFile = nameFile;
    }


    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
