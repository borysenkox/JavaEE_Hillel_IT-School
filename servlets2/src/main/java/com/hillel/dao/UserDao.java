package com.hillel.dao;

import com.hillel.model.User;
import com.hillel.service.UserService;

import java.util.LinkedList;
import java.util.List;

public class UserDao {
    private List<User> users = new LinkedList<>();
    private UserService userService;

    public UserDao() {
        users.add(new User("Sergey", "Borysenko", "admin", "admin", "not_logged-in", "admin"));
        users.add(new User("Alex", "Popov", "alex", "alex", "not_logged-in", "user"));
    }

    public boolean createUser(User newUser) {
        for (User user : users) {
            if (user.equals(newUser)) {
                return false;
            }
        }
        return users.add(newUser);
    }

    public boolean updateUser(String username, User modifiedUser) {
        for (User user : users) {
            if (modifiedUser != null && username.equals(user.getUsername())) {
                String modifiedFirstName = modifiedUser.getFirstName();
                String modifiedLastName = modifiedUser.getLastName();
                String modifiedUsername = modifiedUser.getUsername();

                if (!modifiedFirstName.isEmpty() && !modifiedLastName.isEmpty() && !modifiedUsername.isEmpty() && !usernameIsExist(modifiedUsername)) {
                    user.setFirstName(modifiedFirstName);
                    user.setLastName(modifiedLastName);
                    user.setUsername(modifiedUsername);
                    return true;
                }
            }
        }
        return false;
    }

    public boolean deleteUser(String username) {
        for (User user : users) {
            if (user.getUsername().equals(username)) {
                users.remove(user);
                return true;
            }
        }
        return false;
    }

    public boolean usernameIsExist(String username) {
        boolean result = false;

        for (User u : users) {
            if (u.getUsername().equals(username)) {
                result = true;
            }
        }
        return result;
    }

    public List<User> listOfUsers() {
        return users;
    }

}