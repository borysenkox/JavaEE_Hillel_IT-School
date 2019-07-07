package com.hillel.servlets.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import com.hillel.dao.UserDAO;

@WebServlet("/user")
public class UserServlet extends HttpServlet {
    private AtomicReference<UserDAO> dao;

    @Override
    public void init() {
        dao = (AtomicReference<UserDAO>) getServletContext().getAttribute("dao");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("dao", dao);
        System.out.println(dao);
    }
}
