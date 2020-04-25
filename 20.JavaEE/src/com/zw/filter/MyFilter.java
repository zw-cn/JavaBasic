package com.zw.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * <p>Title: JavaBasic-com.zw.filter</p>
 * <p>Description: 过滤器</p>
 * <p>Copyright: Copyright (c) 2020</p>
 * <p>Company: www.zw.com</p>
 *
 * @author zw-cn
 * @version 1.0
 * @date 4/24/2020
 */
public class MyFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("MyFilter.doFilter-start");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("MyFilter.doFilter-end");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("MyFilter.init");
    }

    @Override
    public void destroy() {
        System.out.println("MyFilter.destroy");
    }
}
