package com.codegym.service;

import com.codegym.model.Community;

public interface CommunityService {
    Iterable<Community> findAll();

    Community findById(Long id);

    void remove(Long id);

    void save(Community community);
}
