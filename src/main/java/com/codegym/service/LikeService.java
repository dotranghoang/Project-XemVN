package com.codegym.service;

import com.codegym.model.Like;

public interface LikeService {
    Iterable<Like> findAll();

    Like findById(Long id);

    void remove(Long id);

    void save(Like like);
}
