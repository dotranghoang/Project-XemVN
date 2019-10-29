package com.codegym.service;

import com.codegym.model.Post;
import com.codegym.model.Type;
import com.codegym.model.User;

public interface PostService {
    Iterable<Post> findAll();

    Post findById(Long id);

    void remove(Long id);

    void save(Post post);

    Iterable<Post> findAllByType(Type type);

    Iterable<Post> findAllByUser(User user);
}
