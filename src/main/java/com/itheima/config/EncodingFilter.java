package com.itheima.config;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
//import javax.servlet.annotation.WebFilter;
import java.io.IOException;
@WebFilter(servletNames = {"encodingServlet"},filterName="encodingFilter",urlPatterns="/*")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig){}

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletRequest.setCharacterEncoding("utf8");
        servletResponse.setCharacterEncoding("utf8");
        servletResponse.setContentType("text/html;charset=UTF-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy(){}
}
