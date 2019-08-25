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

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UpdateUserServletTest {
    private final static String PATH = "/WEB-INF/view/updateUser.jsp";

    @InjectMocks
    private UpdateUserServlet updateUserServlet;

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
    public void initServletConfig() throws ServletException {
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        updateUserServlet.init(servletConfig);
    }

    @Test
    public void doGet_WhenMethodCalled_SendForwardByPath() throws ServletException, IOException {
        when(request.getRequestDispatcher(PATH)).thenReturn(dispatcher);
        updateUserServlet.doGet(request, response);
    }

    @Test
    public void doPost_GettingRequestParameters_SettingNewUser_ReturnErrorOrRedirect() throws IOException {
        when(request.getParameter("username")).thenReturn("testUsername");
        when(request.getParameter("password")).thenReturn("testPassword");
        when(request.getParameter("firstName")).thenReturn("testFirstName");
        when(request.getParameter("lastName")).thenReturn("testLastName");
        when(userService.userIsExist("testUsername")).thenReturn(true);

        assertTrue(userService.userIsExist("testUsername"));
        updateUserServlet.doPost(request, response);

        when(userService.userIsExist("testUsername")).thenReturn(false);
        response.sendRedirect(PATH);
        updateUserServlet.doPost(request, response);
    }
}