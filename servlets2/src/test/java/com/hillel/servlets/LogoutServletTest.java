package com.hillel.servlets;

import com.hillel.service.UserService;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class LogoutServletTest {
    private final static String PATH = "/";

    @InjectMocks
    private LogoutServlet logoutServlet;

    @Mock
    private UserService userService;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher dispatcher;
    @Mock
    private HttpSession session;
    @Mock
    private ServletConfig servletConfig;
    @Mock
    private ServletContext servletContext;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void init_ReturnsServletContext() throws ServletException {
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        when(servletConfig.getServletContext().getAttribute("userService")).thenReturn(userService);
        logoutServlet.init(servletConfig);
    }

    @Test
    public void doPost_GettingUsernameFromSession_ReturnsRedirect() throws IOException{
        when(request.getSession()).thenReturn(session);
        when(request.getSession().getAttribute("username")).thenReturn("admin");
        when(request.getRequestDispatcher(PATH)).thenReturn(dispatcher);
        logoutServlet.doPost(request, response);
    }
}