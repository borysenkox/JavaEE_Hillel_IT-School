package com.hillel.servlets;

import com.hillel.dao.UserDao;
import com.hillel.model.User;
import com.hillel.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/management/user")
public class UpdateUserServlet extends HttpServlet {
    private UserDao userDao;
    private UserService userService;

    @Override
    public void init() {
        userService = (UserService) getServletContext().getAttribute("userService");
        userDao = (UserDao) getServletContext().getAttribute("storage");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String currentUsername = req.getParameter("username");
        User user = userService.getUserByUsername(currentUsername);
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/view/updateUser.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String currentUsername = req.getParameter("username");
        User updatedUser = new User(req.getParameter("firstName"), req.getParameter("lastName"), req.getParameter("username"));
        userDao.updateUser(currentUsername, updatedUser);
        resp.sendRedirect("/management");
    }
}
