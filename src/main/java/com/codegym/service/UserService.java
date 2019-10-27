package com.codegym.service;

import com.codegym.model.User;

public interface UserService {
    Iterable<User> findAll();

    User findById(Long id);

    void remove(Long id);

    void save(User user);
}
