package com.hillel.servlets;

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

import java.io.IOException;

import static org.mockito.Mockito.when;

public class ManagementUserServletTest {
    private final static String PATH = "WEB-INF/view/management.jsp";

    @InjectMocks
    private ManagementUserServlet managementUserServlet;
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

    @Before
    public void setUpInstances() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void initServletConfig() throws ServletException {
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        managementUserServlet.init(servletConfig);
    }

    @Test
    public void doGet_WhenMethodCalled_SendForwardByPath() throws ServletException, IOException {
        when(request.getRequestDispatcher(PATH)).thenReturn(dispatcher);
        managementUserServlet.doGet(request, response);
    }

    @Test
    public void doPost_GettingRequestParameters() throws IOException, ServletException {
        when(request.getParameter("firstName")).thenReturn("testFirstName");
        when(request.getParameter("lastName")).thenReturn("testLastName");
        when(request.getParameter("username")).thenReturn("testUsername");
        when(request.getParameter("password")).thenReturn("testPassword");
        when(request.getParameter("status")).thenReturn("not_logged-in");
        when(request.getParameter("role")).thenReturn("role");

        when(userService.userIsExist("testUsername")).thenReturn(true);
//        managementUserServlet.doPost(request, response);
    }

}