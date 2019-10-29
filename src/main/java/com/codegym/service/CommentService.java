package com.codegym.service;

import com.codegym.model.Comment;

public interface CommentService {
    Iterable<Comment> findAll();

    Comment findById(Long id);

    void remove(Long id);

    void save(Comment comment);
}
