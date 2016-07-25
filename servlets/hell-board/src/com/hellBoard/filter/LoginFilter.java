package com.hellBoard.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by hkkang on 2016. 7. 21..
 */
public class LoginFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        HttpSession session = request.getSession(false);
        String mainURI = request.getContextPath() + "/";

        boolean loggedIn = session != null && session.getAttribute("user") != null;
        boolean loginRequest = request.getRequestURI().equals(mainURI);

        if (loggedIn || loginRequest) {
            filterChain.doFilter(servletRequest, servletResponse);
        } else {
            response.sendRedirect(mainURI);
        }
    }

    @Override
    public void destroy() {}
}
