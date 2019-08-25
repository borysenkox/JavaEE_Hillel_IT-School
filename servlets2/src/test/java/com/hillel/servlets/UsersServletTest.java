package com.hillel.servlets;

import com.google.gson.Gson;
import com.hillel.dao.UserDao;
import com.hillel.model.User;
import com.hillel.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class UsersServletTest {

    @InjectMocks
    private UsersServlet usersServlet;

    @Mock
    private UserDao storage;
    @Mock
    private UserService userService;
    @Mock
    private HttpServletRequest request;
    @Mock
    private HttpServletResponse response;
    @Mock
    private ServletConfig servletConfig;
    @Mock
    private ServletContext servletContext;

    @Test
    public void initServletConfig() {
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        usersServlet.init(servletConfig);

        verify(servletConfig, atLeastOnce()).getServletContext();
    }

    @Test
    public void doGet_GettingListOfUsers_ReturnsJson() throws IOException {
        List<User> actualList = storage.listOfUsers();
        when(userService.getListOfUsers()).thenReturn(actualList);

        String jsonFromJavaArrayList = new Gson().toJson(actualList);
        PrintWriter printWriter = new PrintWriter(jsonFromJavaArrayList);
        when(response.getWriter()).thenReturn(printWriter);
        usersServlet.doGet(request, response);

        verify(response, atLeastOnce()).getWriter();
    }

    @Test
    public void doGet_GettingListOfUsers_ReturnsNull() throws IOException {
        when(userService.getListOfUsers()).thenReturn(null);
        usersServlet.doGet(request, response);

        verify(response, atLeastOnce()).sendError(404, "User not found");
    }

}