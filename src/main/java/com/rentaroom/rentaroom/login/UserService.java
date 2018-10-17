package com.rentaroom.rentaroom.login;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}