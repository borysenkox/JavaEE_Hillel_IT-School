package com.hillel.service;

import com.hillel.dao.UserDao;
import com.hillel.model.User;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class UserServiceTest {
    private UserService userService;
    private User expectedUser;
    @Before
    public void setUp() {
        userService = new UserService(new UserDao());
        expectedUser = new User("Alex", "Popov", "alex", "alex", "not_logged-in", "user");
    }

    @Test
    public void userIsExist_returnsTrue() {
        boolean actual = userService.userIsExist("admin");
        assertThat(actual, equalTo(true));
    }

    @Test
    public void userIsExist_returnsFalse() {
        boolean actual = userService.userIsExist("someUsername");
        assertThat(actual, equalTo(false));
    }

    @Test
    public void userIsExistByLoginAndPassword_returnsTrue() {
        boolean actual = userService.userIsExistByLoginAndPassword("admin", "admin");
        assertThat(actual, equalTo(true));
    }

    @Test
    public void userIsExistByLoginAndPassword_returnsFalse() {
        boolean actual = userService.userIsExistByLoginAndPassword("someUsername", "somePassword");
        assertThat(actual, equalTo(false));
    }

    @Test
    public void updateLogin_returnsStatusLogged_in() {
        String status = userService.updateLoginStatus("admin");
        assertThat(status, equalTo("logged-in"));
    }

    @Test
    public void updateLoginStatus_returnsStatusNot_logged_in() {
        String status = userService.updateLoginStatus("someUser");
        assertThat(status, equalTo("not_logged-in"));
    }

    @Test
    public void getUserByUsername_returnsUserByUsername() {
        User actualUser = userService.getUserByUsername("alex");
        assertThat(expectedUser, equalTo(actualUser));
    }

    @Test
    public void getUserByUsername_returnsNullIfUserDoesNotExist() {
        User actualUser = userService.getUserByUsername("someUser");
        assertThat(actualUser, equalTo(null));
    }

    @Test
    public void getListOfUsers_returnsListOfUsers() {
        List<User> users = userService.getListOfUsers();
        assertThat(users, equalTo(userService.getListOfUsers()));
    }

    @Test
    public void logout() {
        userService.logout("alex");
    }
}