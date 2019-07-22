package com.hillel.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.hillel.model.User;

import java.util.List;

public class JsonUtil {
    private Gson gson = new Gson();
    private Gson gsonBuilder = new GsonBuilder().create();

    public User jsonToUser(String json) {
        return gson.fromJson(json, User.class);
    }

    public String jsonFromUsersList(List<User> users) {
        String result = gsonBuilder.toJson(users);
        return result;
    }

    public String jsonFromUser(User user){
        String result = gsonBuilder.toJson(user);
        return result;
    }
}
