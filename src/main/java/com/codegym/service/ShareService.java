package com.codegym.service;

import com.codegym.model.Share;

public interface ShareService {
    Iterable<Share> findAll();

    Share findById(Long id);

    void remove(Long id);

    void save(Share share);
}
