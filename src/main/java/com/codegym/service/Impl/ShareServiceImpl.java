package com.codegym.service.Impl;

import com.codegym.model.Share;
import com.codegym.repository.ShareRepository;
import com.codegym.service.ShareService;
import org.springframework.beans.factory.annotation.Autowired;

public class ShareServiceImpl implements ShareService {

    @Autowired
    private ShareRepository shareRepository;

    @Override
    public Iterable<Share> findAll() {
        return shareRepository.findAll();
    }

    @Override
    public Share findById(Long id) {
        return shareRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        shareRepository.delete(id);
    }

    @Override
    public void save(Share share) {
        shareRepository.save(share);
    }
}
