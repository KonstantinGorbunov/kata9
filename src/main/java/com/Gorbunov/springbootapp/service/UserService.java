package com.Gorbunov.springbootapp.service;

import com.Gorbunov.springbootapp.model.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User getUserById(Long id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
