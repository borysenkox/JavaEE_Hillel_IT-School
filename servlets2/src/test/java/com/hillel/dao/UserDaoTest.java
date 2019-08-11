package com.hillel.dao;

import com.hillel.model.User;
import com.hillel.service.UserService;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class UserDaoTest {
    private UserService userService;
    private UserDao userDao;
    private User newUser;
    private User existedUser;

    @Before
    public void setUp() {
        userDao = new UserDao();
        userService = new UserService(new UserDao());
        newUser = new User("James", "Bond", "jbond", "777", "not_logged-in", "user");
        existedUser = userService.getUserByUsername("alex");
    }

    @Test
    public void createUser_returnsTrue() {
        boolean actual = userDao.createUser(newUser);
        assertThat(actual, equalTo(true));
    }

    @Test
    public void createUser_returnsFalse() {
        boolean actual = userDao.createUser(existedUser);
        assertThat(actual, equalTo(false));
    }

    @Test
    public void updateUser_returnsTrue() {
        boolean actual = userDao.updateUser("alex", newUser);
        assertThat(actual, equalTo(true));
    }

    @Test
    public void updateUser_returnsFalse() {
        boolean actual = userDao.updateUser("alex", existedUser);
        assertThat(actual, equalTo(false));
    }

    @Test
    public void deleteUser_returnsTrue() {
        boolean actual = userDao.deleteUser("alex");
        assertThat(actual, equalTo(true));
    }

    @Test
    public void deleteUser_returnsFalse() {
        boolean actual = userDao.deleteUser("someUser");
        assertThat(actual, equalTo(false));
    }

    @Test
    public void usernameIsExist_returnsTrue() {
        boolean actual = userDao.usernameIsExist("alex");
        assertThat(actual, equalTo(true));
    }

    @Test
    public void usernameIsExist_returnsFalse() {
        boolean actual = userDao.usernameIsExist("someUser");
        assertThat(actual, equalTo(false));
    }

    @Test
    public void listOfUsers() {
    }
}