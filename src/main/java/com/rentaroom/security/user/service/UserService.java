package com.rentaroom.security.user.service;

import com.rentaroom.security.user.model.User;

public interface UserService {

    void save(User user);

    User findByUsername(String username);
}