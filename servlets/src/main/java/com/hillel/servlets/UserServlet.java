package com.hillel.servlets;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import com.hillel.dao.UserDao;
import com.hillel.model.User;
import com.hillel.service.UserService;
import com.hillel.util.JsonUtil;
import lombok.Getter;
import lombok.Setter;

@WebServlet("/user")
@Setter
@Getter
public class UserServlet extends HttpServlet {
    private UserDao userDao;
    private UserService userService;
    private JsonUtil jsonUtil;

    @Override
    public void init() {
        userDao = (UserDao) getServletContext().getAttribute("userDao");
        userService = (UserService) getServletContext().getAttribute("userService");
        jsonUtil = (JsonUtil) getServletContext().getAttribute("jsonUtil");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String usernameFromParameters = req.getParameter("username");
        User user = userService.getUserByUsername(usernameFromParameters);
        if (user != null) {
            PrintWriter out = resp.getWriter();
            out.println(jsonUtil.jsonFromUser(user));
        } else {
            resp.sendError(404, "User not found");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        User user = jsonUtil.jsonToUser(br.readLine());

        if (user != null && user.getUsername() != null && user.getPassword() != null && user.getFirstName() != null
                && !userService.userIsExist(user.getUsername(), user.getPassword())) {
            if (!user.getLastName().isEmpty()) {
                user.setLastName(user.getLastName());
            }
            if (userDao.createUser(user)) {
                req.setAttribute("user", user);
                resp.sendRedirect(req.getContextPath());
            }
        } else {
            resp.sendError(400, "Bad request");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        User modifiedUser = jsonUtil.jsonToUser(br.readLine());

        if (modifiedUser != null) {
            if (userDao.updateUser(req.getParameter("username"), modifiedUser)) {
            }
        } else {
            resp.sendError(404, "Unregistered user");
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        if (userDao.deleteUser(req.getParameter("username"))) {
        } else {
            resp.sendError(404, "Unregistered user");
        }
    }
}
