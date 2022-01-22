package com.santosh.springexceptionhandling.repository;

import com.santosh.springexceptionhandling.model.Department;
import com.santosh.springexceptionhandling.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {
    private List<User> users = new ArrayList<>();

    public List<User> getAllUsers() {

        if (users.isEmpty()) {

            User user1 = new User();
            user1.setId(1);
            user1.setName("Super Admin");
            user1.setUsername("superadmin");
            user1.setPassword("test");
            user1.setDepartment(new Department(1));

            users.add(user1);

            User user2 = new User();
            user2.setId(2);
            user2.setName("Admin");
            user2.setUsername("admin");
            user2.setPassword("test");
            user2.setDepartment(new Department(1));

            users.add(user2);
        }

        return users;
    }

    public User findUserById(int id) {
        for (User user : users) {
            if (user.getId() == id) {
                return user;
            }
        }
        return null;
    }

    public User addUser(User user) {
        int userId = 1;

        if (users.size() > 0) {
            int recentUserId = users.get(users.size() - 1).getId();
            userId = recentUserId + 1;
        }

        user.setId(userId);
        users.add(user);
        return user;
    }

    public void deleteUserById(int id) {
        List<User> userList = new ArrayList<>();
        for (User user : users) {
            if (user.getId() != id) {
                userList.add(user);
            }
        }
        this.users = userList;
    }
}
