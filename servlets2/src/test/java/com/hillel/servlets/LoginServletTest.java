package com.hillel.servlets;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.mockito.Mockito.*;

public class LoginServletTest {
    private LoginServlet loginServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private RequestDispatcher dispatcher;
    private String path;
    private String errorMessage;

    @Before
    public void setUp() {
        loginServlet = new LoginServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        dispatcher = mock(RequestDispatcher.class);
        path = "/WEB-INF/view/login.jsp";
    }

    @Test
    public void doGet() throws ServletException, IOException {
        when(request.getRequestDispatcher(path)).thenReturn(dispatcher);
        loginServlet.doGet(request, response);

        verify(request, times(1)).getRequestDispatcher(path);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void doPost_returnsSuccessLoginServlet() throws ServletException, IOException {
        errorMessage = "Bad request";

        when(request.getParameter("login")).thenReturn("admin");
        when(request.getParameter("password")).thenReturn("admin");
        when(request.getSession()).thenReturn(session);
        when(request.getContextPath()).thenReturn("/user/login");
        loginServlet.doPost(request, response);

        verify(request, times(1)).getParameter("login");
        verify(request, times(1)).getParameter("password");
//        verify(response, times(1)).sendError(400, errorMessage);
    }
}