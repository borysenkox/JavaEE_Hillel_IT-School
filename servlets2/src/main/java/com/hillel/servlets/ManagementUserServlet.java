package com.hillel.servlets;

import com.hillel.dao.UserDao;
import com.hillel.model.User;
import com.hillel.service.UserService;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/management")
@Log4j
public class ManagementUserServlet extends HttpServlet {
    private UserDao userDao;
    private UserService userService;

    @Override
    public void init() {
        userDao = (UserDao) getServletContext().getAttribute("storage");
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("users", userDao.listOfUsers());
        req.getRequestDispatcher("WEB-INF/view/management.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String status = "not_logged-in";
        String role = req.getParameter("role");

        if (!userService.userIsExist(username) && !firstName.isEmpty() && !lastName.isEmpty() && !username.isEmpty() && !password.isEmpty()) {
            User newUser = new User(firstName, lastName, username, password, status, role);
            userDao.createUser(newUser);
            doGet(req, resp);
        } else {
            doGet(req, resp);
        }
    }
}
