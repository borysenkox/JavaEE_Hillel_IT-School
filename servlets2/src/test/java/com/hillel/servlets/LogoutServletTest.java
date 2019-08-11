package com.hillel.servlets;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;
import static org.mockito.Mockito.times;

public class LogoutServletTest {
    private LogoutServlet logoutServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher dispatcher;
    private HttpSession session;
    private String path;

    @Before
    public void setUp() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        logoutServlet = new LogoutServlet();
        dispatcher = mock(RequestDispatcher.class);
        session = mock(HttpSession.class);
    }

    @Test
    public void doPost() throws IOException {
        path = "/";

        when(request.getParameter("username")).thenReturn("axle");
        when(request.getSession()).thenReturn(session);
        logoutServlet.doPost(request, response);

        verify(request, times(1)).getSession();
        verify(session, times(1)).invalidate();
        verify(response, times(1)).sendRedirect(path);
    }

}