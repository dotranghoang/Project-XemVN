package com.codegym.repository;

import com.codegym.model.MultiFile;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MultiFileRepository extends PagingAndSortingRepository<MultiFile,Long> {
}
