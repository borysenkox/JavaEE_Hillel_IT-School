package com.hillel.servlets;

import com.hillel.model.User;
import com.hillel.service.UserService;
import com.hillel.util.JsonUtil;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/users")
@Log4j
public class UsersServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init(ServletConfig config) {
        userService = (UserService) config.getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("UsersServlet class - doGet() called");
        List<User> users = userService.getListOfUsers();
        if (users != null) {
            JsonUtil toJson = new JsonUtil();
            resp.getWriter().println(toJson.jsonFromUsersList(users));
        } else {
            resp.sendError(404, "User not found");
            log.error("Error in UsersServlet class (doGet) - 404 NOT FOUND");
        }
    }
}
