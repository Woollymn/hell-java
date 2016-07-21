package com.example.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by hkkang on 2016. 7. 21..
 */
public class DefaultFilter implements Filter {

    private RequestDispatcher defaultReqeustDispatcher;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.defaultReqeustDispatcher =
                filterConfig.getServletContext().getNamedDispatcher("default");
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {}
}
