package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class FileForm {
    private Long postId;
    private Long id;
    private MultipartFile file;

    public FileForm(Long postId, Long id, MultipartFile file) {
        this.postId = postId;
        this.id = id;
        this.file = file;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public FileForm() {
    }

    public FileForm(Long id, MultipartFile file) {
        this.id = id;
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
