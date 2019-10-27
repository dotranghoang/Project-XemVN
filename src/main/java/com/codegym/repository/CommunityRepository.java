package com.codegym.repository;

import com.codegym.model.Community;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CommunityRepository extends PagingAndSortingRepository<Community,Long> {
}
