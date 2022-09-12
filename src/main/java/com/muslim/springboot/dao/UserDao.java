package com.muslim.springboot.dao;

import com.muslim.springboot.model.User;

import java.util.List;

public interface UserDao {
    void addUser(User user);

    User getUser(int id);

    List<User> listUsers();

    void deleteUser(int id);
}
