package com.codegym.service.Impl;

import com.codegym.model.Like;
import com.codegym.repository.LikeRepository;
import com.codegym.service.LikeService;
import org.springframework.beans.factory.annotation.Autowired;

public class LikeServiceImpl implements LikeService {

    @Autowired
    private LikeRepository likeRepository;

    @Override
    public Iterable<Like> findAll() {
        return likeRepository.findAll();
    }

    @Override
    public Like findById(Long id) {
        return likeRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        likeRepository.delete(id);
    }

    @Override
    public void save(Like like) {
        likeRepository.save(like);
    }
}
