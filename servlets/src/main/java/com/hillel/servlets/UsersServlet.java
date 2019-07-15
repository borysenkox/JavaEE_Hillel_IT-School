package com.hillel.servlets;

import com.hillel.model.User;
import com.hillel.service.UserService;
import com.hillel.util.JsonUtil;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<User> users = userService.getListOfUsers();
        JsonUtil toJson = new JsonUtil();
        resp.getWriter().println(toJson.jsonFromUsersList(users));
    }
}
