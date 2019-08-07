package com.hillel.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/user/login/"})
public class AuthFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {
        //Empty method
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse resp = (HttpServletResponse) response;

        String uri = req.getRequestURI();
        HttpSession session = req.getSession();
        String userRole = (String) session.getAttribute("role");
        System.out.println(userRole);
        if (uri.endsWith("/user/login/") && (userRole.equals("admin"))) {
            req.getRequestDispatcher("/WEB-INF/view/adminMenu.jsp").forward(req, resp);
        } else if (uri.endsWith("/user/login/") && (userRole.equals("user"))) {
            req.getRequestDispatcher("/WEB-INF/view/userMenu.jsp").forward(req, resp);
        } else {
            req.getRequestDispatcher("/WEB-INF/view/login.jsp").forward(req, resp);
        }
    }

    @Override
    public void destroy() {
        //Empty method
    }
}
