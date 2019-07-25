package com.hillel.service;

import com.hillel.dao.UserDao;
import com.hillel.model.User;

import java.util.List;

public class UserService {
    private List<User> users;

    public UserService(UserDao storage) {
        users = storage.listOfUsers();
    }

    public boolean userIsExist(String username) {
        boolean result = false;

        for (User user : users) {
            if (user.getUsername().equals(username)) {
                result = true;
                break;
            }
        }

        return result;
    }

    public boolean userIsExistByLoginAndPassword(String username, String password) {
        boolean result = false;

        for (User user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }

        return result;
    }

    public String updateLoginStatus(String user) {
        for (User u : users) {
            if (u.getUsername().equals(user)) {
                u.setStatus("logged-in");
                return u.getStatus();
            }
        }
        return "not_logged-in";
    }

    public User getUserByUsername(String username) {
        for (User u : users) {
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    public List<User> getListOfUsers() {
        return users;
    }

    public void logout(String uname) {
        for (User u : users)
            if (u.getUsername().equals(uname)) {
                u.setStatus("not_logged-in");
            }
    }
}
