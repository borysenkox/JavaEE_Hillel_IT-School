package com.hillel.servlets;

import com.hillel.dao.UserDao;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

import static org.mockito.Mockito.when;

public class DeleteUserServletTest {
    @InjectMocks
    private DeleteUserServlet deleteUserServlet;

    @Mock
    private UserDao userDao;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private ServletContext servletContext;
    @Mock
    private ServletConfig servletConfig;

    @Before
    public void setUpInstances() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void initServletConfig() throws ServletException {
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        deleteUserServlet.init(servletConfig);
    }

    @Test
    public void doPost_ReturnsRedirectPath() throws IOException {
        when(userDao.deleteUser("userForDelete")).thenReturn(true);
        deleteUserServlet.doPost(request, response);
    }
}