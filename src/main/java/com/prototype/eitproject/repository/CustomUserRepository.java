package com.prototype.eitproject.repository;

import com.prototype.eitproject.model.User;

public interface CustomUserRepository {
    public User findByUsername(String username);

    public boolean existsByUsername(String username);
}