package com.hillel.listener;

import org.junit.Test;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ContextListenerTest {

    @Test
    public void contextInitialized(){
        ContextListener contextListener = new ContextListener();

        ServletContext servletContext = mock(ServletContext.class);
        ServletContextEvent servletContextEvent = mock(ServletContextEvent.class);

        when(servletContextEvent.getServletContext()).thenReturn(servletContext);
        contextListener.contextInitialized(servletContextEvent);
    }

}