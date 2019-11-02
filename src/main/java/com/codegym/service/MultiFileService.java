package com.codegym.service;

import com.codegym.model.MultiFile;

public interface MultiFileService {
    Iterable<MultiFile> findAll();

    MultiFile findById(Long id);

    void remove(Long id);

    void save(MultiFile file);
}
