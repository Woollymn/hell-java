package com.hell_board.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by hkkang on 2016. 7. 27..
 */
public class CharacterSetFilter implements Filter {
    private String encoding;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.encoding = filterConfig.getInitParameter("requestEncoding");

        if (this.encoding == null) {
            this.encoding = "UTF-8";
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain)
            throws IOException, ServletException {

        if(servletRequest.getCharacterEncoding() == null) {
            servletRequest.setCharacterEncoding(this.encoding);
        }

        servletResponse.setCharacterEncoding(this.encoding);

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {}
}
