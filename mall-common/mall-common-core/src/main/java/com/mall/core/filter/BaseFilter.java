//package com.mall.core.filter;
//
//import com.mall.core.constant.AuthConstant;
//import org.springframework.stereotype.Component;
//
//import javax.servlet.*;
//import javax.servlet.annotation.WebFilter;
//import javax.servlet.http.HttpServletRequest;
//import java.io.IOException;
//
///**
// * 请求拦截，避免服务绕过接口被直接访问
// */
//@Component
//@WebFilter(filterName = "BaseFilter",urlPatterns = {"/admin/**"})
//public class BaseFilter implements Filter {
//    @Override
//    public void init(FilterConfig filterConfig) throws ServletException {
//    }
//
//    @Override
//    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//        HttpServletRequest request = (HttpServletRequest)servletRequest;
//        String gateway = request.getHeader(AuthConstant.GATEWAY_KEY_HEADER);
//        if(gateway == null || !gateway.equals(AuthConstant.GATEWAY_KEY)){
//            return;
//        }
//        filterChain.doFilter(servletRequest, servletResponse);
//    }
//
//    @Override
//    public void destroy() {
//    }
//
//}
