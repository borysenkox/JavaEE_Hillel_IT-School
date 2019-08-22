package com.hillel.servlets;

import com.hillel.dao.UserDao;
import com.hillel.model.User;
import com.hillel.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserServletTest {

    @InjectMocks
    private UserServlet userServlet;
    @Mock
    private UserDao userDao;
    @Mock
    private UserService userService;
    @Mock
    private User user;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private ServletContext servletContext;
    @Mock
    private ServletConfig servletConfig;

    @Test
    public void initServletConfig() throws ServletException {
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        userServlet.init(servletConfig);
    }

    @Test
    public void doGet_GetRequestUsernameParameter() {
        when(request.getParameter("username")).thenReturn("someUserName");
        when(user.getUsername()).thenReturn("someUserName");
        when(userService.getUserByUsername("someUserName")).thenReturn(user);
    }

    @Test
    public void doPut_getRequestParameters_sendErrorOrUpdateUser() {
        when(request.getParameter("username")).thenReturn("someUserName");
        when(request.getParameter("firstname")).thenReturn("someFirstName");
        when(request.getParameter("lastname")).thenReturn("someLastName");

        Assert.assertFalse(request.getParameter("username").isEmpty());
        Assert.assertFalse(userService.userIsExist("someUserName"));
    }

    @Test
    public void doDelete_getUsernameFromRequest_sendErrorOrDeleteUser() throws IOException {
        when(request.getParameter("username")).thenReturn("User");

        Assert.assertFalse(request.getParameter("username").isEmpty());
        Assert.assertFalse(userService.userIsExist("User"));

        when(userService.userIsExist("User")).thenReturn(true);
        userServlet.doDelete(request, response);

        when(request.getParameter("username")).thenReturn("");
        userServlet.doDelete(request, response);

        when(request.getParameter("username")).thenReturn("User2");
        when(userService.userIsExist("User2")).thenReturn(false);
        userServlet.doDelete(request, response);
    }

}