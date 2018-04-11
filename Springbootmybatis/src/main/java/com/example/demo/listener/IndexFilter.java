package com.example.demo.listener;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebFilter(urlPatterns = "/*", filterName = "indexFilter")
public class IndexFilter implements Filter {
    Log log = LogFactory.getLog(IndexFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
//        log.info("init IndexFilter");
    	System.out.println("过滤器初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        log.info("doFilter IndexFilter");
    	System.out.println("执行过滤操作");
//        filterChain.doFilter(servletRequest,servletResponse);

    }

    @Override
    public void destroy() {
    	System.err.println("销毁过滤器");
    }
}