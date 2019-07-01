package com.hillel.dao;

import com.hillel.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserDAO {

    private final List<User> storage = new ArrayList<>();

    public boolean add(final User user) {

        for (User u : storage) {
            if (u.getLogin().equals(user.getLogin()) && u.getPassword().equals(user.getPassword())) {
                return false;
            }
        }

        return storage.add(user);
    }

    public User.ROLE getRoleByLoginPassword(final String login, final String password) {
        User.ROLE result = User.ROLE.UNKNOWN;

        for (User user : storage) {
            if (user.getLogin().equals(login) && user.getPassword().equals(password)) {
                result = user.getRole();
            }
        }

        return result;
    }

    public boolean userIsExist(final String login, final String password) {

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
