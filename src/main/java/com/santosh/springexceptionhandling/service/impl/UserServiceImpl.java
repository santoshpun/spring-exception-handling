package com.santosh.springexceptionhandling.service.impl;

import com.santosh.springexceptionhandling.model.User;
import com.santosh.springexceptionhandling.repository.UserRepository;
import com.santosh.springexceptionhandling.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> fetchUserList() {
        return userRepository.getAllUsers();
    }

    @Override
    public User getUser(int id) {
        return userRepository.findUserById(id);
    }

    @Override
    public User addUser(String name, String username, String password) {
        User user = new User();
        user.setName(name);
        user.setUsername(username);
        user.setPassword(password);

        userRepository.addUser(user);

        return user;
    }

    @Override
    public boolean deleteUser(int id) {
        userRepository.deleteUserById(id);
        return true;
    }
}
