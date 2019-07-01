package com.hillel.listener;

import com.hillel.dao.UserDAO;
import com.hillel.model.User;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.concurrent.atomic.AtomicReference;

import static com.hillel.model.User.ROLE.ADMIN;
import static com.hillel.model.User.ROLE.USER;

@WebListener
public class ContextListener implements ServletContextListener {
    private AtomicReference<UserDAO> dao;

    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {

        dao = new AtomicReference<>(new UserDAO());

        dao.get().add(new User(1, "Sergey", "Sergey", ADMIN));
        dao.get().add(new User(2, "Alex", "Alex", USER));
        dao.get().add(new User(3, "Julia", "Julia", USER));

        final ServletContext servletContext = servletContextEvent.getServletContext();

        servletContext.setAttribute("dao", dao);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        dao = null;
    }
}
