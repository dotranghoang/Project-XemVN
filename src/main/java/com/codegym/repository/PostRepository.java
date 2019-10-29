package com.codegym.repository;

import com.codegym.model.Post;
import com.codegym.model.Type;
import com.codegym.model.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PostRepository extends PagingAndSortingRepository<Post,Long> {
    Iterable<Post> findAllByType(Type type);
    Iterable<Post> findAllByUser(User user);
}
