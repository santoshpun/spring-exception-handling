package com.santosh.springexceptionhandling.service;

import com.santosh.springexceptionhandling.model.User;

import java.util.List;

public interface UserService {

    List<User> fetchUserList();

    User getUser(int id);

    User addUser(String name, String username, String password);

    boolean deleteUser(int id);
}
