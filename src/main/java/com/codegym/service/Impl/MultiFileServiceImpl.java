package com.codegym.service.Impl;

import com.codegym.model.MultiFile;
import com.codegym.repository.MultiFileRepository;
import com.codegym.service.MultiFileService;
import org.springframework.beans.factory.annotation.Autowired;

public class MultiFileServiceImpl implements MultiFileService {

    @Autowired
    private MultiFileRepository multiFileRepository;
    @Override
    public Iterable<MultiFile> findAll() {
        return multiFileRepository.findAll();
    }

    @Override
    public MultiFile findById(Long id) {
        return multiFileRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        multiFileRepository.delete(id);
    }

    @Override
    public void save(MultiFile file) {
        multiFileRepository.save(file);
    }
}
