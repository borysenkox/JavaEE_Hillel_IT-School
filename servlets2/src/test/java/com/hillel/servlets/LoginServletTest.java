package com.hillel.servlets;

import com.hillel.dao.UserDao;
import com.hillel.model.User;
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
import javax.servlet.http.HttpSession;

import java.io.IOException;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class LoginServletTest {
    @InjectMocks
    private LoginServlet loginServlet;

    @Mock
    private UserService userService;
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

    private final static String LOGINPATH= "/WEB-INF/view/login.jsp";
    private final static String ADMINPATH= "/WEB-INF/view/adminMenu.jsp";
    private final static String USERPATH= "/WEB-INF/view/userMenu.jsp";

    @Test
    public void initServletConfig() throws ServletException {
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        loginServlet.init(servletConfig);

        verify(servletConfig, atLeastOnce()).getServletContext();
    }

    @Test
    public void doPost_WhenMethodIsCalled_ReturnsInvalidUser() throws ServletException, IOException {
        when(request.getParameter(anyString())).thenReturn("notUser");
        when(userService.userIsExistByLoginAndPassword("notUser", "password")).thenReturn(false);
        when(request.getRequestDispatcher(LOGINPATH)).thenReturn(dispatcher);
        loginServlet.doPost(request, response);

        verify(request, atLeastOnce()).getRequestDispatcher(LOGINPATH);
        verify(dispatcher).forward(request, response);
    }

}