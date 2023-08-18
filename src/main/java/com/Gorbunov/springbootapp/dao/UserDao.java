package com.Gorbunov.springbootapp.dao;

import com.Gorbunov.springbootapp.model.User;

import java.util.List;

public interface UserDao {
    List<User> getUserList();

    User getUserById(Long id);

    void addUser(User user);

    void updateUser(User user);

    void deleteUser(Long id);
}
