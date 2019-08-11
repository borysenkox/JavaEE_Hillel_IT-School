package com.hillel.util;

import com.hillel.model.User;
import org.junit.*;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.*;

public class JsonUtilTest {
    private User user;
    private JsonUtil jsonUtil;
    private List<User> users;
    private static final String JSON = ("{\"firstName\":\"Sergey\",\"lastName\":\"Borysenko\",\"username\":\"admin\"," +
            "\"password\":\"admin\",\"status\":\"not_logged-in\",\"role\":\"admin\"}");
    private static final String JSON_LIST = ("[{\"firstName\":\"Sergey\",\"lastName\":\"Borysenko\",\"username\":\"admin\"," +
            "\"password\":\"admin\",\"status\":\"not_logged-in\",\"role\":\"admin\"},{\"firstName\":\"Alex\"," +
            "\"lastName\":\"Popov\",\"username\":\"alex\",\"password\":\"alex\",\"status\":\"not_logged-in\",\"role\":\"user\"}]");

    @Before
    public void setUp() {
        users = new ArrayList<>();
        jsonUtil = new JsonUtil();
        user = new User("Sergey", "Borysenko", "admin", "admin", "not_logged-in", "admin");
        users.add(user);
        users.add(new User("Alex", "Popov", "alex", "alex", "not_logged-in", "user"));
    }

    @Test
    public void jsonToUser_returnsUser() {
        User actualUser = jsonUtil.jsonToUser(JSON);
        assertThat(actualUser, equalTo(user));
    }

    @Test
    public void jsonFromUsersList_returnsJson() {
        String actualListOfJson = jsonUtil.jsonFromUsersList(users);
        assertThat(actualListOfJson, equalTo(JSON_LIST));
    }

    @Test
    public void jsonFromUser_returnsJson() {
        String actualJson = jsonUtil.jsonFromUser(user);
        assertThat(actualJson, equalTo(JSON));
    }
}