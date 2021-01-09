package com.wall.myproject4test.springboot.demo4filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;


/** 
* @Description: 自定义过滤器
* @Author: zhang.zw
* @Date: 2021/1/9 
*/
@WebFilter(urlPatterns = "/mySwagger4Io/*")
public class MyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("--------init---------");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("------before-------");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("------end-------");
    }

    @Override
    public void destroy() {
        System.out.println("---------destory-----------");
    }
}
