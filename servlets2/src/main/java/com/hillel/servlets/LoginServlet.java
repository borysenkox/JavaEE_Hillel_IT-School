package com.hillel.servlets;

import com.hillel.model.User;
import com.hillel.service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/user/login")
public class LoginServlet extends HttpServlet {
    private UserService userService;

    @Override
    public void init() {
        userService = (UserService) getServletContext().getAttribute("userService");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();

        if (userService.userIsExistByLoginAndPassword(login, password)) {
            userService.updateLoginStatus(login);
            User currentUser = userService.getUserByUsername(login);
            session.setAttribute("username", currentUser.getUsername());
            session.setAttribute("firstName", currentUser.getFirstName());
            session.setAttribute("lastName", currentUser.getLastName());
            session.setAttribute("role", currentUser.getRole());
            session.setAttribute("status", currentUser.getStatus());

            if (currentUser.getRole().equals("admin")) {
                req.getRequestDispatcher("/WEB-INF/view/adminMenu.jsp").forward(req, resp);
            } else if (currentUser.getRole().equals("user")) {
                req.getRequestDispatcher("/WEB-INF/view/userMenu.jsp").forward(req, resp);
            }
        } else {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        }
    }

}
