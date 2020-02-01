package com.exam.service;

import com.exam.entity.User;

public interface UserService {
    User findByUsername(String username);
}
