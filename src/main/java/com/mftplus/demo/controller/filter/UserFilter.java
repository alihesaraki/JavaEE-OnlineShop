package com.mftplus.demo.controller.filter;

import com.mftplus.demo.model.utils.Loggable;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
@Slf4j
@WebFilter(urlPatterns = "/user")
public class UserFilter implements Filter {
    public UserFilter() {
        log.info("UserFilter constructor");
    }
    @Override
    @Loggable
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("UserFilter doFilter");
        filterChain.doFilter(servletRequest, servletResponse);
        servletRequest.getRequestDispatcher("roleTest.html").forward(servletRequest, servletResponse);
//        ((HttpServletRequest)servletRequest).getSession().getAttribute("user");
    }
}
