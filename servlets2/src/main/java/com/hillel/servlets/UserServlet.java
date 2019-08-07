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
import lombok.extern.log4j.Log4j;

@WebServlet("/user")
@Log4j
public class UserServlet extends HttpServlet {
    private UserDao userDao;
    private UserService userService;
    private JsonUtil jsonUtil;

    @Override
    public void init() {
        userDao = (UserDao) getServletContext().getAttribute("storage");
        userService = (UserService) getServletContext().getAttribute("userService");
        jsonUtil = (JsonUtil) getServletContext().getAttribute("jsonUtil");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("UserServlet class - doGet() called");
        String usernameFromParameters = req.getParameter("username");
        User user = userService.getUserByUsername(usernameFromParameters);
        if (user != null) {
            PrintWriter out = resp.getWriter();
            out.println(jsonUtil.jsonFromUser(user));
        } else {
            resp.sendError(404, "User not found");
            log.error("Error in UserServlet class (doGet) - 404 NOT FOUND : unregistered user");
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("UserServlet class - doPost() called");
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        User user = jsonUtil.jsonToUser(br.readLine());

        if (user != null && user.getUsername() != null && user.getPassword() != null && user.getFirstName() != null
                && !userService.userIsExist(user.getUsername())) {
            if (!user.getLastName().isEmpty()) {
                user.setLastName(user.getLastName());
            }
            if (userDao.createUser(user)) {
                req.setAttribute("user", user);
                resp.sendRedirect(req.getContextPath());
                log.info("User has been created");
            }
        } else {
            resp.sendError(400, "Bad request");
            log.error("Error in UserServlet class (doPost) - 400 BAD REQUEST : user has not been created");
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("UserServlet class - doPut() called");
        BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
        User modifiedUser = jsonUtil.jsonToUser(br.readLine());

        if (modifiedUser != null) {
            if (userDao.updateUser(req.getParameter("username"), modifiedUser)) {
                log.info("User has been updated");
            }
        } else {
            resp.sendError(404, "Unregistered user");
            log.error("Error in UserServlet class (doPut) - 404 NOT FOUND : unregistered user");
        }
    }

    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        log.info("UserServlet class - doDelete() called");
        if (userDao.deleteUser(req.getParameter("username"))) {
            log.info("User had been deleted");
        } else {
            resp.sendError(404, "Unregistered user");
            log.error("Error in UserServlet class (doDelete) - 404 NOT FOUND : unregistered user");
        }
    }
}
