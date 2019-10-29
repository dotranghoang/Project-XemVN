package com.codegym.service.Impl;

import com.codegym.model.Post;
import com.codegym.model.Type;
import com.codegym.model.User;
import com.codegym.repository.PostRepository;
import com.codegym.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;

public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepository postRepository;

    @Override
    public Iterable<Post> findAll() {
        return postRepository.findAll();
    }

    @Override
    public Post findById(Long id) {
        return postRepository.findOne(id);
    }

    @Override
    public void remove(Long id) {
        postRepository.delete(id);
    }

    @Override
    public void save(Post post) {
        postRepository.save(post);
    }

    @Override
    public Iterable<Post> findAllByType(Type type) {
        return postRepository.findAllByType(type);
    }

    @Override
    public Iterable<Post> findAllByUser(User user) {
        return postRepository.findAllByUser(user);
    }


}
