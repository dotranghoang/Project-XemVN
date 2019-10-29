package com.codegym.repository;

import com.codegym.model.Like;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface LikeRepository extends PagingAndSortingRepository<Like,Long> {
}
