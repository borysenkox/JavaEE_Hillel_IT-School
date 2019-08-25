package com.hillel.servlets;

import com.hillel.dao.UserDao;
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

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
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

    @Test
    public void initServletConfig() throws ServletException {
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        deleteUserServlet.init(servletConfig);

        verify(servletConfig, atLeastOnce()).getServletContext();
    }

    @Test
    public void doPost_ReturnsRedirectPath() throws IOException {
        when(userDao.deleteUser("userForDelete")).thenReturn(true);
        deleteUserServlet.doPost(request, response);

        verify(response, atLeastOnce()).sendRedirect("/management");
    }
}