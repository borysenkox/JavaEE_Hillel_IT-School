package com.hillel.listener;

import com.hillel.model.User;
import com.hillel.dao.UserDao;
import com.hillel.service.UserService;
import com.hillel.util.JsonUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        User user = new User();
        UserDao userDao = new UserDao();
        UserService userService = new UserService(userDao);
        JsonUtil jsonUtil = new JsonUtil();

        ServletContext servletContext = servletContextEvent.getServletContext();
        servletContext.setAttribute("userService", userService);
        servletContext.setAttribute("storage", userDao);
        servletContext.setAttribute("user", user);
        servletContext.setAttribute("jsonUtil", jsonUtil);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        //Empty method
    }

}
