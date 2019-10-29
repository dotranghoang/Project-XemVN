package com.codegym.repository;

import com.codegym.model.Share;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ShareRepository extends PagingAndSortingRepository<Share,Long> {
}
