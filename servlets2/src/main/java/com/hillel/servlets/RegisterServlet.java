package com.hillel.servlets;

import com.hillel.dao.UserDao;
import com.hillel.model.User;
import com.hillel.service.UserService;
import lombok.extern.log4j.Log4j;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/user/register")
@Log4j
public class RegisterServlet extends HttpServlet {
    private UserService userService;
    private UserDao userDao;

    @Override
    public void init(ServletConfig config) {
        userService = (UserService) config.getServletContext().getAttribute("userService");
        userDao = (UserDao) config.getServletContext().getAttribute("storage");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/register.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        if (!firstName.isEmpty() && !username.isEmpty() && !password.isEmpty() && !lastName.isEmpty()) {
            if (userService.userIsExist(username)) {
                resp.sendError(404, username + " is already exists");
            } else {
                User u = new User();
                u.setFirstName(firstName);
                u.setLastName(lastName);
                u.setUsername(username);
                u.setPassword(password);
                u.setRole("user");
                u.setStatus("not_logged-in");
                userDao.createUser(u);
                resp.sendRedirect("/user/login");
            }
            log.info("RegisterServlet class - doPost() called - user created");
        }
    }
}
