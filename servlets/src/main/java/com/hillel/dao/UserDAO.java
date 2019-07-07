package com.hillel.dao;

import com.hillel.model.User;
import com.hillel.model.Role;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private List<User> storage = new ArrayList<>();

    public boolean add(User user2) {

        for (User user : storage) {
            if (user.equals(user2)) {
                return false;
            }
        }

        return storage.add(user2);
    }

    public Role getRoleByLoginPassword(String login, String password) {
        Role result = Role.UNKNOWN;

        for (User user : storage) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user.getRole();
            }
        }

        return result;
    }

    public boolean userIsExist(String login, String password) {

        boolean result = false;

        for (User user : storage) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = true;
                break;
            }
        }

        return result;
    }
}
