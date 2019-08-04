package com.hillel.servlets;

import com.hillel.dao.UserDao;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/management/user/delete")
public class DeleteUserServlet extends HttpServlet {
    private UserDao userDao;

    @Override
    public void init() {
        userDao = (UserDao) getServletContext().getAttribute("storage");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        userDao.deleteUser(req.getParameter("username"));
        resp.sendRedirect("/management");
    }
}
