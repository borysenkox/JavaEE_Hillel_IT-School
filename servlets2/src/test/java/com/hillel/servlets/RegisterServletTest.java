package com.hillel.servlets;

import com.hillel.dao.UserDao;
import com.hillel.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RegisterServletTest {
    private final static String PATH = "/WEB-INF/view/register.jsp";

    @InjectMocks
    private RegisterServlet registerServlet;

    @Mock
    private UserDao userDao;
    @Mock
    private UserService userService;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private RequestDispatcher dispatcher;
    @Mock
    private ServletContext servletContext;
    @Mock
    private ServletConfig servletConfig;

    @Test
    public void initServletConfig() {
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        registerServlet.init(servletConfig);
    }

    @Test
    public void doGet_WhenMethodCalled_SendForwardByPath() throws ServletException, IOException {
        when(request.getRequestDispatcher(PATH)).thenReturn(dispatcher);
        registerServlet.doGet(request, response);
    }

    @Test
    public void doPost_GettingRequestParameters_SettingNewUser_ReturnErrorOrRedirect() throws IOException {
        when(request.getParameter("username")).thenReturn("testUsername");
        when(request.getParameter("password")).thenReturn("testPassword");
        when(request.getParameter("firstName")).thenReturn("testFirstName");
        when(request.getParameter("lastName")).thenReturn("testLastName");
        when(userService.userIsExist("testUsername")).thenReturn(true);

        assertTrue(userService.userIsExist("testUsername"));
        response.sendError(404, "");
        registerServlet.doPost(request, response);

        when(userService.userIsExist("testUsername")).thenReturn(false);
        response.sendRedirect("");
        registerServlet.doPost(request, response);
    }
}