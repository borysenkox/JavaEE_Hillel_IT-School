package com.hillel.servlets;

import com.hillel.dao.UserDao;
import com.hillel.model.User;
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

public class LoginServletTest {
    @InjectMocks
    private LoginServlet loginServlet;

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
    private RequestDispatcher dispatcher;
    @Mock
    private ServletConfig servletConfig;
    @Mock
    private ServletContext servletContext;
    @Mock
    private HttpSession session;

    private final static String LOGINPATH = "/WEB-INF/view/login.jsp";
    private final static String ADMINPATH = "/WEB-INF/view/adminMenu.jsp";
    private final static String USERPATH = "/WEB-INF/view/userMenu.jsp";

    @Before
    public void setUpInstances() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void initServletConfig() throws ServletException {
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        loginServlet.init(servletConfig);
    }

    @Test
    public void doGet_WhenMethodIsCalled_SendForwardToLoginPath() throws ServletException, IOException {
        when(request.getRequestDispatcher(LOGINPATH)).thenReturn(dispatcher);
        loginServlet.doGet(request, response);
    }


    @Test
    public void doPost_WhenMethodIsCalled_ReturnsLoginMenu() throws ServletException, IOException {
        when(userService.userIsExistByLoginAndPassword("notUser", "notPassword")).thenReturn(false);
        when(userService.getUserByUsername("notUser")).thenReturn(user);
        when(request.getSession()).thenReturn(session);
        when(request.getRequestDispatcher(LOGINPATH)).thenReturn(dispatcher);
        loginServlet.doPost(request, response);

    }
}