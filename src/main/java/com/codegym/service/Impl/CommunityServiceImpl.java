package com.codegym.service.Impl;

import com.codegym.model.Community;
import com.codegym.repository.CommunityRepository;
import com.codegym.service.CommunityService;
import org.springframework.beans.factory.annotation.Autowired;

public class CommunityServiceImpl implements CommunityService {

    @Autowired
    private CommunityRepository communityRepository;

    @Override
    public Iterable<Community> findAll() {
        return communityRepository.findAll();
    }

    @Override
    public Community findById(Long id) {
        return communityRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        communityRepository.delete(id);
    }

    @Override
    public void save(Community community) {
        communityRepository.save(community);
    }
}
