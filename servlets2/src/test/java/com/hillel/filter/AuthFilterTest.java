package com.hillel.filter;

import org.junit.Before;
import org.junit.Test;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class AuthFilterTest {
    private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher requestDispatcher;
    private HttpSession session;
    private FilterChain filterChain;

    @Before
    public void setUp() {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        requestDispatcher = mock(RequestDispatcher.class);
        session = mock(HttpSession.class);
        filterChain = mock(FilterChain.class);
    }

    @Test
    public void doFilter_returnsMapping() throws IOException, ServletException {
        AuthFilter authFilter = new AuthFilter();
        FilterConfig config = mock(FilterConfig.class);
        authFilter.init(config);

        when(request.getSession()).thenReturn(session);

        when(request.getSession().getAttribute("role")).thenReturn("admin");
        assertEquals(request.getSession().getAttribute("role"), "admin");
        when(request.getRequestDispatcher("/WEB-INF/view/adminMenu.jsp")).thenReturn(requestDispatcher);

        when(request.getSession().getAttribute("role")).thenReturn("user");
        assertEquals(request.getSession().getAttribute("role"), "user");
        when(request.getRequestDispatcher("/WEB-INF/view/userMenu.jsp")).thenReturn(requestDispatcher);

        when(request.getRequestDispatcher("/WEB-INF/view/login.jsp")).thenReturn(requestDispatcher);
        when(request.getRequestURI()).thenReturn("/user/login/");

        authFilter.doFilter(request, response, filterChain);
        authFilter.destroy();
    }
}