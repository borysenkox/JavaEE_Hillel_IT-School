package com.hillel.listener;

import com.hillel.service.UserService;
import org.junit.Test;
import org.mockito.Mock;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ContextListenerTest {
    @Mock
    private UserService userService;
    @Mock
    private UserService userDao;
    @Mock
    private UserService user;
    @Mock
    private UserService jsonUtil;

    @Test
    public void contextInitialized(){
        ContextListener contextListener = new ContextListener();

        ServletContext servletContext = mock(ServletContext.class);
        ServletContextEvent servletContextEvent = mock(ServletContextEvent.class);

        when(servletContextEvent.getServletContext()).thenReturn(servletContext);
        assertEquals(servletContext.getInitParameter("userService"), userService);
        assertEquals(servletContext.getInitParameter("storage"), userDao);
        assertEquals(servletContext.getInitParameter("user"), user);
        assertEquals(servletContext.getInitParameter("jsonUtil"), jsonUtil);

        contextListener.contextInitialized(servletContextEvent);
    }

}